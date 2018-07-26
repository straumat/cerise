package com.oakinvest.cerise.test;

import com.oakinvest.cerise.dto.Mode;
import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensParameters;
import com.oakinvest.cerise.service.MockedSupportedCurrencyPairTokensService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Enumerating supported currency-pair tokens.
 *
 * @author straumat
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SupportedCurrencyPairTokensTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MockedSupportedCurrencyPairTokensService service;

    /**
     * Test for Enumerating supported currency-pair tokens results.
     */
    @Test
    public void getSupportedCurrencyPairTokensResults() throws Exception {
        // Testing all the data.
        mvc.perform(get("/")
                .param("mode", "list")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(not(containsString("\\n\\r"))))
                .andExpect(jsonPath("$", hasSize(3)))
                // First result.
                .andExpect(jsonPath("$[0].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[0].quote").value("USD"))
                .andExpect(jsonPath("$[0].base").value("XBT"))
                .andExpect(jsonPath("$[0].locale").value("en_US"))
                .andExpect(jsonPath("$[0].desc").value("Smoothed averages"))
                .andExpect(jsonPath("$[0].signature").isEmpty())
                // Second result.
                .andExpect(jsonPath("$[1].cp").value("2"))
                .andExpect(jsonPath("$[1].quote").value("USD"))
                .andExpect(jsonPath("$[1].base").value("XBT"))
                .andExpect(jsonPath("$[1].locale").value("en_US"))
                .andExpect(jsonPath("$[1].desc").value("Updated per-trade"))
                .andExpect(jsonPath("$[1].signature").isEmpty())
                // Third result.
                .andExpect(jsonPath("$[2].cp").value("XBTUSD-european"))
                .andExpect(jsonPath("$[2].quote").value("USD"))
                .andExpect(jsonPath("$[2].base").value("XBT"))
                .andExpect(jsonPath("$[2].locale").value("en_GB"))
                .andExpect(jsonPath("$[2].desc").isEmpty())
                .andExpect(jsonPath("$[2].signature").isEmpty());

        // Testing the generated parameters for the service.
        SupportedCurrencyPairTokensParameters p = service.getLastUsedParameter();
        assertEquals("Mode parameter value is wrong", Mode.list, p.getMode());
        assertTrue("Quote parameter is not empty", p.getQuote().isEmpty());
        assertTrue("Base parameter is not empty", p.getBase().isEmpty());
        assertTrue("Locales parameter is not empty", p.getLocales().isEmpty());
    }

    /**
     * Test for Enumerating supported currency-pair tokens parameters.
     */
    @Test
    public void getSupportedCurrencyPairTokensParameters() throws Exception {
        // Testing with quote and base parameters.
        mvc.perform(get("/")
                .param("mode", "list")
                .param("quote", "USD, AED")
                .param("base", "XBT, AFN")
                .param("locale", " en_US , en_GB ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        SupportedCurrencyPairTokensParameters p = service.getLastUsedParameter();
        assertEquals("Mode parameter value is wrong", Mode.list, p.getMode());
        assertEquals("Quote parameter is set", 2, p.getQuote().size());
        assertEquals("Quote parameter value", "USD", p.getQuote().get(0));
        assertEquals("Quote parameter value", "AED", p.getQuote().get(1));
        assertEquals("Base parameter not set", 2, p.getBase().size());
        assertEquals("Base parameter value", "XBT", p.getBase().get(0));
        assertEquals("Base parameter value", "AFN", p.getBase().get(1));
        assertEquals("Base parameter not set", 2, p.getLocales().size());
        assertEquals("Base parameter value", "en_US", p.getLocales().get(0));
        assertEquals("Base parameter value", "en_GB", p.getLocales().get(1));
    }

    /**
     * Test for Enumerating supported currency-pair tokens parameters.
     */
    @Test
    public void getSupportedCurrencyPairTokensWithInvalidCurrencyCode() throws Exception {
        // Wrong values of quotes.
        mvc.perform(get("/")
                .param("mode", "list")
                .param("quote", "USD, TOTO, AED, A, AAA, CCC")
                .param("base", "XBT, AFN")
                .param("locale", " en_US , en_GB "))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("Invalid currency codes"))
                .andExpect(jsonPath("errors", hasSize(2)))
                .andExpect(jsonPath("errors[0]").value("Invalid currency code : AAA"))
                .andExpect(jsonPath("errors[1]").value("Invalid currency code : CCC"));

        // Wrong values of quotes.
        mvc.perform(get("/")
                .param("mode", "list")
                .param("quote", "XBT, AFN")
                .param("base", "USD, TOTO, AED, A, BBB, DDD")
                .param("locale", " en_US , en_GB "))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("Invalid currency codes"))
                .andExpect(jsonPath("errors", hasSize(2)))
                .andExpect(jsonPath("errors[0]").value("Invalid currency code : BBB"))
                .andExpect(jsonPath("errors[1]").value("Invalid currency code : DDD"));
    }

}

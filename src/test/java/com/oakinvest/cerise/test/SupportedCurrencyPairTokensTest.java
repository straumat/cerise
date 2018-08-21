package com.oakinvest.cerise.test;

import com.oakinvest.cerise.dto.Mode;
import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensParameters;
import com.oakinvest.cerise.service.MockedSupportedCurrencyPairTokensService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.oakinvest.cerise.util.generic.CeriseErrorCode.currency_code_invalid;
import static com.oakinvest.cerise.util.generic.CeriseErrorCode.locale_invalid;
import static com.oakinvest.cerise.util.generic.CeriseErrorType.invalid_request_error;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Enumerating supported currency-pair tokens test.
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
     * Test for enumerating supported currency-pair tokens results.
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
                .andExpect(jsonPath("$[0].signature").doesNotExist())
                // Second result.
                .andExpect(jsonPath("$[1].cp").value("2"))
                .andExpect(jsonPath("$[1].quote").value("USD"))
                .andExpect(jsonPath("$[1].base").value("XBT"))
                .andExpect(jsonPath("$[1].locale").value("en_US"))
                .andExpect(jsonPath("$[1].desc").value("Updated per-trade"))
                .andExpect(jsonPath("$[1].signature").doesNotExist())
                // Third result.
                .andExpect(jsonPath("$[2].cp").value("XBTUSD-european"))
                .andExpect(jsonPath("$[2].quote").value("USD"))
                .andExpect(jsonPath("$[2].base").value("XBT"))
                .andExpect(jsonPath("$[2].locale").value("en_GB"))
                .andExpect(jsonPath("$[2].desc").doesNotExist())
                .andExpect(jsonPath("$[2].signature").doesNotExist());

        // Testing the generated parameters for the service.
        SupportedCurrencyPairTokensParameters p = service.getLastReceivedParameter();
        assertEquals("Mode parameter value is wrong", Mode.list, p.getMode());
        assertTrue("Quote parameter is not empty", p.getQuote().isEmpty());
        assertTrue("Base parameter is not empty", p.getBase().isEmpty());
        assertTrue("Locales parameter is not empty", p.getLocales().isEmpty());
    }

    /**
     * Test for enumerating supported currency-pair tokens parameters.
     */
    @Test
    public void getSupportedCurrencyPairTokensParameters() throws Exception {
        // Testing with quote and base parameters.
        mvc.perform(get("/")
                .param("mode", "list")
                .param("quote", "USD, AED")
                .param("base", "XBT, AFN")
                .param("locale", "en_US,en_GB")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        SupportedCurrencyPairTokensParameters p = service.getLastReceivedParameter();
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
     * Test parameters validation.
     */
    @Test
    public void testParametersValidation() throws Exception {
        // Wrong values of quotes and bases.
        mvc.perform(get("/")
                .param("mode", "list")
                .param("quote", "USD, TOTO, AED, A, AAA, CCC")
                .param("base", "XBT, AFN, EEE")
                .param("locale", " en_US , en_GB ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Invalid request to enumerating supported currency-pair"))
                .andExpect(jsonPath("errors", hasSize(3)))
                .andExpect(jsonPath("errors[0].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[0].message").value("Invalid currency code : AAA"))
                .andExpect(jsonPath("errors[1].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[1].message").value("Invalid currency code : CCC"))
                .andExpect(jsonPath("errors[2].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[2].message").value("Invalid currency code : EEE"));


        // Wrong values of locales.
        mvc.perform(get("/")
                .param("mode", "list")
                .param("quote", "XBT, AFN")
                .param("base", "XBT, AFN")
                .param("locale", " en_US , UU_UU, TOTO, en_GB, TATA ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Invalid request to enumerating supported currency-pair"))
                .andExpect(jsonPath("errors", hasSize(3)))
                .andExpect(jsonPath("errors[0].code").value(locale_invalid.toString()))
                .andExpect(jsonPath("errors[0].message").value("Invalid locale : UU_UU"))
                .andExpect(jsonPath("errors[1].code").value(locale_invalid.toString()))
                .andExpect(jsonPath("errors[1].message").value("Invalid locale : TOTO"))
                .andExpect(jsonPath("errors[2].code").value(locale_invalid.toString()))
                .andExpect(jsonPath("errors[2].message").value("Invalid locale : TATA"));

        // Several errors.
        mvc.perform(get("/")
                .param("mode", "list")
                .param("quote", "USD, TOTO, AED, A, AAA, CCC")
                .param("base", "XBT, AFN, EEE")
                .param("locale", " en_US , UU_UU, TOTO, en_GB, TATA ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Invalid request to enumerating supported currency-pair"))
                .andExpect(jsonPath("errors", hasSize(6)))
                .andExpect(jsonPath("errors[0].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[0].message").value("Invalid currency code : AAA"))
                .andExpect(jsonPath("errors[1].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[1].message").value("Invalid currency code : CCC"))
                .andExpect(jsonPath("errors[2].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[2].message").value("Invalid currency code : EEE"))
                .andExpect(jsonPath("errors[3].code").value(locale_invalid.toString()))
                .andExpect(jsonPath("errors[3].message").value("Invalid locale : UU_UU"))
                .andExpect(jsonPath("errors[4].code").value(locale_invalid.toString()))
                .andExpect(jsonPath("errors[4].message").value("Invalid locale : TOTO"))
                .andExpect(jsonPath("errors[5].code").value(locale_invalid.toString()))
                .andExpect(jsonPath("errors[5].message").value("Invalid locale : TATA"));
    }

}

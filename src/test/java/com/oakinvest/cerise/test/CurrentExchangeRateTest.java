package com.oakinvest.cerise.test;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.Mode;
import com.oakinvest.cerise.service.MockedCurrentExchangeRateService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.oakinvest.cerise.util.generic.CeriseErrorCode.currency_code_invalid;
import static com.oakinvest.cerise.util.generic.CeriseErrorCode.currency_pair_too_large;
import static com.oakinvest.cerise.util.generic.CeriseErrorType.invalid_request_error;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Current exchange rate test.
 *
 * @author straumat
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CurrentExchangeRateTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private MockedCurrentExchangeRateService service;

    /**
     * Test for Current exchange rate results.
     */
    @Test
    public void getCurrentExchangeRateResults() throws Exception {
        // Testing all the data.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", "XBTUSD-ver4,2")
                .param("type", "typical,high")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(not(containsString("\\n\\r"))))
                .andExpect(jsonPath("$", hasSize(2)))
                // First result.
                .andExpect(jsonPath("$[0].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[0].time").value(1488767410.5463133))
                .andExpect(jsonPath("$[0].rates.typical").value(1349.332215))
                .andExpect(jsonPath("$[0].rates.high").value(1351.2))
                .andExpect(jsonPath("$[1].nonce").doesNotExist())
                .andExpect(jsonPath("$[0].signature").doesNotExist())
                // Second result.
                .andExpect(jsonPath("$[1].cp").value("2"))
                .andExpect(jsonPath("$[1].time").value(1488767410D))
                .andExpect(jsonPath("$[1].rates.typical").value(1350.111332))
                .andExpect(jsonPath("$[1].nonce").doesNotExist())
                .andExpect(jsonPath("$[1].signature").doesNotExist());

        // Testing the generated parameters for the service.
        CurrentExchangeRateParameters p = service.getLastReceivedParameter();
        assertEquals("Mode parameter value is wrong", Mode.rate, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", "XBTUSD-ver4", p.getCp().get(0));
        assertEquals("CP parameter set", "2", p.getCp().get(1));
        assertNotEquals("Type is set", p.getTypes().size(), 0);
        assertNull("Minrate is set", p.getMinrate());
        assertNull("Maxrate is set", p.getMaxrate());
        assertNull("Nonce is set", p.getNonce());
    }

    /**
     * Test for current exchange rate parameters.
     */
    @Test
    public void getCurrentExchangeRateParameters() throws Exception {
        // Testing with type parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        CurrentExchangeRateParameters p = service.getLastReceivedParameter();
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", p.getCp().get(0), "XBTUSD-ver4");
        assertEquals("CP parameter set", p.getCp().get(1), "2");
        assertNull("Minrate", p.getMinrate());
        assertNull("Maxrate", p.getMaxrate());
        assertNull("Nonce", p.getNonce());

        // Testing with type & minrate parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .param("minrate", "1350.111332")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        p = service.getLastReceivedParameter();
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", p.getCp().get(0), "XBTUSD-ver4");
        assertEquals("CP parameter set", p.getCp().get(1), "2");
        assertEquals("Type", p.getTypes().size(), 2);
        assertEquals("Type 1 ", p.getTypes().get(0), "typical");
        assertEquals("Type 2 ", p.getTypes().get(1), "high");
        assertEquals("Minrate", p.getMinrate(), 1350.111332);
        assertNull("Maxrate", p.getMaxrate());
        assertNull("Nonce", p.getNonce());

        // Testing with type, minrate & maxrate parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .param("minrate", "1350.111332")
                .param("maxrate", "1351.111332")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        p = service.getLastReceivedParameter();
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", p.getCp().get(0), "XBTUSD-ver4");
        assertEquals("CP parameter set", p.getCp().get(1), "2");
        assertEquals("Type", p.getTypes().size(), 2);
        assertEquals("Type 1 ", p.getTypes().get(0), "typical");
        assertEquals("Type 2 ", p.getTypes().get(1), "high");
        assertEquals("Minrate", p.getMinrate(), 1350.111332);
        assertEquals("Maxrate", p.getMaxrate(), 1351.111332);
        assertNull("Nonce", p.getNonce());

        // Testing with type, minrate, maxrate & nonce parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .param("minrate", "1350.111332")
                .param("maxrate", "1351.111332")
                .param("nonce", "JGT")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        p = service.getLastReceivedParameter();
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", p.getCp().get(0), "XBTUSD-ver4");
        assertEquals("CP parameter set", p.getCp().get(1), "2");
        assertEquals("Type", p.getTypes().size(), 2);
        assertEquals("Type 1 ", p.getTypes().get(0), "typical");
        assertEquals("Type 2 ", p.getTypes().get(1), "high");
        assertEquals("Minrate", p.getMinrate(), 1350.111332);
        assertEquals("Maxrate", p.getMaxrate(), 1351.111332);
        assertEquals("Nonce", p.getNonce(), "JGT");
    }

    /**
     * Test parameters validation.
     */
    @Test
    public void testParametersValidation() throws Exception {
        // Long cp as parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", "TEST, " + StringUtils.repeat("A", 256))
                .param("type", " typical , high ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Invalid request to current exchange rate controller"))
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0].code").value(currency_pair_too_large.toString()))
                .andExpect(jsonPath("errors[0].message").value("Currency-pair parameter is too long : " + StringUtils.repeat("A", 256)));

        // Wrong currency code.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", "AAAAAAA, USD, EUR, CCC, DDD")
                .param("type", " typical , high ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Invalid request to current exchange rate controller"))
                .andExpect(jsonPath("errors", hasSize(2)))
                .andExpect(jsonPath("errors[0].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[0].message").value("Invalid currency code : CCC"))
                .andExpect(jsonPath("errors[1].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[1].message").value("Invalid currency code : DDD"));

        // Several errors.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", "TEST, " + StringUtils.repeat("A", 256) + ", AAAAAAA, USD, EUR, CCC, EEE, DDD")
                .param("type", " typical , high ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Invalid request to current exchange rate controller"))
                .andExpect(jsonPath("errors", hasSize(4)))
                .andExpect(jsonPath("errors[0].code").value(currency_pair_too_large.toString()))
                .andExpect(jsonPath("errors[0].message").value("Currency-pair parameter is too long : " + StringUtils.repeat("A", 256)))
                .andExpect(jsonPath("errors[1].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[1].message").value("Invalid currency code : CCC"))
                .andExpect(jsonPath("errors[2].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[2].message").value("Invalid currency code : EEE"))
                .andExpect(jsonPath("errors[3].code").value(currency_code_invalid.toString()))
                .andExpect(jsonPath("errors[3].message").value("Invalid currency code : DDD"));
    }

}

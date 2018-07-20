package com.oakinvest.cerise.test;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.Mode;
import com.oakinvest.cerise.service.MockedCurrentExchangeRateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
     * Test for Current exchange rate.
     */
    @Test
    public void getCurrentExchangeRate() throws Exception {
        // Testing all the data.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", "XBTUSD-ver4,2")
                .param("type", "typical,high")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                // First result.
                .andExpect(jsonPath("$[0].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[0].time").value(1488767410))
                .andExpect(jsonPath("$[0].rates[0].type").value("typical"))
                .andExpect(jsonPath("$[0].rates[0].value").value(1349.332215))
                .andExpect(jsonPath("$[0].rates[1].type").value("high"))
                .andExpect(jsonPath("$[0].rates[1].value").value(1351.2))
                .andExpect(jsonPath("$[0].signature").isEmpty())
                // Second result.
                .andExpect(jsonPath("$[1].cp").value("2"))
                .andExpect(jsonPath("$[1].time").value(1488767410))
                .andExpect(jsonPath("$[1].rates[0].type").value("typical"))
                .andExpect(jsonPath("$[1].rates[0].value").value(1350.111332))
                .andExpect(jsonPath("$[1].signature").isEmpty());

        // Testing the generated parameters for the service.
        CurrentExchangeRateParameters p = service.getLastUsedParameter();
        assertNotNull("Last parameter exists", p);
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertNotNull("CP parameter not set", p.getCp());
        assertNotEquals("Type not set", p.getTypes().size(), 0);
        assertNull("Minrate", p.getMinrate());
        assertNull("Maxrate", p.getMaxrate());
        assertNull("Nonce", p.getNonce());

        // Testing with type parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high "))
                .andExpect(status().isOk());
        p = service.getLastUsedParameter();
        assertNotNull("Last parameter exists", p);
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertNotNull("CP parameter not set", p.getCp());
        assertEquals("CP parameter set", p.getCp(), "XBTUSD-ver4,2");
        assertEquals("Type", p.getTypes().size(), 2);
        assertEquals("Type 1 ", p.getTypes().get(0), "typical");
        assertEquals("Type 2 ", p.getTypes().get(1), "high");
        assertNull("Minrate", p.getMinrate());
        assertNull("Maxrate", p.getMaxrate());
        assertNull("Nonce", p.getNonce());

        // Testing with type & minrate parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .param("minrate", "3"))
                .andExpect(status().isOk());
        p = service.getLastUsedParameter();
        assertNotNull("Last parameter exists", p);
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertNotNull("CP parameter not set", p.getCp());
        assertEquals("CP parameter set", p.getCp(), "XBTUSD-ver4,2");
        assertEquals("Type", p.getTypes().size(), 2);
        assertEquals("Type 1 ", p.getTypes().get(0), "typical");
        assertEquals("Type 2 ", p.getTypes().get(1), "high");
        assertEquals("Minrate", p.getMinrate(), "3");
        assertNull("Maxrate", p.getMaxrate());
        assertNull("Nonce", p.getNonce());

        // Testing with type, minrate & maxrate parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .param("minrate", "3")
                .param("maxrate", "4"))
                .andExpect(status().isOk());
        p = service.getLastUsedParameter();
        assertNotNull("Last parameter exists", p);
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertNotNull("CP parameter not set", p.getCp());
        assertEquals("CP parameter set", p.getCp(), "XBTUSD-ver4,2");
        assertEquals("Type", p.getTypes().size(), 2);
        assertEquals("Type 1 ", p.getTypes().get(0), "typical");
        assertEquals("Type 2 ", p.getTypes().get(1), "high");
        assertEquals("Minrate", p.getMinrate(), "3");
        assertEquals("Maxrate", p.getMaxrate(), "4");
        assertNull("Nonce", p.getNonce());

        // Testing with type, minrate, maxrate & nonce parameter.
        mvc.perform(get("/")
                .param("mode", "rate")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .param("minrate", "3")
                .param("maxrate", "4")
                .param("nonce", "JGT"))
                .andExpect(status().isOk());
        p = service.getLastUsedParameter();
        assertNotNull("Last parameter exists", p);
        assertEquals("Mode parameter set", Mode.rate, p.getMode());
        assertNotNull("CP parameter not set", p.getCp());
        assertEquals("CP parameter set", p.getCp(), "XBTUSD-ver4,2");
        assertEquals("Type", p.getTypes().size(), 2);
        assertEquals("Type 1 ", p.getTypes().get(0), "typical");
        assertEquals("Type 2 ", p.getTypes().get(1), "high");
        assertEquals("Minrate", p.getMinrate(), "3");
        assertEquals("Maxrate", p.getMaxrate(), "4");
        assertEquals("Nonce", p.getNonce(), "JGT");
    }

}

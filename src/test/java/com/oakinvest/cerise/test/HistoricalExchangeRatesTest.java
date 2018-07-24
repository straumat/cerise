package com.oakinvest.cerise.test;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.Mode;
import com.oakinvest.cerise.service.MockedHistoricalExchangeRatesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Historical exchange rates test.
 *
 * @author straumat
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HistoricalExchangeRatesTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MockedHistoricalExchangeRatesService service;

    /**
     * Historical exchange rates test results.
     */
    @Test
    public void getHistoricalExchangeRatesResults() throws Exception {

        // Testing all the data.
        mvc.perform(get("/")
                .param("mode", "history")
                .param("cp", "XBTUSD-ver4,2")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(not(containsString("\\n\\r"))))
                .andExpect(jsonPath("$", hasSize(5)))
                // First result.
                .andExpect(jsonPath("$[0].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[0].time").value(1488760000))
                .andExpect(jsonPath("$[0].rates[0].type").value("typical"))
                .andExpect(jsonPath("$[0].rates[0].value").value(1300))
                // Second result.
                .andExpect(jsonPath("$[1].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[1].time").value(1488760010))
                .andExpect(jsonPath("$[1].rates[0].type").value("typical"))
                .andExpect(jsonPath("$[1].rates[0].value").value(1301.1))
                // Third result.
                .andExpect(jsonPath("$[2].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[2].time").value(1488760020))
                .andExpect(jsonPath("$[2].rates[0].type").value("typical"))
                .andExpect(jsonPath("$[2].rates[0].value").value(1320))
                // Fourth result.
                .andExpect(jsonPath("$[3].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[3].time").value(1488760030))
                .andExpect(jsonPath("$[3].rates[0].type").value("typical"))
                .andExpect(jsonPath("$[3].rates[0].value").value(1305))
                // Fifth result.
                .andExpect(jsonPath("$[4].cp").value("2"))
                .andExpect(jsonPath("$[4].time").value(1488760000))
                .andExpect(jsonPath("$[4].rates[0].type").value("typical"))
                .andExpect(jsonPath("$[4].rates[0].value").value(1300));

        // Testing the generated parameters for the service.
        HistoricalExchangeRatesParameters p = service.getLastUsedParameter();
        assertEquals("Mode parameter set", Mode.history, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", p.getCp().get(0), "XBTUSD-ver4");
        assertEquals("CP parameter set", p.getCp().get(1), "2");
        assertEquals("Type empty", p.getTypes().size(), 0);
        assertNull("from", p.getFrom());
        assertNull("to", p.getTo());
        assertNull("nearest", p.isNearest());
        assertNull("to", p.getTo());
        assertNull("to", p.getTo());
    }

    /**
     * Historical exchange rates test parameters.
     */
    @Test
    public void getHistoricalExchangeRatesParameters() throws Exception {

        // Testing with cp and types parameter.
        mvc.perform(get("/")
                .param("mode", "history")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        HistoricalExchangeRatesParameters p = service.getLastUsedParameter();
        assertEquals("Mode parameter set", Mode.history, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", p.getCp().get(0), "XBTUSD-ver4");
        assertEquals("CP parameter set", p.getCp().get(1), "2");
        assertTrue("Type empty", p.getTypes().size() > 0);
        assertEquals("Type content", p.getTypes().get(0), "typical");
        assertEquals("Type content", p.getTypes().get(1), "high");
        assertNull("from", p.getFrom());
        assertNull("to", p.getTo());
        assertNull("nearest", p.isNearest());
        assertNull("ratedelta", p.getRateDelta());
        assertNull("timedelta", p.getTimeDelta());

        // Testing with all parameters.
        mvc.perform(get("/")
                .param("mode", "history")
                .param("cp", " XBTUSD-ver4,2 ")
                .param("type", " typical , high ")
                .param("from", "2")
                .param("to", "3")
                .param("nearest", "true")
                .param("ratedelta", "4")
                .param("timedelta", "5")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        p = service.getLastUsedParameter();
        assertEquals("Mode parameter set", Mode.history, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", p.getCp().get(0), "XBTUSD-ver4");
        assertEquals("CP parameter set", p.getCp().get(1), "2");
        assertTrue("Type empty", p.getTypes().size() > 0);
        assertEquals("Type content", p.getTypes().get(0), "typical");
        assertEquals("Type content", p.getTypes().get(1), "high");
        assertEquals("from", p.getFrom(), 2L);
        assertEquals("to", p.getTo(), 3L);
        assertEquals("nearest", p.isNearest(), true);
        assertEquals("ratedelta", p.getRateDelta(), 4f);
        assertEquals("timedelta", p.getTimeDelta(), 5f);
    }
}

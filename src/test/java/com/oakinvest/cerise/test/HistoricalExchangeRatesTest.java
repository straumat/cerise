package com.oakinvest.cerise.test;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.Mode;
import com.oakinvest.cerise.service.MockedHistoricalExchangeRatesService;
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
                .andExpect(jsonPath("$", hasSize(18)))
                // First result.
                .andExpect(jsonPath("$[0].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[0].time").value(1488760000))
                .andExpect(jsonPath("$[0].rates.typical").value(1300))
                // Second result.
                .andExpect(jsonPath("$[1].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[1].time").value(1488760010))
                .andExpect(jsonPath("$[1].rates.typical").value(1301.1))
                // Third result.
                .andExpect(jsonPath("$[2].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[2].time").value(1488760020))
                .andExpect(jsonPath("$[2].rates.typical").value(1320))
                // Fourth result.
                .andExpect(jsonPath("$[3].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[3].time").value(1488760030))
                .andExpect(jsonPath("$[3].rates.typical").value(1305))
                // Fifth result.
                .andExpect(jsonPath("$[4].cp").value("2"))
                .andExpect(jsonPath("$[4].time").value(1488760000.1))
                .andExpect(jsonPath("$[4].rates.typical").value(1300))
                // 6th result.
                .andExpect(jsonPath("$[5].cp").value("2"))
                .andExpect(jsonPath("$[5].time").value(1488760010.2))
                .andExpect(jsonPath("$[5].rates.typical").value(1301.1))
                // 7th result.
                .andExpect(jsonPath("$[6].cp").value("2"))
                .andExpect(jsonPath("$[6].time").value(1488760020.2))
                .andExpect(jsonPath("$[6].rates.typical").value(1320.111332))
                // 8th result.
                .andExpect(jsonPath("$[7].cp").value("2"))
                .andExpect(jsonPath("$[7].time").value(1488760031))
                .andExpect(jsonPath("$[7].rates.typical").value(1305.222311))
                // 9th result.
                .andExpect(jsonPath("$[8].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[8].time").value(1488760040))
                .andExpect(jsonPath("$[8].rates.typical").value(1303.33))
                // 10th result.
                .andExpect(jsonPath("$[9].cp").value("2"))
                .andExpect(jsonPath("$[9].time").value(1488760042))
                .andExpect(jsonPath("$[9].rates.typical").value(1303.33))
                // 11th result.
                .andExpect(jsonPath("$[10].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[10].time").value(1488760050))
                .andExpect(jsonPath("$[10].rates.typical").value(1305))
                // 12th result.
                .andExpect(jsonPath("$[11].cp").value("2"))
                .andExpect(jsonPath("$[11].time").value(1488760052))
                .andExpect(jsonPath("$[11].rates.typical").value(1307))
                // 13th result.
                .andExpect(jsonPath("$[12].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[12].time").value(1488760060))
                .andExpect(jsonPath("$[12].rates.typical").value(1309))
                // 14th result.
                .andExpect(jsonPath("$[13].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[13].time").value(1488760072))
                .andExpect(jsonPath("$[13].rates.typical").value(1308))
                // 15th result.
                .andExpect(jsonPath("$[14].cp").value("2"))
                .andExpect(jsonPath("$[14].time").value(1488760062))
                .andExpect(jsonPath("$[14].rates.typical").value(1309.55555555))
                // 16th result.
                .andExpect(jsonPath("$[15].cp").value("2"))
                .andExpect(jsonPath("$[15].time").value(1488760072))
                .andExpect(jsonPath("$[15].rates.typical").value(1308))
                // 17th result.
                .andExpect(jsonPath("$[16].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[16].time").value(1488760082))
                .andExpect(jsonPath("$[16].rates.typical").value(1309))
                // 18th result.
                .andExpect(jsonPath("$[17].cp").value("2"))
                .andExpect(jsonPath("$[17].time").value(1488760082))
                .andExpect(jsonPath("$[17].rates.typical").value(1309.1));

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
        assertEquals("from", p.getFrom(), 2D);
        assertEquals("to", p.getTo(), 3D);
        assertEquals("nearest", p.isNearest(), true);
        assertEquals("ratedelta", p.getRateDelta(), 4f);
        assertEquals("timedelta", p.getTimeDelta(), 5f);
    }

    /**
     * Historical exchange rates test with wrong parameters.
     */
    @Test
    public void getHistoricalExchangeRatesWithWrongParameters() throws Exception {

        // Test with long cp as parameter.
        mvc.perform(get("/")
                .param("mode", "history")
                .param("cp", StringUtils.repeat("*", 256) + ",TOTO," + StringUtils.repeat("C", 256))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("Currency-pair should be no longer than 255 characters"))
                .andExpect(jsonPath("errors", hasSize(2)))
                .andExpect(jsonPath("errors[0]").value("Currency-pair too long : " + StringUtils.repeat("*", 256)))
                .andExpect(jsonPath("errors[1]").value("Currency-pair too long : " + StringUtils.repeat("C", 256)));

        // Test with long CP as return.
        mvc.perform(get("/")
                .param("mode", "history")
                .param("cp", "TEST_LONG_CP")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("Currency-pair should be no longer than 255 characters"))
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Currency-pair too long : " + StringUtils.repeat("*", 256)));

        // Wrong values of cp.
        mvc.perform(get("/")
                .param("mode", "history")
                .param("cp", "USD, TOTO, AED, A, AAA, CCC")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("Invalid currency codes"))
                .andExpect(jsonPath("errors", hasSize(2)))
                .andExpect(jsonPath("errors[0]").value("Invalid currency code : AAA"))
                .andExpect(jsonPath("errors[1]").value("Invalid currency code : CCC"));
    }

}

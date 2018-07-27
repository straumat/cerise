package com.oakinvest.cerise.test;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.Mode;
import com.oakinvest.cerise.service.MockedCurrencyPairInformationService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Currency-pair information.
 *
 * @author straumat
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyPairInformationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private MockedCurrencyPairInformationService service;

    /**
     * Test for Currency-pair information results.
     */
    @Test
    public void getCurrencyPairInformationResults() throws Exception {
        // Testing all the data.
        mvc.perform(get("/")
                .param("mode", "info")
                .param("cp", "XBTUSD-ver4,2")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(not(containsString("\\n\\r"))))
                .andExpect(jsonPath("$", hasSize(2)))
                // First result.
                .andExpect(jsonPath("$[0].cp").value("XBTUSD-ver4"))
                .andExpect(jsonPath("$[0].quote").value("USD"))
                .andExpect(jsonPath("$[0].base").value("XBT"))
                .andExpect(jsonPath("$[0].locale").value("en_US"))
                .andExpect(jsonPath("$[0].desc").value("Smoothed averages"))
                .andExpect(jsonPath("$[0].longdesc").value("USD price quotes as compared to Bitcoin value\\n\\nRecommended for casual usage"))
                .andExpect(jsonPath("$[0].symbol[0][0]").value("-$"))
                .andExpect(jsonPath("$[0].symbol[0][1]").value("$"))
                .andExpect(jsonPath("$[0].symbol[1]").isEmpty())
                .andExpect(jsonPath("$[0].digits").value("Arabic"))
                // TODO Review grouping.
                .andExpect(jsonPath("$[0].grouping[0]").value("3"))
                .andExpect(jsonPath("$[0].grouping[1]").value(","))
                .andExpect(jsonPath("$[0].grouping[2]").value("0"))
                .andExpect(jsonPath("$[0].fraction_sep").value("."))
                .andExpect(jsonPath("$[0].fraction_digits[0]").value(0))
                .andExpect(jsonPath("$[0].fraction_digits[1]").value(2))
                .andExpect(jsonPath("$[0].fraction_digits[2]").value(2))
                .andExpect(jsonPath("$[0].minpoll").value(300))
                .andExpect(jsonPath("$[0].longpoll").value(true))
                .andExpect(jsonPath("$[0].history").value(1457231416L))
                .andExpect(jsonPath("$[0].archive").value(14572314161L))
                .andExpect(jsonPath("$[0].signature").doesNotExist())
                // Second result.
                .andExpect(jsonPath("$[1].cp").value("2"))
                .andExpect(jsonPath("$[1].quote").value("USD"))
                .andExpect(jsonPath("$[1].base").value("XBT"))
                .andExpect(jsonPath("$[1].locale").value("en_US"))
                .andExpect(jsonPath("$[1].desc").value("Updated per-trade"))
                .andExpect(jsonPath("$[1].longdesc").value("Maximum precision USD price quotes as compared to Bitcoin value"))
                .andExpect(jsonPath("$[1].symbol[0][0]").value("-$"))
                .andExpect(jsonPath("$[1].symbol[0][1]").value("$"))
                .andExpect(jsonPath("$[1].symbol[1]").isEmpty())
                .andExpect(jsonPath("$[1].digits").value("Arabic"))
                // TODO Review grouping.
                .andExpect(jsonPath("$[1].grouping[0]").value("3"))
                .andExpect(jsonPath("$[1].grouping[1]").value(","))
                .andExpect(jsonPath("$[1].grouping[2]").value("0"))
                .andExpect(jsonPath("$[1].fraction_sep").value("."))
                .andExpect(jsonPath("$[1].fraction_digits[0]").value(0))
                .andExpect(jsonPath("$[1].fraction_digits[1]").value(2))
                .andExpect(jsonPath("$[1].fraction_digits[2]").value(2))
                .andExpect(jsonPath("$[1].minpoll").value(3600))
                .andExpect(jsonPath("$[1].longpoll").value(false))
                .andExpect(jsonPath("$[1].history").value(1467458333L))
                .andExpect(jsonPath("$[1].archive").value(14674583332L))
                .andExpect(jsonPath("$[1].signature").doesNotExist());

        // Testing the generated parameters for this call.
        CurrencyPairInformationParameters p = service.getLastUsedParameter();
        assertEquals("Mode parameter value is wrong", Mode.info, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", "XBTUSD-ver4", p.getCp().get(0));
        assertEquals("CP parameter set", "2", p.getCp().get(1));
    }

    /**
     * Test for Currency-pair information parameters.
     */
    @Test
    public void getCurrencyPairInformationParameters() throws Exception {
        // Testing with all parameters.
        mvc.perform(get("/")
                .param("mode", "info")
                .param("cp", " XBTUSD-ver4,2 ")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk());
        final CurrencyPairInformationParameters p = service.getLastUsedParameter();
        assertEquals("Mode parameter value is wrong", Mode.info, p.getMode());
        assertEquals("Wrong CP parameters count", 2, p.getCp().size());
        assertEquals("CP parameter set", "XBTUSD-ver4", p.getCp().get(0));
        assertEquals("CP parameter set", "2", p.getCp().get(1));
    }

    /**
     * Test for Currency-pair information CP parameters max size.
     */
    @Test
    public void getCurrencyPairInformationWithLongCP() throws Exception {
        // long cp as parameter.
        mvc.perform(get("/")
                .param("mode", "info")
                .param("cp", StringUtils.repeat("!", 256))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("Currency-pair should be no longer than 255 characters"))
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0]").value("Currency-pair too long : " + StringUtils.repeat("!", 256)));

        // long cp as return.
        mvc.perform(get("/")
                .param("mode", "info")
                .param("cp", "TEST_LONG_CP")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("message").value("Currency-pair should be no longer than 255 characters"))
                .andExpect(jsonPath("errors", hasSize(2)))
                .andExpect(jsonPath("errors[0]").value("Currency-pair too long : " + StringUtils.repeat("*", 256)))
                .andExpect(jsonPath("errors[1]").value("Currency-pair too long : " + StringUtils.repeat("*", 256)));
    }

}

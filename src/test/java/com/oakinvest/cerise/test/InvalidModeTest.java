package com.oakinvest.cerise.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.oakinvest.cerise.util.generic.CeriseErrorCode.mode_invalid;
import static com.oakinvest.cerise.util.generic.CeriseErrorCode.mode_required;
import static com.oakinvest.cerise.util.generic.CeriseErrorType.invalid_request_error;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Invalid mode test.
 *
 * @author straumat
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InvalidModeTest {

    @Autowired
    private MockMvc mvc;

    /**
     * Invalid mode test.
     */
    @Test
    public void invalidModeTest() throws Exception {
        // No mode set.
        mvc.perform(get("/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Mode not set (list, info, rate & history)"))
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0].code").value(mode_required.toString()))
                .andExpect(jsonPath("errors[0].message").value("Mode not set (list, info, rate & history)"));

        // Wrong mode value.
        mvc.perform(get("/")
                .param("mode", "toto")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("type").value(invalid_request_error.toString()))
                .andExpect(jsonPath("message").value("Incorrect mode value : 'toto'"))
                .andExpect(jsonPath("errors", hasSize(1)))
                .andExpect(jsonPath("errors[0].code").value(mode_invalid.toString()))
                .andExpect(jsonPath("errors[0].message").value("Incorrect mode value : 'toto'"));
    }

}

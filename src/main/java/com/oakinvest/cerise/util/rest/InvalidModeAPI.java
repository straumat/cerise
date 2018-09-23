package com.oakinvest.cerise.util.rest;

import com.oakinvest.cerise.util.generic.CeriseError;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.oakinvest.cerise.web.rest.CeriseHttpStatus.STATUS_BAD_REQUEST;

/**
 * Invalid mode.
 *
 * @author straumat
 */
@RequestMapping("/")
public interface InvalidModeAPI {

    /**
     * Invalid mode.
     *
     * @param mode mode
     */
    @RequestMapping(value = "/",
            params = {"mode!=list", "mode!=info", "mode!=rate", "mode!=history"},
            method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = STATUS_BAD_REQUEST, message = "The request was unacceptable, often due to missing a required parameter.", response = CeriseError.class),
    })
    void invalidMode(@ApiParam(value = "Mode required.")
                     @RequestParam String mode);

}

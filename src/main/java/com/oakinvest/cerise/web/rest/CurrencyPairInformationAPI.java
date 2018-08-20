package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrencyPairInformationResult;
import com.oakinvest.cerise.util.generic.CeriseError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.oakinvest.cerise.web.rest.CeriseHttpStatus.STATUS_BAD_REQUEST;
import static com.oakinvest.cerise.web.rest.CeriseHttpStatus.STATUS_INTERNAL_SERVER_ERROR;
import static com.oakinvest.cerise.web.rest.CeriseHttpStatus.STATUS_NOT_FOUND;
import static com.oakinvest.cerise.web.rest.CeriseHttpStatus.STATUS_OK;
import static com.oakinvest.cerise.web.rest.CeriseHttpStatus.STATUS_REQUEST_FAILED;
import static com.oakinvest.cerise.web.rest.CeriseHttpStatus.STATUS_UNAUTHORIZED;

/**
 * Currency-pair information API.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(tags = "Currency-pair information", description = " ")
public interface CurrencyPairInformationAPI {

    /**
     * Currency-pair information API.
     *
     * @param mode Always "info" for this request
     * @param cp   Currency pair(s) for which information is requested
     * @return results
     */
    @RequestMapping(value = "/",
            params = "mode=info",
            method = RequestMethod.GET)
    @ApiOperation(value = "Currency-pair information",
            response = CurrencyPairInformationResult.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mode",
                    dataType = "string",
                    required = true,
                    value = "Always \"info\" for this request."),
            @ApiImplicitParam(name = "cp",
                    dataType = "string",
                    required = true,
                    example = "XBTUSD-ver4,2",
                    value = "Currency pair(s) for which information is requested.")
    })
    @ApiResponses(value = {
            @ApiResponse(code = STATUS_OK, message = "Everything worked as expected."),
            @ApiResponse(code = STATUS_BAD_REQUEST, message = "The request was unacceptable, often due to missing a required parameter.", response = CeriseError.class),
            @ApiResponse(code = STATUS_UNAUTHORIZED, message = "No valid authorization was provided.", response = CeriseError.class),
            @ApiResponse(code = STATUS_REQUEST_FAILED, message = "The parameters were valid but the request failed.", response = CeriseError.class),
            @ApiResponse(code = STATUS_NOT_FOUND, message = "The requested resource doesn't exist.", response = CeriseError.class),
            @ApiResponse(code = STATUS_INTERNAL_SERVER_ERROR, message = "Something went wrong on the server.", response = CeriseError.class)
    })
    List<CurrencyPairInformationResult> getCurrencyPairInformation(@ApiParam(value = "Always \"info\" for this request!")
                                                                   @RequestParam String mode,
                                                                   @ApiParam(value = "Currency pair(s) for which information is requested.")
                                                                   @RequestParam String[] cp);

}

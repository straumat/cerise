package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensResult;
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
 * Enumerating supported currency-pair tokens API.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(tags = "Enumerating supported currency-pair tokens", description = " ")
@SuppressWarnings("magicnumber")
public interface SupportedCurrencyPairTokensAPI {

    /**
     * Enumerating supported currency-pair tokens API.
     *
     * @param mode   Always "list" for this request
     * @param quote  If provided, the server MAY limit the results to only currency-pairs describing a currency with the given currency code(s)
     * @param base   If provided, the server MAY limit the results to only currency-pairs describing currency rates compared to the given currency code(s)
     * @param locale If provided, the server MAY limit the results to only currency-pairs supporting the given Unicode CLDR locale(s)
     * @return results
     */
    @RequestMapping(value = "/",
            params = "mode=list",
            method = RequestMethod.GET)
    @ApiOperation(value = "Enumerating supported currency-pair tokens",
            response = SupportedCurrencyPairTokensResult.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mode",
                    dataType = "string",
                    required = true,
                    value = "Always \"list\" for this request."),
            @ApiImplicitParam(name = "quote",
                    dataType = "string",
                    example = "USD",
                    value = "If provided, the server MAY limit the results to only currency-pairs describing a currency with the given currency code(s)."),
            @ApiImplicitParam(name = "base",
                    dataType = "string",
                    example = "XBT",
                    value = "If provided, the server MAY limit the results to only currency-pairs describing currency rates compared to the given currency code(s)."),
            @ApiImplicitParam(name = "locale",
                    dataType = "string",
                    example = "en_US,en_GB",
                    value = "If provided, the server MAY limit the results to only currency-pairs supporting the given Unicode CLDR locale(s).")
    })
    @ApiResponses(value = {
            @ApiResponse(code = STATUS_OK, message = "Everything worked as expected."),
            @ApiResponse(code = STATUS_BAD_REQUEST, message = "The request was unacceptable, often due to missing a required parameter.", response = CeriseError.class),
            @ApiResponse(code = STATUS_UNAUTHORIZED, message = "No valid authorization was provided.", response = CeriseError.class),
            @ApiResponse(code = STATUS_REQUEST_FAILED, message = "The parameters were valid but the request failed.", response = CeriseError.class),
            @ApiResponse(code = STATUS_NOT_FOUND, message = "The requested resource doesn't exist.", response = CeriseError.class),
            @ApiResponse(code = STATUS_INTERNAL_SERVER_ERROR, message = "Something went wrong on the server.", response = CeriseError.class)
    })
    List<SupportedCurrencyPairTokensResult> getSupportedCurrencyPairTokens(@ApiParam(value = "Always \"list\" for this request.")
                                                                           @RequestParam String mode,
                                                                           @ApiParam(value = "If provided, the server MAY limit the results to only currency-pairs describing a currency with the given currency code(s).")
                                                                           @RequestParam(required = false) String[] quote,
                                                                           @ApiParam(value = "If provided, the server MAY limit the results to only currency-pairs describing currency rates compared to the given currency code(s).")
                                                                           @RequestParam(required = false) String[] base,
                                                                           @ApiParam(value = "If provided, the server MAY limit the results to only currency-pairs supporting the given Unicode CLDR locale(s).")
                                                                           @RequestParam(required = false) String[] locale);

}

package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
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
 * Current exchange rate API.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(tags = "Current exchange rate", description = " ")
public interface CurrentExchangeRateAPI {

    /**
     * Current exchange rate API.
     *
     * @param mode    Always "rate" for this request
     * @param cp      Currency pair(s) for which information is requested
     * @param type    Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate
     * @param minrate If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value
     * @param maxrate If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value
     * @param nonce   If specified, the server SHOULD return it in each result
     * @return results
     */
    @RequestMapping(value = "/",
            params = "mode=rate",
            method = RequestMethod.GET)
    @ApiOperation(value = "Currency-pair information",
            response = CurrentExchangeRateResult.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mode",
                    dataType = "string",
                    required = true,
                    value = "Always \"rate\" for this request."),
            @ApiImplicitParam(name = "cp",
                    dataType = "string",
                    required = true,
                    example = "XBTUSD-ver4,2",
                    value = "Currency pair(s) for which information is requested."),
            @ApiImplicitParam(name = "type",
                    dataType = "string",
                    example = "typical,high",
                    value = "Type of exchange rate data being requested. May be \"high\", \"low\", \"average\", \"typical\", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate."),
            @ApiImplicitParam(name = "minrate",
                    dataType = "double",
                    example = "11111111111",
                    value = "If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value."),
            @ApiImplicitParam(name = "maxrate",
                    dataType = "double",
                    example = "11111111111",
                    value = "If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value."),
            @ApiImplicitParam(name = "nonce",
                    dataType = "string",
                    example = "AAAAAAAAAAA",
                    value = "If specified, the server SHOULD return it in each result.")
    })
    @ApiResponses(value = {
            @ApiResponse(code = STATUS_OK, message = "Everything worked as expected."),
            @ApiResponse(code = STATUS_BAD_REQUEST, message = "The request was unacceptable, often due to missing a required parameter.", response = CeriseError.class),
            @ApiResponse(code = STATUS_UNAUTHORIZED, message = "No valid authorization was provided.", response = CeriseError.class),
            @ApiResponse(code = STATUS_REQUEST_FAILED, message = "The parameters were valid but the request failed.", response = CeriseError.class),
            @ApiResponse(code = STATUS_NOT_FOUND, message = "The requested resource doesn't exist.", response = CeriseError.class),
            @ApiResponse(code = STATUS_INTERNAL_SERVER_ERROR, message = "Something went wrong on the server.", response = CeriseError.class)
    })
    List<CurrentExchangeRateResult> getCurrencyPairInformation(@ApiParam(value = "Always \"rate\" for this request.")
                                                               @RequestParam String mode,
                                                               @ApiParam(value = "Currency pair(s) for which information is requested.")
                                                               @RequestParam String[] cp,
                                                               @ApiParam(value = "Type of exchange rate data being requested. May be \"high\", \"low\", \"average\", \"typical\", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.")
                                                               @RequestParam(required = false) String[] type,
                                                               @ApiParam(value = "If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.")
                                                               @RequestParam(required = false) Double minrate,
                                                               @ApiParam(value = "If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.")
                                                               @RequestParam(required = false) Double maxrate,
                                                               @ApiParam(value = "If specified, the server SHOULD return it in each result.")
                                                               @RequestParam(required = false) String nonce);

}

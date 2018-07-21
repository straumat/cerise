package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Current exchange rate API.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(tags = "Current exchange rate", description = " ")
public interface CurrentExchangeRateAPI {

    /**
     * Current exchange rate.
     *
     * @param mode    Always "rate" for this request.
     * @param cp      Currency pair(s) for which information is requested.
     * @param type    Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     * @param minrate If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     * @param maxrate If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     * @param nonce   If specified, the server SHOULD return it in each result.
     * @return results
     */
    @RequestMapping(value = "/", params = "mode=rate", method = RequestMethod.GET)
    @ApiOperation(value = "Currency-pair information",
            response = CurrentExchangeRateResult.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mode", required = true, value = "Always \"rate\" for this request."),
            @ApiImplicitParam(name = "cp", required = true, defaultValue = "XBTUSD-ver4,2", value = "Currency pair(s) for which information is requested."),
            @ApiImplicitParam(name = "type", required = true, defaultValue = "typical,high", value = "Type of exchange rate data being requested. May be \"high\", \"low\", \"average\", \"typical\", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate."),
            @ApiImplicitParam(name = "minrate", required = true, defaultValue = "typical,high", value = "If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value."),
            @ApiImplicitParam(name = "maxrate", required = true, defaultValue = "typical,high", value = "If specified, indicates this request is a long poll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value."),
            @ApiImplicitParam(name = "nonce", required = true, defaultValue = "typical,high", value = "Type of exchange rate data being requested. May be \"high\", \"low\", \"average\", \"typical\", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.")
    })
    // TODO Change maxrate to maxRate
    // TODO Change minrate to minRate
    List<CurrentExchangeRateResult> getCurrencyPairInformation(@RequestParam String mode,
                                                               @RequestParam String cp,
                                                               @RequestParam(required = false) String type,
                                                               @RequestParam(required = false) String minrate,
                                                               @RequestParam(required = false) String maxrate,
                                                               @RequestParam(required = false) String nonce);

}

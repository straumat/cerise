package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Historical exchange rates API.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(tags = "Historical exchange rates", description = " ")
@SuppressWarnings("ParameterNumber")
public interface HistoricalExchangeRatesAPI {

    /**
     * Historical exchange rates API.
     *
     * @param mode      Always "history" for this request.
     * @param cp        Currency pair(s) for which rate is requested.
     * @param type      Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     * @param from      POSIX timestamp the results should begin with.
     * @param to        POSIX timestamp the results should end with. If omitted, the present time shall be used.
     * @param nearest   If provided and true, indicates that only the nearest timestamp to "from" must be returned, and a range is not desired. ("to" should be omitted in this case.)
     * @param ratedelta If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.
     * @param timedelta If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.
     * @return results
     */
    @RequestMapping(value = "/", params = "mode=history", method = RequestMethod.GET)
    @ApiOperation(value = "Historical exchange rates API",
            response = HistoricalExchangeRatesResult.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mode", required = true, value = "Always \"rate\" for this request."),
            @ApiImplicitParam(name = "cp", required = true, defaultValue = "XBTUSD-ver4,2", value = "Currency pair(s) for which information is requested."),
            @ApiImplicitParam(name = "type", required = true, defaultValue = "typical,high", value = "Type of exchange rate data being requested. May be \"high\", \"low\", \"average\", \"typical\", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate."),
            @ApiImplicitParam(name = "to", defaultValue = "1488759998", value = "POSIX timestamp the results should end with. If omitted, the present time shall be used."),
            @ApiImplicitParam(name = "from", defaultValue = "1488760090", value = "POSIX timestamp the results should begin with."),
            @ApiImplicitParam(name = "ratedelta", defaultValue = "0.1", value = "If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results."),
            @ApiImplicitParam(name = "timedelta", defaultValue = "10", value = "If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.")
    })
    List<HistoricalExchangeRatesResult> getHistoricalExchangeRates(@RequestParam String mode,
                                                                   @RequestParam String cp,
                                                                   @RequestParam(required = false) String type,
                                                                   @RequestParam(required = false) Long from,
                                                                   @RequestParam(required = false) Long to,
                                                                   @RequestParam(required = false) Boolean nearest,
                                                                   @RequestParam(required = false) Float ratedelta,
                                                                   @RequestParam(required = false) Float timedelta);

}

package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;
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
     * @param mode      Always "history" for this request
     * @param cp        Currency pair(s) for which rate is requested
     * @param type      Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate
     * @param from      POSIX timestamp the results should begin with
     * @param to        POSIX timestamp the results should end with. If omitted, the present time shall be used
     * @param nearest   If provided and true, indicates that only the nearest timestamp to "from" must be returned, and a range is not desired. ("to" should be omitted in this case.)
     * @param ratedelta If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results
     * @param timedelta If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results
     * @return results
     */
    @RequestMapping(value = "/",
            params = "mode=history",
            method = RequestMethod.GET
    )
    @ApiOperation(value = "Historical exchange rates API",
            response = HistoricalExchangeRatesResult.class,
            responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mode",
                    dataType = "string",
                    required = true,
                    value = "Always \"history\" for this request."),
            @ApiImplicitParam(name = "cp",
                    dataType = "string",
                    required = true,
                    example = "XBTUSD-ver4,2",
                    value = "Currency pair(s) for which information is requested."),
            @ApiImplicitParam(name = "type",
                    dataType = "string",
                    required = true,
                    example = "typical,high",
                    value = "Type of exchange rate data being requested. May be \"high\", \"low\", \"average\", \"typical\", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate."),
            @ApiImplicitParam(name = "from",
                    dataType = "double",
                    example = "1488760090",
                    value = "POSIX timestamp the results should begin with."),
            @ApiImplicitParam(name = "to",
                    dataType = "double",
                    example = "1488759998",
                    value = "POSIX timestamp the results should end with. If omitted, the present time shall be used."),
            @ApiImplicitParam(name = "nearest",
                    dataType = "boolean",
                    example = "true",
                    value = "If provided and true, indicates that only the nearest timestamp to \"from\" must be returned, and a range is not desired. (\"to\" should be omitted in this case.)"),
            @ApiImplicitParam(name = "ratedelta",
                    dataType = "double",
                    example = "0.1",
                    value = "If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results."),
            @ApiImplicitParam(name = "timedelta",
                    dataType = "double",
                    example = "10",
                    value = "If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.")
    })
    @ApiResponses(value = {
            @ApiResponse(code = STATUS_OK, message = "Everything worked as expected."),
            @ApiResponse(code = STATUS_BAD_REQUEST, message = "The request was unacceptable, often due to missing a required parameter.", response = CeriseError.class),
            @ApiResponse(code = STATUS_UNAUTHORIZED, message = "No valid authorization was provided.", response = CeriseError.class),
            @ApiResponse(code = STATUS_REQUEST_FAILED, message = "The parameters were valid but the request failed.", response = CeriseError.class),
            @ApiResponse(code = STATUS_NOT_FOUND, message = "The requested resource doesn't exist.", response = CeriseError.class),
            @ApiResponse(code = STATUS_INTERNAL_SERVER_ERROR, message = "Something went wrong on the server.", response = CeriseError.class)
    })
    List<HistoricalExchangeRatesResult> getHistoricalExchangeRates(@ApiParam(value = "Always \"history\" for this request.")
                                                                   @RequestParam String mode,
                                                                   @ApiParam(value = "Currency pair(s) for which information is requested.")
                                                                   @RequestParam String[] cp,
                                                                   @ApiParam(value = "Type of exchange rate data being requested. May be \"high\", \"low\", \"average\", \"typical\", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.")
                                                                   @RequestParam(required = false) String[] type,
                                                                   @ApiParam(value = "POSIX timestamp the results should begin with.")
                                                                   @RequestParam(required = false) Double from,
                                                                   @ApiParam(value = "POSIX timestamp the results should end with. If omitted, the present time shall be used.")
                                                                   @RequestParam(required = false) Double to,
                                                                   @ApiParam(value = "If provided and true, indicates that only the nearest timestamp to \"from\" must be returned, and a range is not desired. (\"to\" should be omitted in this case.)")
                                                                   @RequestParam(required = false) Boolean nearest,
                                                                   @ApiParam(value = "If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.")
                                                                   @RequestParam(required = false) Float ratedelta,
                                                                   @ApiParam(value = "If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.")
                                                                   @RequestParam(required = false) Float timedelta);

}

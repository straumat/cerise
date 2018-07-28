package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrencyPairInformationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Currency-pair information.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(tags = "Currency-pair information", description = " ")
public interface CurrencyPairInformationAPI {

    /**
     * Currency-pair information.
     *
     * @param mode Always "info" for this request.
     * @param cp   Currency pair(s) for which information is requested.
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
    List<CurrencyPairInformationResult> getCurrencyPairInformation(@ApiParam(value = "Always \"info\" for this request!")
                                                                   @RequestParam String mode,
                                                                   @ApiParam(value = "Currency pair(s) for which information is requested.")
                                                                   @RequestParam String[] cp);

}

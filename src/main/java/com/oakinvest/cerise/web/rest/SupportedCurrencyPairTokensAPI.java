package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Enumerating supported currency-pair tokens.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(tags = "Enumerating supported currency-pair tokens", description = " ")
@SuppressWarnings("magicnumber")
public interface SupportedCurrencyPairTokensAPI {

    /**
     * Enumerating supported currency-pair tokens.
     *
     * @param mode   Always "list" for this request.
     * @param quote  If provided, the server MAY limit the results to only currency-pairs describing a currency with the given currency code(s).
     * @param base   If provided, the server MAY limit the results to only currency-pairs describing currency rates compared to the given currency code(s).
     * @param locale If provided, the server MAY limit the results to only currency-pairs supporting the given Unicode CLDR locale(s).
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
                    required = true,
                    value = "Always \"list\" for this request."),
            @ApiImplicitParam(name = "quote",
                    example = "USD",
                    value = "If provided, the server MAY limit the results to only currency-pairs describing a currency with the given currency code(s)"),
            @ApiImplicitParam(name = "base",
                    example = "XBT",
                    value = "If provided, the server MAY limit the results to only currency-pairs describing currency rates compared to the given currency code(s)"),
            @ApiImplicitParam(name = "locale",
                    example = "en_US,en_GB",
                    value = "If provided, the server MAY limit the results to only currency-pairs supporting the given Unicode CLDR locale(s)")
    })
    List<SupportedCurrencyPairTokensResult> getSupportedCurrencyPairTokens(@RequestParam String mode,
                                                                           @RequestParam(required = false) String[] quote,
                                                                           @RequestParam(required = false) String[] base,
                                                                           @RequestParam(required = false) String[] locale);

}

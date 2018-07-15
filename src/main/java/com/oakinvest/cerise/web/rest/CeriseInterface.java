package com.oakinvest.cerise.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Interface for requesting currency exchange rate information from a server.
 *
 * @author straumat
 */
@RequestMapping("/")
@Api(description = "Currency/exchange rate information API")
public interface CeriseInterface {

    /**
     * Enumerating supported currency-pair tokens.
     *
     * @return results
     */
    @RequestMapping(value = "/", params = "mode=list", method = RequestMethod.GET)
    @ApiOperation(value = "Enumerating supported currency-pair tokens",
            response = String.class,
            responseContainer = "List")
    String getSupportedCurrencyPairTokens();

    /**
     * Currency-pair information.
     *
     * @return results
     */
    @RequestMapping(value = "/", params = "mode=info", method = RequestMethod.GET)
    @ApiOperation(value = "Currency-pair information",
            response = String.class,
            responseContainer = "List")
    String getCurrencyPairInformation();

    /**
     * Current exchange rate.
     *
     * @return results
     */
    @RequestMapping(value = "/", params = "mode=rate", method = RequestMethod.GET)
    @ApiOperation(value = "Current exchange rate",
            response = String.class,
            responseContainer = "List")
    String getCurrentExchangeRate();

    /**
     * Historical exchange rates.
     *
     * @return results
     */
    @RequestMapping(value = "/", params = "mode=history", method = RequestMethod.GET)
    @ApiOperation(value = "Historical exchange rates",
            response = String.class,
            responseContainer = "List")
    String getHistoricalExchangeRates();

}

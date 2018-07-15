package com.oakinvest.cerise.web.rest;

import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation for requesting currency exchange rate information from a server.
 *
 * @author straumat
 */
@RestController
public final class CeriseAPI implements CeriseInterface {


    /**
     * Enumerating supported currency-pair tokens.
     *
     * @return results
     */
    @Override
    public String getSupportedCurrencyPairTokens() {
        System.out.println("getSupportedCurrencyPairTokens");
        return "getSupportedCurrencyPairTokens";
    }

    /**
     * Currency-pair information.
     *
     * @return results
     */
    @Override
    public String getCurrencyPairInformation() {
        System.out.println("getCurrencyPairInformation");
        return "getCurrencyPairInformation";
    }

    /**
     * Current exchange rate.
     *
     * @return results
     */
    @Override
    public String getCurrentExchangeRate() {
        System.out.println("getCurrentExchangeRate");
        return "getCurrentExchangeRate";
    }

    /**
     * Historical exchange rates.
     *
     * @return results
     */
    @Override
    public String getHistoricalExchangeRates() {
        System.out.println("getHistoricalExchangeRates");
        return "getHistoricalExchangeRates";
    }

}

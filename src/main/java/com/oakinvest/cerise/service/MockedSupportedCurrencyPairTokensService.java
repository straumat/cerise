package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensParameters;
import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensResult;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Enumerating supported currency-pair tokens.
 *
 * @author straumat
 */
@Service
public class MockedSupportedCurrencyPairTokensService implements SupportedCurrencyPairTokensService {

    /**
     * The last parameter received by the service.
     */
    private SupportedCurrencyPairTokensParameters lastUsedParameter;

    @Override
    public final List<SupportedCurrencyPairTokensResult> getSupportedCurrencyPairTokens(final SupportedCurrencyPairTokensParameters parameters) {
        lastUsedParameter = parameters;
        List<SupportedCurrencyPairTokensResult> results = new LinkedList<>();
        SupportedCurrencyPairTokensResult result = new SupportedCurrencyPairTokensResult();

        // First result.
        result = new SupportedCurrencyPairTokensResult();
        result.setCp("XBTUSD-ver4");
        result.setQuote("USD");
        result.setBase("XBT");
        result.setLocale("en_US");
        result.setDesc("Smoothed averages");
        results.add(result);

        // Second result.
        result = new SupportedCurrencyPairTokensResult();
        result.setCp("2");
        result.setQuote("USD");
        result.setBase("XBT");
        result.setLocale("en_US");
        result.setDesc("Updated per-trade");
        results.add(result);

        // Third result.
        result = new SupportedCurrencyPairTokensResult();
        result.setCp("XBTUSD-european");
        result.setQuote("USD");
        result.setBase("XBT");
        result.setLocale("en_GB");
        results.add(result);

        return results;
    }

    /**
     * Getter of lastUsedParameter.
     *
     * @return lastUsedParameter
     */
    public final SupportedCurrencyPairTokensParameters getLastUsedParameter() {
        return lastUsedParameter;
    }

}

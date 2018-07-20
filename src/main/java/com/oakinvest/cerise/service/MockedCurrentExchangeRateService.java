package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Mocked current exchange rate service.
 *
 * @author straumat
 */
@Service
@SuppressWarnings("magicnumber")
public class MockedCurrentExchangeRateService implements CurrentExchangeRateService {

    /**
     * The last parameter received by the service.
     */
    // TODO Rename to parameters.
    private CurrentExchangeRateParameters lastUsedParameter;

    @Override
    public final List<CurrentExchangeRateResult> getCurrentExchangeRate(final CurrentExchangeRateParameters parameters) {
        lastUsedParameter = parameters;
        List<CurrentExchangeRateResult> results = new LinkedList<>();

        // First result.
        CurrentExchangeRateResult result = new CurrentExchangeRateResult();
        result.setCp("XBTUSD-ver4");
        result.setTime(1488767410);
        result.addRates("typical", 1349.332215);
        result.addRates("high", 1351.2);
        results.add(result);

        // Second result.
        result = new CurrentExchangeRateResult();
        result.setCp("2");
        result.setTime(1488767410);
        result.addRates("typical", 1350.111332);
        results.add(result);

        return results;
    }

    /**
     * Getter of lastUsedParameter.
     *
     * @return lastUsedParameter
     */
    public final CurrentExchangeRateParameters getLastUsedParameter() {
        return lastUsedParameter;
    }

}

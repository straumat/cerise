package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
import com.oakinvest.cerise.util.generic.CeriseService;
import org.apache.commons.lang3.StringUtils;
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
public class MockedCurrentExchangeRateService extends CeriseService implements CurrentExchangeRateService {

    /**
     * The last parameter received by the service.
     */
    private CurrentExchangeRateParameters lastReceivedParameter;

    @Override
    public final List<CurrentExchangeRateResult> getCurrentExchangeRate(final CurrentExchangeRateParameters parameters) {
        lastReceivedParameter = parameters;
        List<CurrentExchangeRateResult> results = new LinkedList<>();
        CurrentExchangeRateResult result;

        // Test for long CP maximum size.
        if (parameters.getCp().size() > 0 && "TEST_LONG_CP".equals(parameters.getCp().get(0))) {
            result = new CurrentExchangeRateResult();
            result.setCp(StringUtils.repeat("*", 256));
            result.setTime(1488767410.5463133);
            result.addRates("typical", 1349.332215);
            result.addRates("high", 1351.2);
            results.add(result);
            results.add(result);
        }

        // First result.
        result = new CurrentExchangeRateResult();
        result.setCp("XBTUSD-ver4");
        result.setTime(1488767410.5463133);
        result.addRates("typical", 1349.332215);
        result.addRates("high", 1351.2);
        results.add(result);

        // Second result.
        result = new CurrentExchangeRateResult();
        result.setCp("2");
        result.setTime(1488767410D);
        result.addRates("typical", 1350.111332);
        results.add(result);

        return results;
    }

    /**
     * Getter of lastReceivedParameter.
     *
     * @return lastReceivedParameter
     */
    public final CurrentExchangeRateParameters getLastReceivedParameter() {
        return lastReceivedParameter;
    }

}

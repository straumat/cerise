package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Mocked Historical exchange rates service.
 *
 * @author straumat
 */
@Service
@SuppressWarnings("magicnumber")
public class MockedHistoricalExchangeRatesService implements HistoricalExchangeRatesService {

    /**
     * The last parameter received by the service.
     */
    // TODO Rename to parameters.
    private HistoricalExchangeRatesParameters lastUsedParameter;

    @Override
    public final List<HistoricalExchangeRatesResult> getHistoricalExchangeRates(final HistoricalExchangeRatesParameters parameters) {
        lastUsedParameter = parameters;
        List<HistoricalExchangeRatesResult> results = new LinkedList<>();
        HistoricalExchangeRatesResult result = new HistoricalExchangeRatesResult();

        // Test for long CP maximum size.
        if (parameters.getCp().size() > 0 && "TEST_LONG_CP".equals(parameters.getCp().get(0))) {
            result = new HistoricalExchangeRatesResult();
            result.setCp(StringUtils.repeat("*", 256));
            result.setTime(1488760000);
            result.addRates("typical", 1300);
            results.add(result);
        }

        // First result.
        result = new HistoricalExchangeRatesResult();
        result.setCp("XBTUSD-ver4");
        result.setTime(1488760000);
        result.addRates("typical", 1300);
        results.add(result);

        // Second result.
        result = new HistoricalExchangeRatesResult();
        result.setCp("XBTUSD-ver4");
        result.setTime(1488760010);
        result.addRates("typical", 1301.1);
        results.add(result);

        // Third result.
        result = new HistoricalExchangeRatesResult();
        result.setCp("XBTUSD-ver4");
        result.setTime(1488760020);
        result.addRates("typical", 1320);
        results.add(result);

        // Fourth result.
        result = new HistoricalExchangeRatesResult();
        result.setCp("XBTUSD-ver4");
        result.setTime(1488760030);
        result.addRates("typical", 1305);
        results.add(result);

        // Sixth result.
        result = new HistoricalExchangeRatesResult();
        result.setCp("2");
        // TODO Not the good type. No "." allowed.
        result.setTime(1488760000);
        result.addRates("typical", 1300);
        results.add(result);

        return results;
    }

    /**
     * Getter of lastUsedParameter.
     *
     * @return lastUsedParameter
     */
    public final HistoricalExchangeRatesParameters getLastUsedParameter() {
        return lastUsedParameter;
    }

}

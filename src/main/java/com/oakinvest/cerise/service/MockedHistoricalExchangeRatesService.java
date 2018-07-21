package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;
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

        // First result.
        HistoricalExchangeRatesResult r = new HistoricalExchangeRatesResult();
        r.setCp("XBTUSD-ver4");
        r.setTime(1488760000);
        r.addRates("typical", 1300);
        results.add(r);

        // Second result.
        r = new HistoricalExchangeRatesResult();
        r.setCp("XBTUSD-ver4");
        r.setTime(1488760010);
        r.addRates("typical", 1301.1);
        results.add(r);

        // Third result.
        r = new HistoricalExchangeRatesResult();
        r.setCp("XBTUSD-ver4");
        r.setTime(1488760020);
        r.addRates("typical", 1320);
        results.add(r);

        // Fourth result.
        r = new HistoricalExchangeRatesResult();
        r.setCp("XBTUSD-ver4");
        r.setTime(1488760030);
        r.addRates("typical", 1305);
        results.add(r);

        // Sixth result.
        r = new HistoricalExchangeRatesResult();
        r.setCp("2");
        // TODO Not the good type. No "." allowed.
        r.setTime(1488760000);
        r.addRates("typical", 1300);
        results.add(r);

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

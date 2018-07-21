package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;

import java.util.List;

/**
 * Historical exchange rates service.
 *
 * @author straumat
 */
public interface HistoricalExchangeRatesService {

    /**
     * Historical exchange rates service.
     *
     * @param parameters parameters.
     * @return result.
     */
    List<HistoricalExchangeRatesResult> getHistoricalExchangeRates(HistoricalExchangeRatesParameters parameters);


}

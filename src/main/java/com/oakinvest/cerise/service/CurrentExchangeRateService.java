package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateResult;

import java.util.List;

/**
 * Current exchange rate service.
 *
 * @author straumat
 */
public interface CurrentExchangeRateService {

    /**
     * Current exchange rate service.
     *
     * @param parameters parameters
     * @return results
     */
    List<CurrentExchangeRateResult> getCurrentExchangeRate(CurrentExchangeRateParameters parameters);

}

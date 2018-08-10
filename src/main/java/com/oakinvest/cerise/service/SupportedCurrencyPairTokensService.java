package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensParameters;
import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensResult;

import java.util.List;

/**
 * Enumerating supported currency-pair tokens service.
 *
 * @author straumat
 */
public interface SupportedCurrencyPairTokensService {

    /**
     * Enumerating supported currency-pair tokens service.
     *
     * @param parameters rest parameters
     * @return rest results
     */
    List<SupportedCurrencyPairTokensResult> getSupportedCurrencyPairTokens(SupportedCurrencyPairTokensParameters parameters);

}

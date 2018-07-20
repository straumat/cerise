package com.oakinvest.cerise.service;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.CurrencyPairInformationResult;

import java.util.List;

/**
 * Currency-pair information service.
 *
 * @author straumat
 */
public interface CurrencyPairInformationService {

    /**
     * Currency-pair information service.
     *
     * @param parameters rest parameters
     * @return rest results
     */
    List<CurrencyPairInformationResult> getCurrencyPairInformation(CurrencyPairInformationParameters parameters);

}

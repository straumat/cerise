package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
import com.oakinvest.cerise.service.CurrentExchangeRateService;
import com.oakinvest.cerise.util.generic.CeriseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Current exchange rate controller.
 *
 * @author straumat
 */
@RestController
public class CurrentExchangeRateController extends CeriseController implements CurrentExchangeRateAPI {

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(CurrentExchangeRateController.class);

    /**
     * Currency-pair information service.
     */
    private final CurrentExchangeRateService service;

    /**
     * Constructor.
     *
     * @param newService service
     */
    public CurrentExchangeRateController(final CurrentExchangeRateService newService) {
        this.service = newService;
    }

    @Override
    public final List<CurrentExchangeRateResult> getCurrencyPairInformation(final String mode,
                                                                            final String[] cp,
                                                                            final String[] type,
                                                                            final Double minrate,
                                                                            final Double maxrate,
                                                                            final String nonce) {
        log.info("Current exchange rate called : cp={}, type={}, minrate={}, maxrate={}, nonce={}.", Arrays.toString(cp), Arrays.toString(type), minrate, maxrate, nonce);

        // ------------------------------------------------ -------------------------------------------------------------
        // Validating parameters.
        validateCPList(cp);
        validateCurrencyCodeList(cp);

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        CurrentExchangeRateParameters p = new CurrentExchangeRateParameters(getListFromArray(cp),
                getListFromArray(type),
                minrate,
                maxrate,
                nonce
        );


        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        final List<CurrentExchangeRateResult> results = service.getCurrentExchangeRate(p);

        // ------------------------------------------------ -------------------------------------------------------------
        // Validating results.
        final List<String> cpList = new LinkedList<>();
        results.forEach(data -> cpList.add(data.getCp()));
        validateCPList(cpList);

        return results;
    }

}

package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.CurrencyPairInformationResult;
import com.oakinvest.cerise.service.CurrencyPairInformationService;
import com.oakinvest.cerise.util.generic.CeriseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * Currency-pair information.
 *
 * @author straumat
 */
@RestController
public class CurrencyPairInformationController extends CeriseController implements CurrencyPairInformationAPI {

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(CurrencyPairInformationController.class);

    /**
     * Currency-pair information service.
     */
    private CurrencyPairInformationService service;

    /**
     * Constructor.
     *
     * @param newService service
     */
    public CurrencyPairInformationController(final CurrencyPairInformationService newService) {
        this.service = newService;
    }

    @Override
    public final List<CurrencyPairInformationResult> getCurrencyPairInformation(final String mode, final String[] cp) {
        log.info("Supported currency-pair tokens called : cp={}.", cp);

        // ------------------------------------------------ -------------------------------------------------------------
        // Validating parameters.

        // Validating CP
        validateCPList(cp);
        //validateCurrencyCodeList(Arrays.asList(quote));

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        CurrencyPairInformationParameters p = new CurrencyPairInformationParameters(getListFromArray(cp));

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        final List<CurrencyPairInformationResult> results = service.getCurrencyPairInformation(p);

        // ------------------------------------------------ -------------------------------------------------------------
        // Validating results.

        // Validating CP.
        final List<String> cpList = new LinkedList<>();
        results.forEach(data -> cpList.add(data.getCp()));
        validateCPList(cpList);

        // -------------------------------------------------------------------------------------------------------------
        // Returning the value.
        return results;
    }

}

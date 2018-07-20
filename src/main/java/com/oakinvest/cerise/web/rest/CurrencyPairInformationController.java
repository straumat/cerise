package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.CurrencyPairInformationResult;
import com.oakinvest.cerise.service.CurrencyPairInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Currency-pair information.
 *
 * @author straumat
 */
@RestController
public class CurrencyPairInformationController implements CurrencyPairInformationAPI {

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
    public final List<CurrencyPairInformationResult> getCurrencyPairInformation(final String mode, final String cp) {
        log.info("Supported currency-pair tokens called : cp={}.", cp);

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        // TODO Check valid values for cp.
        CurrencyPairInformationParameters p = new CurrencyPairInformationParameters(getCleanValue(cp));

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        return service.getCurrencyPairInformation(p);
    }

    /**
     * Returns optional value of a value.
     *
     * @param value value
     * @return optional value
     */
    private String getCleanValue(final String value) {
        if (value == null || "" .equals(value)) {
            return null;
        } else {
            return value.trim();
        }
    }

}

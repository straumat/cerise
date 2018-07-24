package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
import com.oakinvest.cerise.service.CurrentExchangeRateService;
import com.oakinvest.cerise.util.generic.CeriseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

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
    private CurrentExchangeRateService service;

    /**
     * Constructor.
     *
     * @param newService newService
     */
    public CurrentExchangeRateController(final CurrentExchangeRateService newService) {
        this.service = newService;
    }

    @Override
    public final List<CurrentExchangeRateResult> getCurrencyPairInformation(final String mode, final String cp, final String type, final String minrate, final String maxrate, final String nonce) {
        log.info("Supported currency-pair tokens called : cp={}, type={}, minrate={}, maxrate={}, nonce={}.", cp, type, minrate, maxrate, nonce);

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        // TODO Check valid values for parameters.


        CurrentExchangeRateParameters p = new CurrentExchangeRateParameters(getCleanValue(cp),
                getListFromString(type),
                getCleanValue(minrate),
                getCleanValue(maxrate),
                getCleanValue(nonce)
        );

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        return service.getCurrentExchangeRate(p);
    }

}

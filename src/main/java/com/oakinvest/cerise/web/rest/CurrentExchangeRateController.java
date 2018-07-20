package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
import com.oakinvest.cerise.service.CurrentExchangeRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Current exchange rate controller.
 *
 * @author straumat
 */
@RestController
public class CurrentExchangeRateController implements CurrentExchangeRateAPI {

    /**
     * Separator.
     */
    private static final String SEPARATOR = ",";

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
        List<String> types = new LinkedList<>();
        if (type != null) {
            StringTokenizer tokenizer = new StringTokenizer(type, SEPARATOR);
            while (tokenizer.hasMoreTokens()) {
                types.add(tokenizer.nextToken().trim());
            }
        }

        CurrentExchangeRateParameters p = new CurrentExchangeRateParameters(getCleanValue(cp),
                types,
                getCleanValue(minrate),
                getCleanValue(maxrate),
                getCleanValue(nonce)
        );

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        return service.getCurrentExchangeRate(p);
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

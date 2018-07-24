package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensParameters;
import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensResult;
import com.oakinvest.cerise.service.SupportedCurrencyPairTokensService;
import com.oakinvest.cerise.util.generic.CeriseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Enumerating supported currency-pair tokens.
 *
 * @author straumat
 */
@RestController
public class SupportedCurrencyPairTokensController extends CeriseController implements SupportedCurrencyPairTokensAPI {

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(SupportedCurrencyPairTokensController.class);

    /**
     * Service.
     */
    private SupportedCurrencyPairTokensService service;

    /**
     * Constructor.
     *
     * @param supportedCurrencyPairTokensService supported currency-pair tokens service
     */
    public SupportedCurrencyPairTokensController(final SupportedCurrencyPairTokensService supportedCurrencyPairTokensService) {
        this.service = supportedCurrencyPairTokensService;
    }

    @Override
    public final List<SupportedCurrencyPairTokensResult> getSupportedCurrencyPairTokens(final String mode, final String quote, final String base, final String locale) {
        log.info("Supported currency-pair tokens called : quote={}, base={}, locale={}.", quote, base, locale);

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.

        // TODO Checking that quote exists.

        // TODO Checking that base exists.

        // Checking that locales exists.
        // TODO Implements "commons lang has a utility method to parse and validate locale strings: LocaleUtils.toLocale(String)"
        // https://stackoverflow.com/questions/3684747/how-to-validate-a-locale-in-java

        SupportedCurrencyPairTokensParameters p = new SupportedCurrencyPairTokensParameters(getCleanValue(quote),
                getCleanValue(base),
                getList(locale));

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        return service.getSupportedCurrencyPairTokens(p);
    }

}

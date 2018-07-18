package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensParameters;
import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensResult;
import com.oakinvest.cerise.service.SupportedCurrencyPairTokensService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Enumerating supported currency-pair tokens.
 *
 * @author straumat
 */
@RestController
public class SupportedCurrencyPairTokensRESTImplementation implements SupportedCurrencyPairTokensRESTInterface {

    /**
     * Separator.
     */
    private static final String SEPARATOR = ",";

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(SupportedCurrencyPairTokensRESTImplementation.class);

    /**
     * Service.
     */
    private SupportedCurrencyPairTokensService service;

    /**
     * Constructor.
     *
     * @param supportedCurrencyPairTokensService supported currency-pair tokens service
     */
    public SupportedCurrencyPairTokensRESTImplementation(final SupportedCurrencyPairTokensService supportedCurrencyPairTokensService) {
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
        List<String> locales = new LinkedList<>();
        if (locale != null) {
            StringTokenizer tokenizer = new StringTokenizer(locale, SEPARATOR);
            while (tokenizer.hasMoreTokens()) {
                locales.add(tokenizer.nextToken().trim());
            }
        }

        SupportedCurrencyPairTokensParameters p = new SupportedCurrencyPairTokensParameters(getCleanValue(quote),
                getCleanValue(base),
                locales);

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        return service.getSupportedCurrencyPairTokens(p);
    }

    /**
     * Returns optional value of a value.
     *
     * @param value value
     * @return optional value
     */
    private String getCleanValue(final String value) {
        if (value == null || "".equals(value)) {
            return null;
        } else {
            return value.trim();
        }
    }

}

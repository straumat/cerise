package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensParameters;
import com.oakinvest.cerise.dto.SupportedCurrencyPairTokensResult;
import com.oakinvest.cerise.service.SupportedCurrencyPairTokensService;
import com.oakinvest.cerise.util.generic.CeriseController;
import com.oakinvest.cerise.util.generic.CeriseErrorDetail;
import com.oakinvest.cerise.util.generic.CeriseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.oakinvest.cerise.util.generic.CeriseErrorType.invalid_request_error;

/**
 * Enumerating supported currency-pair tokens controller.
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
    private final SupportedCurrencyPairTokensService service;

    /**
     * Constructor.
     *
     * @param newService service
     */
    public SupportedCurrencyPairTokensController(final SupportedCurrencyPairTokensService newService) {
        this.service = newService;
    }

    @Override
    public final List<SupportedCurrencyPairTokensResult> getSupportedCurrencyPairTokens(final String mode, final String[] quote, final String[] base, final String[] locale) {
        log.info("Supported currency-pair tokens called : quote={}, base={}, locale={}.", Arrays.toString(quote), Arrays.toString(base), Arrays.toString(locale));

        // -------------------------------------------------------------------------------------------------------------
        // Validating parameters.
        final List<CeriseErrorDetail> errors = new LinkedList<>();
        errors.addAll(getErrorsForCurrencyValues(quote));
        errors.addAll(getErrorsForCurrencyValues(base));
        errors.addAll(getErrorsForLocaleValues(locale));

        // -------------------------------------------------------------------------------------------------------------
        // If there is at least one error, raise an exception.
        if (!errors.isEmpty()) {
            throw new CeriseException(invalid_request_error, "Invalid request to enumerating supported currency-pair", errors);
        }

        // -------------------------------------------------------------------------------------------------------------
        // Creating the parameters.
        SupportedCurrencyPairTokensParameters p = new SupportedCurrencyPairTokensParameters(getListFromArray(quote),
                getListFromArray(base),
                getListFromArray(locale));

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        return service.getSupportedCurrencyPairTokens(p);
    }

}

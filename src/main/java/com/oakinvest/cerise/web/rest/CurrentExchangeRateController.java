package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrentExchangeRateParameters;
import com.oakinvest.cerise.dto.CurrentExchangeRateResult;
import com.oakinvest.cerise.service.CurrentExchangeRateService;
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

        // -------------------------------------------------------------------------------------------------------------
        // Validating parameters.
        final List<CeriseErrorDetail> errors = new LinkedList<>();
        errors.addAll(getErrorsForCurrencyValues(cp));

        // -------------------------------------------------------------------------------------------------------------
        // If there is at least one error, raise an exception.
        if (!errors.isEmpty()) {
            throw new CeriseException(invalid_request_error, "Invalid request to current exchange rate controller", errors);
        }

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        CurrentExchangeRateParameters p = new CurrentExchangeRateParameters(getListFromArray(cp),
                getListFromArray(type),
                minrate,
                maxrate,
                nonce
        );

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service & returning the value.
        return service.getCurrentExchangeRate(p);
    }

}

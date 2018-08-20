package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.CurrencyPairInformationParameters;
import com.oakinvest.cerise.dto.CurrencyPairInformationResult;
import com.oakinvest.cerise.service.CurrencyPairInformationService;
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
 * Currency-pair information controller.
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
    private final CurrencyPairInformationService service;

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
        log.info("Currency-pair tokens called : cp={}.", Arrays.toString(cp));

        // -------------------------------------------------------------------------------------------------------------
        // Validating parameters.
        final List<CeriseErrorDetail> errors = new LinkedList<>(getErrorsForCurrencyValues(cp));

        // -------------------------------------------------------------------------------------------------------------
        // If there is at least one error, raise an exception.
        if (!errors.isEmpty()) {
            throw new CeriseException(invalid_request_error, "Invalid request to currency-pair information", errors);
        }

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        CurrencyPairInformationParameters p = new CurrencyPairInformationParameters(getListFromArray(cp));

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service & returning the value.
        return service.getCurrencyPairInformation(p);
    }

}

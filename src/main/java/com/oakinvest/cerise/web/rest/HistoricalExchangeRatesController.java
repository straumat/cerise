package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;
import com.oakinvest.cerise.service.HistoricalExchangeRatesService;
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
 * Historical exchange rates controller.
 *
 * @author straumat
 */
@RestController
@SuppressWarnings("ParameterNumber")
public class HistoricalExchangeRatesController extends CeriseController implements HistoricalExchangeRatesAPI {

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(HistoricalExchangeRatesController.class);

    /**
     * Currency-pair information service.
     */
    private final HistoricalExchangeRatesService service;

    /**
     * Constructor.
     *
     * @param newService service
     */
    public HistoricalExchangeRatesController(final HistoricalExchangeRatesService newService) {
        this.service = newService;
    }

    @Override
    public final List<HistoricalExchangeRatesResult> getHistoricalExchangeRates(final String mode, final String[] cp, final String[] type, final Double from, final Double to, final Boolean nearest, final Float ratedelta, final Float timedelta) {
        log.info("Historical exchange rates called : cp={}, type={}, from={}, to={}, nearest={}, ratedelta={}, timedelta = {}.", Arrays.toString(cp), Arrays.toString(type), from, to, nearest, ratedelta, timedelta);

        // -------------------------------------------------------------------------------------------------------------
        // Validating parameters.
        final List<CeriseErrorDetail> errors = new LinkedList<>(getErrorsForCurrencyValues(cp));

        // -------------------------------------------------------------------------------------------------------------
        // If there is at least one error, raise an exception.
        if (!errors.isEmpty()) {
            throw new CeriseException(invalid_request_error, "Invalid request to historical exchange rates", errors);
        }

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        HistoricalExchangeRatesParameters p = new HistoricalExchangeRatesParameters(getListFromArray(cp),
                getListFromArray(type),
                from,
                to,
                nearest,
                ratedelta,
                timedelta
        );

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service & returning the value.
        return service.getHistoricalExchangeRates(p);
    }

}

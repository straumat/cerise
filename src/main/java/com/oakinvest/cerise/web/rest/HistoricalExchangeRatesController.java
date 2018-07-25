package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;
import com.oakinvest.cerise.service.HistoricalExchangeRatesService;
import com.oakinvest.cerise.util.generic.CeriseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    private HistoricalExchangeRatesService service;

    /**
     * Constructor.
     *
     * @param newService service
     */
    public HistoricalExchangeRatesController(final HistoricalExchangeRatesService newService) {
        this.service = newService;
    }

    @Override
    public final List<HistoricalExchangeRatesResult> getHistoricalExchangeRates(final String mode, final String[] cp, final String[] type, final Long from, final Long to, final Boolean nearest, final Float ratedelta, final Float timedelta) {
        log.info("Supported currency-pair tokens called : cp={}, type={}, from={}, to={}, nearest={}, ratedelta={}, timedelta = {}.", cp, type, from, to, nearest, ratedelta, timedelta);

        // ------------------------------------------------ -------------------------------------------------------------
        // Validating parameters.

        // Validating CP
        validateCPList(Arrays.asList(cp));

        // -------------------------------------------------------------------------------------------------------------
        // Building the parameters.
        // TODO Check valid values for parameters.

        HistoricalExchangeRatesParameters p = new HistoricalExchangeRatesParameters(getListFromArray(cp),
                getListFromArray(type),
                from,
                to,
                nearest,
                ratedelta,
                timedelta
        );

        // -------------------------------------------------------------------------------------------------------------
        // Calling the service.
        final List<HistoricalExchangeRatesResult> results = service.getHistoricalExchangeRates(p);

        // ------------------------------------------------ -------------------------------------------------------------
        // Validating results.

        // Validating CP.
        final List<String> cpList = new LinkedList<>();
        results.forEach(data -> cpList.add(data.getCp()));
        validateCPList(cpList);

        return results;
    }

}

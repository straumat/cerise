package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.dto.HistoricalExchangeRatesParameters;
import com.oakinvest.cerise.dto.HistoricalExchangeRatesResult;
import com.oakinvest.cerise.service.HistoricalExchangeRatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Historical exchange rates controller.
 *
 * @author straumat
 */
@RestController
@SuppressWarnings("ParameterNumber")
public class HistoricalExchangeRatesController implements HistoricalExchangeRatesAPI {

    /**
     * Separator.
     */
    private static final String SEPARATOR = ",";

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
    public final List<HistoricalExchangeRatesResult> getHistoricalExchangeRates(final String mode, final String cp, final String type, final Long from, final Long to, final Boolean nearest, final Float ratedelta, final Float timedelta) {
        log.info("Supported currency-pair tokens called : cp={}, type={}, from={}, to={}, nearest={}, ratedelta={}, timedelta = {}.", cp, type, from, to, nearest, ratedelta, timedelta);

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

        HistoricalExchangeRatesParameters p = new HistoricalExchangeRatesParameters(getCleanValue(cp),
                types,
                from,
                to,
                nearest,
                ratedelta,
                timedelta
        );

        return service.getHistoricalExchangeRates(p);
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

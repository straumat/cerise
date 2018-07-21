package com.oakinvest.cerise.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Historical exchange rates result.
 *
 * @author straumat
 */
@SuppressWarnings("magicnumber")
public class HistoricalExchangeRatesResult {

    /**
     * The currency-pair token.
     */
    @ApiModelProperty(notes = "The currency-pair token", example = "XBTUSD-ver4", required = true, position = 1)
    private String cp;

    /**
     * The time (as a POSIX timestamp) the rate information is applicable to (should be approximately the request time).
     */
    @ApiModelProperty(notes = "The time (as a POSIX timestamp) the rate information is applicable to (should be approximately the request time).", example = "1488767410.5463133", required = true, position = 2)
    private long time;

    /**
     * A JSON Object with each rate type provided as a key, and a Number as the value specifying the rate.
     */
    @ApiModelProperty(notes = "The time (as a POSIX timestamp) the rate information is applicable to (should be approximately the request time).", example = "1488767410.5463133", required = true, position = 3)
    private List<Rate> rates = new LinkedList<>();

    /**
     * Getter of cp.
     *
     * @return cp
     */
    public final String getCp() {
        return cp;
    }

    /**
     * Setterde of cp.
     *
     * @param newCp the cp to set
     */
    public final void setCp(final String newCp) {
        cp = newCp;
    }

    /**
     * Getter of time.
     *
     * @return time
     */
    public final long getTime() {
        return time;
    }

    /**
     * Setterde of time.
     *
     * @param newTime the time to set
     */
    public final void setTime(final long newTime) {
        time = newTime;
    }

    /**
     * Getter of rates.
     *
     * @return rates
     */
    public final List<Rate> getRates() {
        return rates;
    }

    /**
     * Add a rate to the list of rates.
     *
     * @param type  type
     * @param value value
     */
    public final void addRates(final String type, final double value) {
        Rate r = new Rate();
        r.setType(type);
        r.setValue(value);
        getRates().add(r);
    }

    /**
     * Setterde of rates.
     *
     * @param newRates the rates to set
     */
    public final void setRates(final List<Rate> newRates) {
        rates = newRates;
    }

}

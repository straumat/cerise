package com.oakinvest.cerise.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Historical exchange rates result.
 *
 * @author straumat
 */
@SuppressWarnings("magicnumber")
@JsonInclude(NON_NULL)
public class HistoricalExchangeRatesResult {

    /**
     * The currency-pair token. Currency-pair tokens are arbitrary Strings no longer than 255 characters, which may include any ASCII RFC 3986 unreserved characters (ie, alphanumerics and the hyphen, underscore, period, and tilde symbols).
     */
    @ApiModelProperty(notes = "The currency-pair token. Currency-pair tokens are arbitrary Strings no longer than 255 characters, which may include any ASCII RFC 3986 unreserved characters (ie, alphanumerics and the hyphen, underscore, period, and tilde symbols)",
            example = "XBTUSD-ver4",
            required = true,
            position = 1)
    private String cp;

    /**
     * The time (as a POSIX timestamp) the rate information is applicable to (should be approximately the request time).
     */
    @ApiModelProperty(notes = "The time (as a POSIX timestamp) the rate information is applicable to (should be approximately the request time).",
            example = "1488767410.5463133",
            required = true,
            position = 2)
    private Double time;

    /**
     * A JSON Object with each rate type provided as a key, and a Number as the value specifying the rate.
     */
    @ApiModelProperty(notes = "A JSON Object with each rate type provided as a key, and a Number as the value specifying the rate.",
            required = true,
            position = 3)
    private Map<String, Object> rates = new LinkedHashMap<>();

    /**
     * Getter of cp.
     *
     * @return cp
     */
    public final String getCp() {
        return cp;
    }

    /**
     * Setter of cp.
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
    public final Double getTime() {
        return time;
    }

    /**
     * Setter of time.
     *
     * @param newTime the time to set
     */
    public final void setTime(final Double newTime) {
        time = newTime;
    }

    /**
     * Getter of rates.
     *
     * @return rates
     */
    public final Map<String, Object> getRates() {
        return rates;
    }

    /**
     * Add a rate to the list of rates.
     *
     * @param type  type
     * @param value value
     */
    public final void addRates(final String type, final double value) {
        rates.put(type, value);
    }

}

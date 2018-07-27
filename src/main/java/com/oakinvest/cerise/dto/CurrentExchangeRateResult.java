package com.oakinvest.cerise.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Current exchange rate result.
 *
 * @author straumat
 */
@SuppressWarnings("magicnumber")
@JsonInclude(NON_NULL)
public class CurrentExchangeRateResult {

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
    @ApiModelProperty(notes = "A JSON Object with each rate type provided as a key, and a Number as the value specifying the rate.).",
            required = true,
            position = 3)
    private Map<String, Object> rates = new LinkedHashMap<>();

    /**
     * Only if the request specified a nonce, the server SHOULD include it here as a JSON String.
     */
    @ApiModelProperty(notes = "Only if the request specified a nonce, the server SHOULD include it here as a JSON String.",
            example = "ERAGDYEJAGD",
            required = true,
            position = 4)
    private String nonce;

    /**
     * Optional. May be used for Linked Data Signatures.
     */
    @ApiModelProperty(notes = "May be used for Linked Data Signatures",
            position = 5)
    private String signature;

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
     * Setter of rates.
     *
     * @param newRates the rates to set
     */
    public final void setRates(final Map<String, Object> newRates) {
        rates = newRates;
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

    /**
     * Getter of nonce.
     *
     * @return nonce
     */
    public final String getNonce() {
        return nonce;
    }

    /**
     * Setter of nonce.
     *
     * @param newNonce the nonce to set
     */
    public final void setNonce(final String newNonce) {
        nonce = newNonce;
    }

    /**
     * Getter of signature.
     *
     * @return signature
     */
    public final String getSignature() {
        return signature;
    }

    /**
     * Setter of signature.
     *
     * @param newSignature the signature to set
     */
    public final void setSignature(final String newSignature) {
        signature = newSignature;
    }

}

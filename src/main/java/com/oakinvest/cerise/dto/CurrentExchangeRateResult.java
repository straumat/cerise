package com.oakinvest.cerise.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Current exchange rate result.
 *
 * @author straumat
 */
@SuppressWarnings("magicnumber")
public class CurrentExchangeRateResult {

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
    @ApiModelProperty(notes = "The time (as a POSIX timestamp) the rate information is applicable to (should be approximately the request time).", example = "1488767410.5463133", required = true, position = 2)
    private List<Rate> rates = new LinkedList<>();

    /**
     * Only if the request specified a nonce, the server SHOULD include it here as a JSON String.
     */
    @ApiModelProperty(notes = "Only if the request specified a nonce, the server SHOULD include it here as a JSON String.", example = "ERAGDYEJAGD", required = true, position = 2)
    private String nonce;

    /**
     * Optional. May be used for Linked Data Signatures.
     */
    @ApiModelProperty(notes = "May be used for Linked Data Signatures", position = 5)
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
     * Setterde of rates.
     *
     * @param newRates the rates to set
     */
    public final void setRates(final List<Rate> newRates) {
        rates = newRates;
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
     * Getter of nonce.
     *
     * @return nonce
     */
    public final String getNonce() {
        return nonce;
    }

    /**
     * Setterde of nonce.
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
     * Setterde of signature.
     *
     * @param newSignature the signature to set
     */
    public final void setSignature(final String newSignature) {
        signature = newSignature;
    }

}

package com.oakinvest.cerise.dto;

import java.util.List;

/**
 * Current exchange rate parameters.
 *
 * @author straumat
 */
public class CurrentExchangeRateParameters {

    /**
     * Always "rate" for this request.
     */
    private Mode mode = Mode.rate;

    /**
     * Currency pair(s) for which information is requested.
     */
    private String cp;

    /**
     * Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     */
    private List<String> types;

    /**
     * If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     */
    private String minrate;

    /**
     * If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     */
    private String maxrate;

    /**
     * If specified, the server SHOULD return it in each result.
     */
    private String nonce;

    /**
     * Constructor.
     *
     * @param newCp      Currency pair(s) for which rate is requested.
     * @param newTypes    Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     * @param newMinrate If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     * @param newMaxrate If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     * @param newNonce   If specified, the server SHOULD return it in each result.
     */
    public CurrentExchangeRateParameters(final String newCp, final List<String> newTypes, final String newMinrate, final String newMaxrate, final String newNonce) {
        this.cp = newCp;
        this.types = newTypes;
        this.minrate = newMinrate;
        this.maxrate = newMaxrate;
        this.nonce = newNonce;
    }

    /**
     * Getter of mode.
     *
     * @return mode
     */
    public final Mode getMode() {
        return mode;
    }

    /**
     * Getter of cp.
     *
     * @return cp
     */
    public final String getCp() {
        return cp;
    }

    /**
     * Getter of types.
     *
     * @return types
     */
    public final List<String> getTypes() {
        return types;
    }

    /**
     * Getter of minrate.
     *
     * @return minrate
     */
    public final String getMinrate() {
        return minrate;
    }

    /**
     * Getter of maxrate.
     *
     * @return maxrate
     */
    public final String getMaxrate() {
        return maxrate;
    }

    /**
     * Getter of nonce.
     *
     * @return nonce
     */
    public final String getNonce() {
        return nonce;
    }

}

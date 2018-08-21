package com.oakinvest.cerise.dto;

import com.oakinvest.cerise.util.generic.CeriseParameters;

import java.util.List;

/**
 * Current exchange rate parameters.
 *
 * @author straumat
 */
public class CurrentExchangeRateParameters extends CeriseParameters {

    /**
     * Currency pair(s) for which information is requested.
     */
    private final List<String> cp;

    /**
     * Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     */
    private final List<String> types;

    /**
     * If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     */
    private final Double minrate;

    /**
     * If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     */
    private final Double maxrate;

    /**
     * If specified, the server SHOULD return it in each result.
     */
    private final String nonce;

    /**
     * Constructor.
     *
     * @param newCp      Currency pair(s) for which rate is requested.
     * @param newTypes    Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     * @param newMinrate If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     * @param newMaxrate If specified, indicates this request is a longpoll. The server should not send a response until the rate(s) fall below or above (respectively) the provided value.
     * @param newNonce   If specified, the server SHOULD return it in each result.
     */
    public CurrentExchangeRateParameters(final List<String> newCp, final List<String> newTypes, final Double newMinrate, final Double newMaxrate, final String newNonce) {
        setMode(Mode.rate);
        this.cp = newCp;
        this.types = newTypes;
        this.minrate = newMinrate;
        this.maxrate = newMaxrate;
        this.nonce = newNonce;
    }

    /**
     * Getter of cp.
     *
     * @return cp
     */
    public final List<String> getCp() {
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
    public final Double getMinrate() {
        return minrate;
    }

    /**
     * Getter of maxrate.
     *
     * @return maxrate
     */
    public final Double getMaxrate() {
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

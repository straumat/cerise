package com.oakinvest.cerise.dto;

/**
 * Currency-pair information parameters.
 *
 * @author straumat
 */
public class CurrencyPairInformationParameters {

    /**
     * Always "info" for this request.
     */
    private Mode mode = Mode.info;

    /**
     * Currency pair(s) for which information is requested.
     */
    private String cp;

    /**
     * Constructor.
     *
     * @param newCp Currency pair(s) for which information is requested.
     */
    public CurrencyPairInformationParameters(final String newCp) {
        this.cp = newCp;
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

}
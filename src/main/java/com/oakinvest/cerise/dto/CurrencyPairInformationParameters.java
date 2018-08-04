package com.oakinvest.cerise.dto;

import java.util.List;

/**
 * Currency-pair information parameters.
 *
 * @author straumat
 */
public class CurrencyPairInformationParameters {

    /**
     * Always "info" for this request.
     */
    private final Mode mode = Mode.info;

    /**
     * Currency pair(s) for which information is requested.
     */
    private final List<String> cp;

    /**
     * Constructor.
     *
     * @param newCp Currency pair(s) for which information is requested
     */
    public CurrencyPairInformationParameters(final List<String> newCp) {
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
    public final List<String> getCp() {
        return cp;
    }

}

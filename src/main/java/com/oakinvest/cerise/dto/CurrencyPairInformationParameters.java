package com.oakinvest.cerise.dto;

import com.oakinvest.cerise.util.generic.CeriseParameters;

import java.util.List;

/**
 * Currency-pair information parameters.
 *
 * @author straumat
 */
public class CurrencyPairInformationParameters extends CeriseParameters {

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
        setMode(Mode.info);
        this.cp = newCp;
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

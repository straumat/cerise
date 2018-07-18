package com.oakinvest.cerise.dto;

/**
 * Mode parameter.
 */
public enum Mode {

    /**
     * Enumerating supported currency-pair tokens.
     */
    list,

    /**
     * Currency-pair information.
     */
    info,

    /**
     * Current exchange rate.
     */
    rate,

    /**
     * Historical exchange rates.
     */
    history

}

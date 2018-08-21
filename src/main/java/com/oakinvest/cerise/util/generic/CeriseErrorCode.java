package com.oakinvest.cerise.util.generic;

/**
 * Cerise error codes.
 *
 * @author straumat
 */
@SuppressWarnings("unused")
public enum CeriseErrorCode {

    /**
     * Currency-pair tokens are longer than 255 characters.
     */
    currency_pair_too_large,

    /**
     * Currency code invalid.
     */
    currency_code_invalid,

    /**
     * Locale invalid.
     */
    locale_invalid,

    /**
     * Unspecified error.
     */
    unspecified_error,

    /**
     * Unknown error.
     */
    unknown_error

}

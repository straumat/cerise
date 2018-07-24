package com.oakinvest.cerise.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Supported currency-pair tokens results.
 */
@SuppressWarnings("magicnumber")
public class SupportedCurrencyPairTokensResult {

    /**
     * The currency-pair token.
     */
    @ApiModelProperty(notes = "The currency-pair token", example = "XBTUSD-ver4", required = true, position = 1)
    private String cp;

    /**
     * The currency code for the quote currency.
     */
    @ApiModelProperty(notes = "The currency code for the quote currency", example = "USD", required = true, position = 2)
    private String quote;

    /**
     * The currency code for the base currency.
     */
    @ApiModelProperty(notes = "The currency code for the base currency", example = "XBT", required = true, position = 3)
    private String base;

    /**
     * If provided, a String with the applicable Unicode CLDR locale.
     */
    @ApiModelProperty(notes = "If provided, a String with the applicable Unicode CLDR locale", example = "en_US", required = true, position = 4)
    private String locale;

    /**
     * Optional description. For example, it could be "Based on Florida BTM prices." or any other short String that provides information useful to the user. SHOULD be shorter than 45 characters.
     */
    @ApiModelProperty(notes = "Optional description. For example, it could be \"Based on Florida BTM prices.\" or any other short String that provides information useful to the user", example = "Smoothed averages", position = 5)
    private String desc;

    /**
     * Optional. May be used for Linked Data Signatures.
     */
    @ApiModelProperty(notes = "May be used for Linked Data Signatures", position = 6)
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
     * Getter of quote.
     *
     * @return quote
     */
    public final String getQuote() {
        return quote;
    }

    /**
     * Setterde of quote.
     *
     * @param newQuote the quote to set
     */
    public final void setQuote(final String newQuote) {
        quote = newQuote;
    }

    /**
     * Getter of base.
     *
     * @return base
     */
    public final String getBase() {
        return base;
    }

    /**
     * Setterde of base.
     *
     * @param newBase the base to set
     */
    public final void setBase(final String newBase) {
        base = newBase;
    }

    /**
     * Getter of locale.
     *
     * @return locale
     */
    public final String getLocale() {
        return locale;
    }

    /**
     * Setterde of locale.
     *
     * @param newLocale the locale to set
     */
    public final void setLocale(final String newLocale) {
        locale = newLocale;
    }

    /**
     * Getter of desc.
     *
     * @return desc
     */
    public final String getDesc() {
        return desc;
    }

    /**
     * Setterde of desc.
     *
     * @param newDesc the desc to set
     */
    public final void setDesc(final String newDesc) {
        desc = newDesc;
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
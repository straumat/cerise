package com.oakinvest.cerise.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Supported currency-pair tokens results.
 */
@SuppressWarnings("magicnumber")
@JsonInclude(NON_NULL)
public class SupportedCurrencyPairTokensResult {

    /**
     * The currency-pair token. Currency-pair tokens are arbitrary Strings no longer than 255 characters, which may include any ASCII RFC 3986 unreserved characters (ie, alphanumerics and the hyphen, underscore, period, and tilde symbols).
     */
    @ApiModelProperty(value = "The currency-pair token. Currency-pair tokens are arbitrary Strings no longer than 255 characters, which may include any ASCII RFC 3986 unreserved characters (ie, alphanumerics and the hyphen, underscore, period, and tilde symbols)",
            example = "XBTUSD-ver4",
            required = true,
            position = 1)
    private String cp;

    /**
     * The currency code for the quote currency.
     */
    @ApiModelProperty(value = "The currency code for the quote currency",
            example = "USD",
            required = true,
            position = 2)
    private String quote;

    /**
     * The currency code for the base currency.
     */
    @ApiModelProperty(value = "The currency code for the base currency",
            example = "XBT",
            required = true,
            position = 3)
    private String base;

    /**
     * If provided, a String with the applicable Unicode CLDR locale.
     */
    @ApiModelProperty(value = "If provided, a String with the applicable Unicode CLDR locale",
            example = "en_US",
            position = 4)
    private String locale;

    /**
     * Optional description. For example, it could be "Based on Florida BTM prices." or any other short String that provides information useful to the user. SHOULD be shorter than 45 characters.
     */
    @ApiModelProperty(value = "Optional description. For example, it could be \"Based on Florida BTM prices.\" or any other short String that provides information useful to the user",
            example = "Smoothed averages",
            position = 5)
    private String desc;

    /**
     * Optional. May be used for Linked Data Signatures.
     */
    @ApiModelProperty(value = "May be used for Linked Data Signatures",
            position = 6)
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
     * Getter of quote.
     *
     * @return quote
     */
    public final String getQuote() {
        return quote;
    }

    /**
     * Setter of quote.
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
     * Setter of base.
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
     * Setter of locale.
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
     * Setter of desc.
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
     * Setter of signature.
     *
     * @param newSignature the signature to set
     */
    public final void setSignature(final String newSignature) {
        signature = newSignature;
    }

}

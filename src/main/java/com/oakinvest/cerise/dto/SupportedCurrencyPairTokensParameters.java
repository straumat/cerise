package com.oakinvest.cerise.dto;

import java.util.List;

/**
 * Supported currency-pair tokens parameters.
 */
public class SupportedCurrencyPairTokensParameters {

    /**
     * Always "list" for this request.
     */
    private Mode mode = Mode.list;

    /**
     * If provided, the server MAY limit the results to only currency-pairs describing a currency with the given currency code(s).
     */
    private List<String> quote;

    /**
     * If provided, the server MAY limit the results to only currency-pairs describing currency rates compared to the given currency code(s).
     */
    private List<String> base;

    /**
     * If provided, the server MAY limit the results to only currency-pairs supporting the given Unicode CLDR locale(s).
     */
    private List<String> locales;

    /**
     * Constructor.
     *
     * @param newQuote   If provided, the server MAY limit the results to only currency-pairs describing a currency with the given currency code(s).
     * @param newBase    If provided, the server MAY limit the results to only currency-pairs describing currency rates compared to the given currency code(s).
     * @param newLocales If provided, the server MAY limit the results to only currency-pairs supporting the given Unicode CLDR locale(s).
     */
    public SupportedCurrencyPairTokensParameters(final List<String> newQuote, final List<String> newBase, final List<String> newLocales) {
        quote = newQuote;
        base = newBase;
        locales = newLocales;
    }

    /**
     * Returns mode.
     *
     * @return mode
     */
    public final Mode getMode() {
        return mode;
    }

    /**
     * Returns quote.
     *
     * @return quote
     */
    public final List<String> getQuote() {
        return quote;
    }

    /**
     * Returns base.
     *
     * @return base
     */
    public final List<String> getBase() {
        return base;
    }

    /**
     * Returns locales.
     *
     * @return locales
     */
    public final List<String> getLocales() {
        return locales;
    }

}

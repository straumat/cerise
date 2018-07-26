package com.oakinvest.cerise.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Currency-pair information result.
 *
 * @author straumat
 */
@SuppressWarnings("magicnumber")
@JsonInclude(NON_NULL)
public class CurrencyPairInformationResult {

    /**
     * The currency-pair token. Currency-pair tokens are arbitrary Strings no longer than 255 characters, which may include any ASCII RFC 3986 unreserved characters (ie, alphanumerics and the hyphen, underscore, period, and tilde symbols).
     */
    @ApiModelProperty(notes = "The currency-pair token. Currency-pair tokens are arbitrary Strings no longer than 255 characters, which may include any ASCII RFC 3986 unreserved characters (ie, alphanumerics and the hyphen, underscore, period, and tilde symbols)",
            example = "XBTUSD-ver4",
            required = true,
            position = 1)
    private String cp;

    /**
     * The currency code for the quote currency.
     */
    @ApiModelProperty(notes = "The currency code for the quote currency",
            example = "USD",
            required = true,
            position = 2)
    private String quote;

    /**
     * The currency code for the base currency.
     */
    @ApiModelProperty(notes = "The currency code for the base currency",
            example = "XBT",
            required = true,
            position = 3)
    private String base;

    /**
     * If provided, a String with the applicable Unicode CLDR locale.
     */
    @ApiModelProperty(notes = "If provided, a String with the applicable Unicode CLDR locale",
            example = "en_US",
            required = true,
            position = 4)
    private String locale;

    /**
     * Optional description. For example, it could be "Based on Florida BTM prices." or any other short String that provides information useful to the user. SHOULD be shorter than 45 characters.
     */
    @ApiModelProperty(notes = "Optional description. For example, it could be \"Based on Florida BTM prices.\" or any other short String that provides information useful to the user",
            example = "Smoothed averages",
            position = 5)
    private String desc;

    /**
     * Optional description, but may be longer and include newlines.
     */
    @ApiModelProperty(notes = "Optional description, but may be longer and include newlines.",
            example = "\"USD price quotes as compared to Bitcoin value\\n\\nRecommended for casual usage",
            position = 6)
    @JsonProperty("longdesc")
    private String longDesc;

    /**
     * An Array of prefix and suffix for the quote currency. Each may be either a fixed String, an Array of two Strings (negative and positive), or null. Any positive or negative symbols must be included in this prefix/suffix; it MUST NOT be implied otherwise.
     */
    @ApiModelProperty(notes = "An Array of prefix and suffix for the quote currency. Each may be either a fixed String, an Array of two Strings (negative and positive), or null. Any positive or negative symbols must be included in this prefix/suffix; it MUST NOT be implied otherwise.",
            position = 7)
    private List<List<String>> symbol;

    /**
     * The type of digits to use for the quote currency's numbers. "arabic" should be used for common 0-9 digits.
     */
    @ApiModelProperty(notes = "The type of digits to use for the quote currency's numbers. \"arabic\" should be used for common 0-9 digits.",
            example = "arabic",
            position = 8)
    private String digits;

    /**
     * An Array alternating between Numbers representing a series of digits, and Strings used as delimiters. If terminated by a zero, the final grouping is to be repeated continually. For example, the common US locale thousands grouping would be [3, ",", 0]
     */
    @ApiModelProperty(notes = "An Array alternating between Numbers representing a series of digits, and Strings used as delimiters. If terminated by a zero, the final grouping is to be repeated continually. For example, the common US locale thousands grouping would be [3, \",\", 0]",
            position = 9)
    private List<String> grouping;

    /**
     * A String to be placed between whole numbers and a fractional amount.
     */
    @ApiModelProperty(notes = "A String to be placed between whole numbers and a fractional amount.",
            example = "?",
            position = 8)
    @JsonProperty("fraction_sep")
    private String fractionSeparator;

    /**
     * Array of absolute minimum (even for whole numbers) number of fractional digits, minimum fractional digits when a fraction exists, and maximum number of fractional digits when absolute precision is not demanded (below which is to be rounded in an implementation-dependent manner).
     */
    @ApiModelProperty(notes = "Array of absolute minimum (even for whole numbers) number of fractional digits, minimum fractional digits when a fraction exists, and maximum number of fractional digits when absolute precision is not demanded (below which is to be rounded in an implementation-dependent manner).",
            position = 10)
    @JsonProperty("fraction_digits")
    private List<Integer> fractionDigits;

    /**
     * A Number of seconds indicating a minimum time between polls to the server. Clients should be prudent about not polling too often, even if this number is low.
     */
    @ApiModelProperty(notes = "A Number of seconds indicating a minimum time between polls to the server. Clients should be prudent about not polling too often, even if this number is low.\n",
            example = "300",
            position = 11)
    @JsonProperty("minpoll")
    private int minPoll;

    /**
     * If provided and true, indicates longpolling is supported by the server.
     */
    @ApiModelProperty(notes = "If provided and true, indicates long polling is supported by the server.",
            example = "true",
            position = 12)
    @JsonProperty("longpoll")
    private boolean longPoll;

    /**
     * If provided, indicates the server has historical records going back no earlier than the POSIX timestamp provided as a value.
     */
    @ApiModelProperty(notes = "If provided, indicates the server has historical records going back no earlier than the POSIX timestamp provided as a value.",
            position = 13)
    private long history;

    /**
     * If provided, indicates the server no longer has current rates, and has no historical rates more recent than the POSIX timestamp provided as a value.
     */
    @ApiModelProperty(notes = "If provided, indicates the server no longer has current rates, and has no historical rates more recent than the POSIX timestamp provided as a value.",
            example = "133423244",
            position = 14)
    // TODO What is the type ?
    private long archive;

    /**
     * Optional. May be used for Linked Data Signatures.
     */
    @ApiModelProperty(notes = "May be used for Linked Data Signatures",
            position = 15)
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
     * Getter of longDesc.
     *
     * @return longDesc
     */
    public final String getLongDesc() {
        return longDesc;
    }

    /**
     * Setter of longDesc.
     *
     * @param newLongDesc the longDesc to set
     */
    public final void setLongDesc(final String newLongDesc) {
        longDesc = newLongDesc;
    }

    /**
     * Getter of symbol.
     *
     * @return symbol
     */
    public final List<List<String>> getSymbol() {
        return symbol;
    }

    /**
     * Setter of symbol.
     *
     * @param newSymbol the symbol to set
     */
    public final void setSymbol(final List<List<String>> newSymbol) {
        symbol = newSymbol;
    }

    /**
     * Getter of digits.
     *
     * @return digits
     */
    public final String getDigits() {
        return digits;
    }

    /**
     * Setter of digits.
     *
     * @param newDigits the digits to set
     */
    public final void setDigits(final String newDigits) {
        digits = newDigits;
    }

    /**
     * Getter of grouping.
     *
     * @return grouping
     */
    public final List<String> getGrouping() {
        return grouping;
    }

    /**
     * Setter of grouping.
     *
     * @param newGrouping the grouping to set
     */
    public final void setGrouping(final List<String> newGrouping) {
        grouping = newGrouping;
    }

    /**
     * Getter of fractionSeparator.
     *
     * @return fractionSeparator
     */
    public final String getFractionSeparator() {
        return fractionSeparator;
    }

    /**
     * Setter of fractionSeparator.
     *
     * @param newFractionSep the fractionSeparator to set
     */
    public final void setFractionSeparator(final String newFractionSep) {
        fractionSeparator = newFractionSep;
    }

    /**
     * Getter of fractionDigits.
     *
     * @return fractionDigits
     */
    public final List<Integer> getFractionDigits() {
        return fractionDigits;
    }

    /**
     * Setter of fractionDigits.
     *
     * @param newFractionDigits the fractionDigits to set
     */
    public final void setFractionDigits(final List<Integer> newFractionDigits) {
        fractionDigits = newFractionDigits;
    }

    /**
     * Getter of minPoll.
     *
     * @return minPoll
     */
    public final int getMinPoll() {
        return minPoll;
    }

    /**
     * Setter of minPoll.
     *
     * @param newMinPoll the minPoll to set
     */
    public final void setMinPoll(final int newMinPoll) {
        minPoll = newMinPoll;
    }

    /**
     * Getter of longPoll.
     *
     * @return longPoll
     */
    public final boolean isLongPoll() {
        return longPoll;
    }

    /**
     * Setter of longPoll.
     *
     * @param newLongPoll the longPoll to set
     */
    public final void setLongPoll(final boolean newLongPoll) {
        longPoll = newLongPoll;
    }

    /**
     * Getter of history.
     *
     * @return history
     */
    public final long getHistory() {
        return history;
    }

    /**
     * Setter of history.
     *
     * @param newHistory the history to set
     */
    public final void setHistory(final long newHistory) {
        history = newHistory;
    }

    /**
     * Getter of archive.
     *
     * @return archive
     */
    public final long getArchive() {
        return archive;
    }

    /**
     * Setter of archive.
     *
     * @param newArchive the archive to set
     */
    public final void setArchive(final long newArchive) {
        archive = newArchive;
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

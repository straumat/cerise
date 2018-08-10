package com.oakinvest.cerise.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * Grouping parameter.
 *
 * @author straumat
 */
public class Grouping {

    /**
     * First digits.
     */
    private final Integer firstDigits;

    /**
     * Delimiter.
     */
    private final String delimiter;

    /**
     * Last digits.
     */
    private final Integer lastDigits;

    /**
     * Constructor.
     *
     * @param newFirstDigits first digits.
     * @param newDelimiter   delimiter.
     * @param newLastDigits  last digits.
     */
    public Grouping(final int newFirstDigits, final String newDelimiter, final int newLastDigits) {
        this.firstDigits = newFirstDigits;
        this.delimiter = newDelimiter;
        this.lastDigits = newLastDigits;
    }

    /**
     * Getter of grouping.
     *
     * @return array of grouping.
     */
    public final List<Object> getValue() {
        List<Object> array = new LinkedList<>();
        array.add(firstDigits);
        array.add(delimiter);
        array.add(lastDigits);
        return array;
    }

}

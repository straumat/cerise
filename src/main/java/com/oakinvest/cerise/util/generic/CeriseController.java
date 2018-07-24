package com.oakinvest.cerise.util.generic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * CeriseController.
 */
public class CeriseController {

    /**
     * Returns a list of string from an array of string.
     *
     * @param array array of string.
     * @return empty list if array is null or a a list of string.
     */
    protected final List<String> getListFromArray(final String[] array) {
        if (array == null) {
            return new LinkedList<>();
        } else {
            return Arrays.asList(array);
        }
    }

    /**
     * Returns optional value of a value.
     *
     * @param value value
     * @return optional value
     */
    protected final String getCleanValue(final String value) {
        if (value == null || "".equals(value)) {
            return null;
        } else {
            return value.trim();
        }
    }

}

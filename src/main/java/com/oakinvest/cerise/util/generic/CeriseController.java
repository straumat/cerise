package com.oakinvest.cerise.util.generic;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * CeriseController.
 */
public class CeriseController {

    /**
     * List separator.
     */
    private static final String LIST_SEPARATOR = ",";

    /**
     * Returns a List of value from a string containing data separated by a comma.
     *
     * @param value list of values (example : "en_US,en_GB").
     * @return list of string.
     */
    protected final List<String> getList(final String value) {
        List<String> list = new LinkedList<>();
        if (value != null) {
            StringTokenizer tokenizer = new StringTokenizer(value, LIST_SEPARATOR);
            while (tokenizer.hasMoreTokens()) {
                list.add(tokenizer.nextToken().trim());
            }
        }
        return list;
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

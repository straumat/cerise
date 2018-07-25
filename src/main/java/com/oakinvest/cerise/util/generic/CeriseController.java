package com.oakinvest.cerise.util.generic;

import com.oakinvest.cerise.util.exception.ComplianceException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang.StringUtils.isEmpty;

/**
 * CeriseController.
 */
public class CeriseController {

    /**
     * Currency-pair tokens are arbitrary Strings no longer than 255 characters.
     */
    protected static final int CP_MAX_SIZE = 255;

    /**
     * Pass throw a list of CP and raise an exception if one is invalid.
     *
     * @param cpList list of cp.
     */
    protected final void validateCPList(final List<String> cpList) {
        List<String> errors = new LinkedList<>();
        cpList.stream()
                .filter(Objects::nonNull)
                .forEach(cp -> {
                    if (cp.length() > CP_MAX_SIZE) {
                        errors.add("Currency-pair too long : " + cp);
                    }
                });
        if (!errors.isEmpty()) {
            throw new ComplianceException("Currency-pair should be no longer than 255 characters", errors);
        }
    }

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
        if (isEmpty(value)) {
            return null;
        } else {
            return value.trim();
        }
    }

}

package com.oakinvest.cerise.util.generic;

import com.oakinvest.cerise.util.constants.CurrencyCode;
import com.oakinvest.cerise.util.exception.ComplianceException;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * CeriseController.
 */
public class CeriseController {

    /**
     * Currency code length.
     */
    private static final int CURRENCY_CODE_LENGTH = 3;

    /**
     * Currency-pair tokens are arbitrary Strings no longer than 255 characters.
     */
    private static final int CP_MAX_SIZE = 255;

    /**
     * Pass throw a list of currency code and raise an exception if one is invalid.
     *
     * @param currencyCodeList list of currency code.
     */
    protected final void validateCurrencyCodeList(final String[] currencyCodeList) {
        if (currencyCodeList != null) {
            validateCurrencyCodeList(Arrays.asList(currencyCodeList));
        }
    }

    /**
     * Pass throw a list of currency code and raise an exception if one is invalid.
     *
     * @param currencyCodeList list of currency code.
     */
    protected final void validateCurrencyCodeList(final List<String> currencyCodeList) {
        List<String> errors = new LinkedList<>();
        currencyCodeList.stream()
                .filter(Objects::nonNull)
                .filter(c -> c.length() == CURRENCY_CODE_LENGTH)
                .filter(c -> !EnumUtils.isValidEnum(CurrencyCode.class, c))
                .forEach(c -> errors.add("Invalid currency code : " + c));
        if (!errors.isEmpty()) {
            throw new ComplianceException("Invalid currency codes", errors);
        }
    }

    /**
     * Pass throw a list of CP and raise an exception if one is invalid.
     *
     * @param cpList list of cp.
     */
    protected final void validateCPList(final String[] cpList) {
        if (cpList != null) {
            validateCPList(Arrays.asList(cpList));
        }
    }

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

}

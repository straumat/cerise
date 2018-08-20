package com.oakinvest.cerise.util.generic;

import com.oakinvest.cerise.util.constants.CurrencyCode;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.LocaleUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static com.oakinvest.cerise.util.generic.CeriseErrorCode.currency_code_invalid;
import static com.oakinvest.cerise.util.generic.CeriseErrorCode.currency_pair_too_large;
import static com.oakinvest.cerise.util.generic.CeriseErrorCode.locale_invalid;

/**
 * Cerise controller.
 *
 * @author straumat
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
     * Returns all errors found on the CP Field.
     *
     * @param values cp list
     * @return errors.
     */
    protected final List<CeriseErrorDetail> getErrorsForCurrencyValues(final String[] values) {
        final List<CeriseErrorDetail> errors = new LinkedList<>();
        if (values != null) {
            Arrays.stream(values)
                    .filter(Objects::nonNull)
                    .forEach(cp -> {
                        // Invalid CP Size.
                        if (cp.length() > CP_MAX_SIZE) {
                            errors.add(new CeriseErrorDetail(currency_pair_too_large, "Currency-pair parameter is too long : " + cp));
                        }
                        // Invalid currency code.
                        if (cp.length() == CURRENCY_CODE_LENGTH && !EnumUtils.isValidEnum(CurrencyCode.class, cp)) {
                            errors.add(new CeriseErrorDetail(currency_code_invalid, "Invalid currency code : " + cp));
                        }
                    });
        }
        return errors;
    }

    /**
     * Returns all errors on the locale field.
     *
     * @param values locales
     * @return errors
     */
    protected final List<CeriseErrorDetail> getErrorsForLocaleValues(final String[] values) {
        final List<CeriseErrorDetail> errors = new LinkedList<>();
        if (values != null) {
            Arrays.stream(values)
                    .filter(Objects::nonNull)
                    .forEach(l -> {
                                try {
                                    LocaleUtils.toLocale(l);
                                } catch (IllegalArgumentException e) {
                                    errors.add(new CeriseErrorDetail(locale_invalid, "Invalid locale : " + l));
                                }
                            }
                    );
        }
        return errors;
    }

    /**
     * Returns a list of string from an array of string.
     *
     * @param array array of string
     * @return empty list if array is null or a a list of string
     */
    protected final List<String> getListFromArray(final String[] array) {
        if (array == null) {
            return new LinkedList<>();
        } else {
            return Arrays.asList(array);
        }
    }

}

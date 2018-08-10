package com.oakinvest.cerise.util.exception;

import com.oakinvest.cerise.util.generic.CeriseException;

import java.util.List;

/**
 * Exception raised when there is an invalid locale.
 *
 * @author straumat
 */
public class InvalidLocaleException extends CeriseException {

    /**
     * Error message.
     */
    private static final String ERROR_MESSAGE = "Invalid locales";

    /**
     * Constructor with a simple error message.
     */
    public InvalidLocaleException() {
        super(ERROR_MESSAGE);
    }

    /**
     * Constructor with a message error and list of errors.
     *
     * @param newErrors list of errors
     */
    public InvalidLocaleException(final List<String> newErrors) {
        super(ERROR_MESSAGE, newErrors);
    }

}

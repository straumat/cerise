package com.oakinvest.cerise.util.exception;

import com.oakinvest.cerise.util.generic.CeriseException;

import java.util.List;

/**
 * Exception raised when there is an invalid currency code.
 *
 * @author straumat
 */
public class InvalidCurrencyCodeException extends CeriseException {

    /**
     * Error message.
     */
    private static final String ERROR_MESSAGE = "Invalid currency codes";

    /**
     * Constructor with a simple error message.
     */
    public InvalidCurrencyCodeException() {
        super(ERROR_MESSAGE);
    }

    /**
     * Constructor with a message error and list of errors.
     *
     * @param newErrors list of errors
     */
    public InvalidCurrencyCodeException(final List<String> newErrors) {
        super(ERROR_MESSAGE, newErrors);
    }

}

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
     * Constructor with a simple error message.
     *
     * @param message message
     */
    public InvalidCurrencyCodeException(final String message) {
        super(message);
    }

    /**
     * Constructor with a message error and list of errors.
     *
     * @param message   message
     * @param newErrors list of errors
     */
    public InvalidCurrencyCodeException(final String message, final List<String> newErrors) {
        super(message, newErrors);
    }

}

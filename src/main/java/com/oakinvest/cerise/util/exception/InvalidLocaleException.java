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
     * Constructor with a simple error message.
     *
     * @param message message.
     */
    public InvalidLocaleException(final String message) {
        super(message);
    }

    /**
     * Constructor with a message error and list of errors.
     *
     * @param message   message
     * @param newErrors list of errors
     */
    public InvalidLocaleException(final String message, final List<String> newErrors) {
        super(message, newErrors);
    }

}

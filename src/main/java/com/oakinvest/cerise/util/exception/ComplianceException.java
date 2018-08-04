package com.oakinvest.cerise.util.exception;

import com.oakinvest.cerise.util.generic.CeriseException;

import java.util.List;

/**
 * Exception raised when there is a compliance failure.
 *
 * @author straumat
 */
public class ComplianceException extends CeriseException {

    /**
     * Constructor with a simple error message.
     *
     * @param message message
     */
    public ComplianceException(final String message) {
        super(message);
    }

    /**
     * Constructor with a message error and list of errors.
     *
     * @param message   message
     * @param newErrors list of errors
     */
    public ComplianceException(final String message, final List<String> newErrors) {
        super(message, newErrors);
    }

}

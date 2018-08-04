package com.oakinvest.cerise.util.generic;

import java.util.LinkedList;
import java.util.List;

/**
 * Cerise exception.
 *
 * @author straumat
 */
public class CeriseException extends RuntimeException {

    /**
     * List of constructed error messages.
     */
    private List<String> errors = new LinkedList<>();

    /**
     * Constructor with a simple error message.
     *
     * @param message message
     */
    public CeriseException(final String message) {
        super(message);
        errors.add(message);
    }

    /**
     * Constructor with a message error and list of errors.
     *
     * @param message   message
     * @param newErrors list of errors
     */
    public CeriseException(final String message, final List<String> newErrors) {
        super(message);
        this.errors = newErrors;
    }

    /**
     * Getter of errors.
     *
     * @return errors
     */
    public final List<String> getErrors() {
        return errors;
    }

}

package com.oakinvest.cerise.util.generic;

import java.util.Collections;
import java.util.List;

/**
 * API Error.
 *
 * @author straumat
 */
public class CeriseError {

    /**
     * The error message associated with exception.
     */
    private final String message;

    /**
     * List of constructed error messages.
     */
    private final List<String> errors;

    /**
     * Constructor (single error).
     *
     * @param newMessage The error message associated with exception
     * @param newError   error messages
     */
    public CeriseError(final String newMessage, final String newError) {
        super();
        this.message = newMessage;
        errors = Collections.singletonList(newError);
    }

    /**
     * Constructor (several errors).
     *
     * @param newMessage The error message associated with exception
     * @param newErrors  List of constructed error messages
     */
    public CeriseError(final String newMessage, final List<String> newErrors) {
        super();
        this.message = newMessage;
        this.errors = newErrors;
    }

    /**
     * Getter of message.
     *
     * @return message
     */
    public final String getMessage() {
        return message;
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

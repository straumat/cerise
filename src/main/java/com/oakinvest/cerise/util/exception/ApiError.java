package com.oakinvest.cerise.util.exception;

import java.util.Collections;
import java.util.List;

/**
 * API Error.
 */
public class ApiError {

    /**
     * The error message associated with exception.
     */
    private String message;

    /**
     * List of constructed error messages.
     */
    private List<String> errors;

    /**
     * Constructor (single error).
     *
     * @param newMessage The error message associated with exception.
     * @param newError   error messages.
     */
    public ApiError(final String newMessage, final String newError) {
        super();
        this.message = newMessage;
        errors = Collections.singletonList(newError);
    }

    /**
     * Constructor (several errors).
     *
     * @param newMessage The error message associated with exception.
     * @param newErrors  List of constructed error messages.
     */
    public ApiError(final String newMessage, final List<String> newErrors) {
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

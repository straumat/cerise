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
     * The error type.
     */
    private final CeriseErrorType type;

    /**
     * List of errors with their code.
     */
    private final List<CeriseErrorDetail> errors = new LinkedList<>();

    /**
     * Constructor with a simple error message.
     *
     * @param newType error type
     * @param message message
     */
    public CeriseException(final CeriseErrorType newType, final String message) {
        super(message);
        this.type = newType;
    }

    /**
     * Constructor with a message error and list of errors.
     *
     * @param newType   error type
     * @param message   message
     * @param newErrors list of errors
     */
    public CeriseException(final CeriseErrorType newType, final String message, final List<CeriseErrorDetail> newErrors) {
        super(message);
        this.type = newType;
        this.errors.addAll(newErrors);
    }

    /**
     * Getter of type.
     *
     * @return type
     */
    public final CeriseErrorType getType() {
        return type;
    }

    /**
     * Getter of errors.
     *
     * @return errors
     */
    public final List<CeriseErrorDetail> getErrors() {
        return errors;
    }

    @Override
    public final String toString() {
        StringBuilder value = new StringBuilder("CeriseException{type=" + type + ", message=" + getMessage() + "}, errors {");
        for (CeriseErrorDetail error : getErrors()) {
            value.append("{code=")
                    .append(error.getCode())
                    .append(", message=")
                    .append(error.getMessage())
                    .append("}, ");
        }
        if (value.toString().endsWith(", ")) {
            value = new StringBuilder(value.substring(0, value.toString().length() - 2));
        }
        value.append("}");
        return value.toString();
    }
}

package com.oakinvest.cerise.util.generic;

import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedList;
import java.util.List;

/**
 * Cerise Error.
 *
 * @author straumat
 */
@SuppressWarnings({"magicnumber", "unused"})
public class CeriseError {

    /**
     * The error type.
     */
    @ApiModelProperty(value = "The type of error returned. One of api_connection_error, api_error, authentication_error, invalid_request_error or rate_limit_error.",
            example = "invalid_request_error",
            required = true,
            position = 1)
    private final CeriseErrorType type;

    /**
     * A human-readable message providing more details about the error.
     */
    @ApiModelProperty(value = "A human-readable message providing more details about the error.",
            example = "Invalid request to currency-pair information",
            required = true,
            position = 2)
    private final String message;

    /**
     * List of errors with their code.
     */
    @ApiModelProperty(value = "List of errors.",
            position = 3)
    private final List<CeriseErrorDetail> errors = new LinkedList<>();

    /**
     * Constructor (single error).
     *
     * @param newType    error type
     * @param newMessage The error message associated with exception
     */
    public CeriseError(final CeriseErrorType newType, final String newMessage) {
        super();
        this.type = newType;
        this.message = newMessage;
    }

    /**
     * Constructor (several errors).
     *
     * @param newType    error type
     * @param newMessage Error message
     * @param newErrors  List of errors
     */
    public CeriseError(final CeriseErrorType newType, final String newMessage, final List<CeriseErrorDetail> newErrors) {
        super();
        this.type = newType;
        this.message = newMessage;
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
    public final List<CeriseErrorDetail> getErrors() {
        return errors;
    }

}

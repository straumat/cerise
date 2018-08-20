package com.oakinvest.cerise.util.generic;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * Cerise error detail.
 *
 * @author straumat
 */
@SuppressWarnings("magicnumber")
@JsonInclude(NON_NULL)
public class CeriseErrorDetail {

    /**
     * Error code.
     */
    @ApiModelProperty(value = "Error code.",
            example = "currency_code_invalid",
            required = true,
            position = 1)
    private CeriseErrorCode code;

    /**
     * Error message.
     */
    @ApiModelProperty(value = "A human-readable message providing more details about the error.",
            example = "Invalid currency code : AAA",
            required = true,
            position = 2)
    private String message;

    /**
     * Constructor.
     *
     * @param newErrorCode    error code
     * @param newMessage error message
     */
    public CeriseErrorDetail(final CeriseErrorCode newErrorCode, final String newMessage) {
        this.code = newErrorCode;
        this.message = newMessage;
    }

    /**
     * Getter of code.
     *
     * @return code
     */
    public final CeriseErrorCode getCode() {
        return code;
    }

    /**
     * Setter of code.
     *
     * @param newCode the code to set
     */
    public final void setCode(final CeriseErrorCode newCode) {
        code = newCode;
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
     * Setter of message.
     *
     * @param newErrorMessage the message to set
     */
    public final void setMessage(final String newErrorMessage) {
        message = newErrorMessage;
    }

}

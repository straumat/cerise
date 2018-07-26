package com.oakinvest.cerise.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handling controller.
 */
@ControllerAdvice
public class ExceptionHandlingController {

    /**
     * Deal with invalid currency exception.
     *
     * @param ex exception.
     * @return rest error.
     */
    @ExceptionHandler(InvalidCurrencyCodeException.class)
    public final ResponseEntity<ApiError> complianceException(final InvalidCurrencyCodeException ex) {
        ApiError response = new ApiError(ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Deal with locale exception.
     *
     * @param ex exception.
     * @return rest error.
     */
    @ExceptionHandler(InvalidLocaleException.class)
    public final ResponseEntity<ApiError> complianceException(final InvalidLocaleException ex) {
        ApiError response = new ApiError(ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Deal with compliance exception.
     *
     * @param ex exception.
     * @return rest error.
     */
    @ExceptionHandler(ComplianceException.class)
    public final ResponseEntity<ApiError> complianceException(final ComplianceException ex) {
        ApiError response = new ApiError(ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

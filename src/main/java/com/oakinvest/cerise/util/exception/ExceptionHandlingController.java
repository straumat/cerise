package com.oakinvest.cerise.util.exception;

import com.oakinvest.cerise.util.generic.CeriseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handling controller.
 *
 * @author straumat
 */
@ControllerAdvice
public class ExceptionHandlingController {

    /**
     * Deal with invalid currency exception.
     *
     * @param ex exception
     * @return rest error
     */
    @ExceptionHandler(InvalidCurrencyCodeException.class)
    public final ResponseEntity<CeriseError> complianceException(final InvalidCurrencyCodeException ex) {
        CeriseError response = new CeriseError(ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Deal with locale exception.
     *
     * @param ex exception
     * @return rest error
     */
    @ExceptionHandler(InvalidLocaleException.class)
    public final ResponseEntity<CeriseError> complianceException(final InvalidLocaleException ex) {
        CeriseError response = new CeriseError(ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Deal with compliance exception.
     *
     * @param ex exception
     * @return rest error
     */
    @ExceptionHandler(ComplianceException.class)
    public final ResponseEntity<CeriseError> complianceException(final ComplianceException ex) {
        CeriseError response = new CeriseError(ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

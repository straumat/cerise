package com.oakinvest.cerise.configuration;

import com.oakinvest.cerise.util.generic.CeriseError;
import com.oakinvest.cerise.util.generic.CeriseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ExceptionHandlingConfiguration {

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(ExceptionHandlingConfiguration.class);

    /**
     * Deal with cerise exception.
     *
     * @param ex exception
     * @return rest error
     */
    @ExceptionHandler(CeriseException.class)
    public final ResponseEntity<CeriseError> ceriseException(final CeriseException ex) {
        // Logging.
        log.error("Cerise error : " + ex);

        // Creating response.
        CeriseError response = new CeriseError(ex.getType(), ex.getMessage(), ex.getErrors());

        // Choosing http status.
        HttpStatus status;
        switch (ex.getType()) {
            case api_connection_error:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            case api_error:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            case authentication_error:
                status = HttpStatus.UNAUTHORIZED;
                break;
            case invalid_request_error:
                status = HttpStatus.BAD_REQUEST;
                break;
            case rate_limit_error:
                status = HttpStatus.TOO_MANY_REQUESTS;
                break;
            case unspecified_error:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            case unknown_error:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }

        // returning error.
        return new ResponseEntity<>(response, status);
    }

}

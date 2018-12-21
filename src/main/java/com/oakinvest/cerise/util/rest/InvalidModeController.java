package com.oakinvest.cerise.util.rest;

import com.oakinvest.cerise.util.generic.CeriseErrorDetail;
import com.oakinvest.cerise.util.generic.CeriseException;
import org.springframework.web.bind.annotation.RestController;

import static com.oakinvest.cerise.util.generic.CeriseErrorCode.mode_invalid;
import static com.oakinvest.cerise.util.generic.CeriseErrorCode.mode_required;
import static com.oakinvest.cerise.util.generic.CeriseErrorType.invalid_request_error;

/**
 * Invalid mode.
 *
 * @author straumat
 */
@RestController
public class InvalidModeController implements InvalidModeAPI {

    /**
     * Invalid mode.
     *
     * @param mode mode
     */
    @Override
    public final void invalidMode(final String mode) {
        if (mode == null) {
            final CeriseErrorDetail e = new CeriseErrorDetail(mode_required, "Mode not set (list, info, rate & history)");
            throw new CeriseException(invalid_request_error, "Mode not set (list, info, rate & history)", e);
        } else {
            final CeriseErrorDetail e = new CeriseErrorDetail(mode_invalid, "Incorrect mode value : '" + mode + "'");
            throw new CeriseException(invalid_request_error, "Incorrect mode value : '" + mode + "'", e);
        }
    }

}

package com.oakinvest.cerise.web.rest;

import com.oakinvest.cerise.util.generic.CeriseErrorDetail;
import com.oakinvest.cerise.util.generic.CeriseException;
import org.springframework.web.bind.annotation.RestController;

import static com.oakinvest.cerise.util.generic.CeriseErrorCode.mode_missing;
import static com.oakinvest.cerise.util.generic.CeriseErrorType.invalid_request_error;

/**
 * No mode set.
 *
 * @author straumat
 */
@RestController
public class NoModeSetController implements InvalidModeAPI {

    /**
     * No mode set.
     */
    @Override
    public final void getCurrencyPairInformation() {
        final CeriseErrorDetail e = new CeriseErrorDetail(mode_missing, "Mode not set (list, info, rate & history)");
        throw new CeriseException(invalid_request_error, "Mode not set (list, info, rate & history)", e);
    }

}

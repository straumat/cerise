package com.oakinvest.cerise.util.generic;

import com.oakinvest.cerise.dto.Mode;

/**
 * Cerise parameter.
 *
 * @author straumat
 */
public abstract class CeriseParameters {

    /**
     * Always "info" for this request.
     */
    private Mode mode;

    /**
     * Getter of mode.
     *
     * @return mode
     */
    public final Mode getMode() {
        return mode;
    }

    /**
     * Setter of mode.
     *
     * @param newMode the mode to set
     */
    protected final void setMode(final Mode newMode) {
        mode = newMode;
    }

}

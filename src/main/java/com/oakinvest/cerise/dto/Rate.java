package com.oakinvest.cerise.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Rate.
 *
 * @author straumat
 */
public class Rate {

    /**
     * Type of exchange rate data.
     */
    @ApiModelProperty(notes = "Type of exchange rate data", example = "typical", required = true, position = 1)
    private String type;

    /**
     * Rate value.
     */
    @ApiModelProperty(notes = "Rate value", example = "1349.332215", required = true, position = 2)
    private double value;

    /**
     * Getter of type.
     *
     * @return type
     */
    public final String getType() {
        return type;
    }

    /**
     * Setterde of type.
     *
     * @param newType the type to set
     */
    public final void setType(final String newType) {
        type = newType;
    }

    /**
     * Getter of value.
     *
     * @return value
     */
    public final double getValue() {
        return value;
    }

    /**
     * Setterde of value.
     *
     * @param newValue the value to set
     */
    public final void setValue(final double newValue) {
        value = newValue;
    }

}

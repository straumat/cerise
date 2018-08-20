package com.oakinvest.cerise.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Rate.
 *
 * @author straumat
 */
@SuppressWarnings({"magicnumber", "unused"})
class Rate {

    /**
     * Type of exchange rate data.
     */
    @ApiModelProperty(value = "Type of exchange rate data",
            example = "typical",
            required = true,
            position = 1)
    private String type;

    /**
     * Rate value.
     */
    @ApiModelProperty(value = "Rate value",
            example = "1349.332215",
            required = true,
            position = 2)
    private Double value;

    /**
     * Getter of type.
     *
     * @return type
     */
    public final String getType() {
        return type;
    }

    /**
     * Setter of type.
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
    public final Double getValue() {
        return value;
    }

    /**
     * Setter of value.
     *
     * @param newValue the value to set
     */
    public final void setValue(final Double newValue) {
        value = newValue;
    }

}

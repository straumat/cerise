package com.oakinvest.cerise.dto;

import com.oakinvest.cerise.util.generic.CeriseParameters;

import java.util.List;

/**
 * Historical exchange rates parameters.
 *
 * @author straumat
 */
public class HistoricalExchangeRatesParameters extends CeriseParameters {

    /**
     * Currency pair(s) for which information is requested.
     */
    private final List<String> cp;

    /**
     * Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     */
    private final List<String> types;

    /**
     * POSIX timestamp the results should begin with.
     */
    private final Double from;

    /**
     * POSIX timestamp the results should end with. If omitted, the present time shall be used.
     */
    private final Double to;

    /**
     * If provided and true, indicates that only the nearest timestamp to "from" must be returned, and a range is not desired. ("to" should be omitted in this case.)
     */
    private final Boolean nearest;

    /**
     * If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.
     */
    private final Float rateDelta;

    /**
     * If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.
     */
    private final Float timeDelta;

    /**
     * Constructor.
     *
     * @param newCp        Currency pair(s) for which rate is requested.
     * @param newTypes     Type of exchange rate data being requested. May be "high", "low", "average", "typical", or any other arbitrary name. If omitted, the server may provide any rates it deems appropriate.
     * @param newFrom      POSIX timestamp the results should begin with.
     * @param newTo        POSIX timestamp the results should end with. If omitted, the present time shall be used.
     * @param newNearest   If provided and true, indicates that only the nearest timestamp to "from" must be returned, and a range is not desired. ("to" should be omitted in this case.)
     * @param newRateDelta If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.
     * @param newTimeDelta If specified, the server may omit data where the rate or time has not changed since the last provided rate and time. If both are provided, either a significant rate change OR time change should trigger a new record in the results.
     */
    public HistoricalExchangeRatesParameters(final List<String> newCp, final List<String> newTypes, final Double newFrom, final Double newTo, final Boolean newNearest, final Float newRateDelta, final Float newTimeDelta) {
        setMode(Mode.history);
        this.cp = newCp;
        this.types = newTypes;
        this.from = newFrom;
        this.to = newTo;
        this.nearest = newNearest;
        this.rateDelta = newRateDelta;
        this.timeDelta = newTimeDelta;
    }

    /**
     * Getter of cp.
     *
     * @return cp
     */
    public final List<String> getCp() {
        return cp;
    }

    /**
     * Getter of types.
     *
     * @return types
     */
    public final List<String> getTypes() {
        return types;
    }

    /**
     * Getter of from.
     *
     * @return from
     */
    public final Double getFrom() {
        return from;
    }

    /**
     * Getter of to.
     *
     * @return to
     */
    public final Double getTo() {
        return to;
    }

    /**
     * Getter of nearest.
     *
     * @return nearest
     */
    public final Boolean isNearest() {
        return nearest;
    }

    /**
     * Getter of rateDelta.
     *
     * @return rateDelta
     */
    public final Float getRateDelta() {
        return rateDelta;
    }

    /**
     * Getter of timeDelta.
     *
     * @return timeDelta
     */
    public final Float getTimeDelta() {
        return timeDelta;
    }

}

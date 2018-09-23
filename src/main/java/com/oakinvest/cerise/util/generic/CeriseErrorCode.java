package com.oakinvest.cerise.util.generic;

/**
 * Cerise error codes.
 * For every field : required, invalid, too_large, too_small, expired, unverified, unsupported.
 *
 * @author straumat
 */
@SuppressWarnings("unused")
public enum CeriseErrorCode {

    /**
     * mode not set.
     */
    mode_required,

    /**
     * mode invalid.
     */
    mode_invalid,

    /**
     * mode too small.
     */
    mode_too_small,

    /**
     * mode too large.
     */
    mode_too_large,

    /**
     * mode expired.
     */
    mode_expired,

    /**
     * mode unverified.
     */
    mode_unverified,

    /**
     * mode unsupported.
     */
    mode_unsupported,

    /**
     * currency_pair required.
     */
    currency_pair_required,

    /**
     * currency_pair invalid.
     */
    currency_pair_invalid,

    /**
     * currency_pair too_small.
     */
    currency_pair_too_small,

    /**
     * currency_pair too_large.
     */
    currency_pair_too_large,

    /**
     * currency_pair expired.
     */
    currency_pair_expired,

    /**
     * currency_pair unverified.
     */
    currency_pair_unverified,

    /**
     * currency_pair unsupported.
     */
    currency_pair_unsupported,

    /**
     * currency_code required.
     */
    currency_code_required,

    /**
     * currency_code invalid.
     */
    currency_code_invalid,

    /**
     * currency_code too_small.
     */
    currency_code_too_small,

    /**
     * currency_code too_large.
     */
    currency_code_too_large,

    /**
     * currency_code expired.
     */
    currency_code_expired,

    /**
     * currency_code unverified.
     */
    currency_code_unverified,

    /**
     * currency_code unsupported.
     */
    currency_code_unsupported,

    /**
     * type required.
     */
    type_required,

    /**
     * type invalid.
     */
    type_invalid,

    /**
     * type too_small.
     */
    type_too_small,

    /**
     * type too_large.
     */
    type_too_large,

    /**
     * type expired.
     */
    type_expired,

    /**
     * type unverified.
     */
    type_unverified,

    /**
     * type unsupported.
     */
    type_unsupported,

    /**
     * minrate required.
     */
    minrate_required,

    /**
     * minrate invalid.
     */
    minrate_invalid,

    /**
     * minrate too_small.
     */
    minrate_too_small,

    /**
     * minrate too_large.
     */
    minrate_too_large,

    /**
     * minrate expired.
     */
    minrate_expired,

    /**
     * minrate unverified.
     */
    minrate_unverified,

    /**
     * minrate unsupported.
     */
    minrate_unsupported,

    /**
     * maxrate required.
     */
    maxrate_required,

    /**
     * maxrate invalid.
     */
    maxrate_invalid,

    /**
     * maxrate too_small.
     */
    maxrate_too_small,

    /**
     * maxrate too_large.
     */
    maxrate_too_large,

    /**
     * maxrate expired.
     */
    maxrate_expired,

    /**
     * maxrate unverified.
     */
    maxrate_unverified,

    /**
     * maxrate unsupported.
     */
    maxrate_unsupported,

    /**
     * nonce required.
     */
    nonce_required,

    /**
     * nonce invalid.
     */
    nonce_invalid,

    /**
     * nonce too_small.
     */
    nonce_too_small,

    /**
     * nonce too_large.
     */
    nonce_too_large,

    /**
     * nonce expired.
     */
    nonce_expired,

    /**
     * nonce unverified.
     */
    nonce_unverified,

    /**
     * nonce unsupported.
     */
    nonce_unsupported,

    /**
     * from required.
     */
    from_required,

    /**
     * from invalid.
     */
    from_invalid,

    /**
     * from too_small.
     */
    from_too_small,

    /**
     * from too_large.
     */
    from_too_large,

    /**
     * from expired.
     */
    from_expired,

    /**
     * from unverified.
     */
    from_unverified,

    /**
     * from unsupported.
     */
    from_unsupported,

    /**
     * to required.
     */
    to_required,

    /**
     * to invalid.
     */
    to_invalid,

    /**
     * to too_small.
     */
    to_too_small,

    /**
     * to too_large.
     */
    to_too_large,

    /**
     * to expired.
     */
    to_expired,

    /**
     * to unverified.
     */
    to_unverified,

    /**
     * to unsupported.
     */
    to_unsupported,

    /**
     * nearest required.
     */
    nearest_required,

    /**
     * nearest invalid.
     */
    nearest_invalid,

    /**
     * nearest too_small.
     */
    nearest_too_small,

    /**
     * nearest too_large.
     */
    nearest_too_large,

    /**
     * nearest expired.
     */
    nearest_expired,

    /**
     * nearest unverified.
     */
    nearest_unverified,

    /**
     * nearest unsupported.
     */
    nearest_unsupported,

    /**
     * ratedelta required.
     */
    ratedelta_required,

    /**
     * ratedelta invalid.
     */
    ratedelta_invalid,

    /**
     * ratedelta too_small.
     */
    ratedelta_too_small,

    /**
     * ratedelta too_large.
     */
    ratedelta_too_large,

    /**
     * ratedelta expired.
     */
    ratedelta_expired,

    /**
     * ratedelta unverified.
     */
    ratedelta_unverified,

    /**
     * ratedelta unsupported.
     */
    ratedelta_unsupported,

    /**
     * timedelta required.
     */
    timedelta_required,

    /**
     * timedelta invalid.
     */
    timedelta_invalid,

    /**
     * timedelta too_small.
     */
    timedelta_too_small,

    /**
     * timedelta too_large.
     */
    timedelta_too_large,

    /**
     * timedelta expired.
     */
    timedelta_expired,

    /**
     * timedelta unverified.
     */
    timedelta_unverified,

    /**
     * timedelta unsupported.
     */
    timedelta_unsupported,

    /**
     * locale required.
     */
    locale_required,

    /**
     * locale invalid.
     */
    locale_invalid,

    /**
     * locale too_small.
     */
    locale_too_small,

    /**
     * locale too_large.
     */
    locale_too_large,

    /**
     * locale expired.
     */
    locale_expired,

    /**
     * locale unverified.
     */
    locale_unverified,

    /**
     * locale unsupported.
     */
    locale_unsupported,

    /**
     * Unspecified error.
     */
    unspecified_error,

    /**
     * Unknown error.
     */
    unknown_error

}

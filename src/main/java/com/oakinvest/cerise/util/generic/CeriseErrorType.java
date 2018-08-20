package com.oakinvest.cerise.util.generic;

/**
 * Cerise error types.
 *
 * @author straumat
 */
@SuppressWarnings("unused")
public enum CeriseErrorType {

    /**
     * Failure to connect to API.
     */
    api_connection_error,

    /**
     * API errors cover any other type of problem (e.g., a temporary problem with servers) and are uncommon.
     */
    api_error,

    /**
     * Failure to properly authenticate yourself in the request.
     */
    authentication_error,

    /**
     * Invalid request errors arise when your request has invalid parameters.
     */
    invalid_request_error,

    /**
     * Too many requests hit the API too quickly.
     */
    rate_limit_error,

    /**
     * Unspecified error.
     */
    unspecified_error,

    /**
     * Unknown error.
     */
    unknown_error

}

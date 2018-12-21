package com.oakinvest.cerise.web.rest;

/**
 * Cerise Http Status for swagger.
 *
 * @author straumat
 */
public final class CeriseHttpStatus {

    /**
     * Constructor.
     */
    private CeriseHttpStatus() {
    }

    /**
     * Everything worked as expected.
     */
    static final int STATUS_OK = 200;

    /**
     * The request was unacceptable, often due to missing a required parameter.
     */
    public static final int STATUS_BAD_REQUEST = 400;

    /**
     * No valid authorization was provided.
     */
    static final int STATUS_UNAUTHORIZED = 401;

    /**
     * The parameters were valid but the request failed.
     */
    static final int STATUS_REQUEST_FAILED = 402;

    /**
     * The requested resource doesn't exist.
     */
    static final int STATUS_NOT_FOUND = 404;

    /**
     * Something went wrong on the server.
     */
    static final int STATUS_INTERNAL_SERVER_ERROR = 500;

}

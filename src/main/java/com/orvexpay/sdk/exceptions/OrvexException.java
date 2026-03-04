package com.orvexpay.sdk.exceptions;

public class OrvexException extends Exception {
    private final int statusCode;
    private final String responseBody;

    public OrvexException(String message, int statusCode, String responseBody) {
        super(message);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}

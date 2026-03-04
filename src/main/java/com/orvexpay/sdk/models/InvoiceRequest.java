package com.orvexpay.sdk.models;

import java.util.Map;

public class InvoiceRequest {
    private String priceAmount;
    private String priceCurrency;
    private String payCurrency;
    private String orderId;
    private String successUrl;
    private String cancelUrl;
    private String callbackUrl;
    private Map<String, String> metadata;

    // Fluent Builder pattern
    public InvoiceRequest setPriceAmount(String priceAmount) {
        this.priceAmount = priceAmount;
        return this;
    }

    public InvoiceRequest setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
        return this;
    }

    public InvoiceRequest setPayCurrency(String payCurrency) {
        this.payCurrency = payCurrency;
        return this;
    }

    public InvoiceRequest setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public InvoiceRequest setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
        return this;
    }

    public InvoiceRequest setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
        return this;
    }

    public InvoiceRequest setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }

    public InvoiceRequest setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }
}

package com.orvexpay.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.orvexpay.sdk.exceptions.OrvexException;
import com.orvexpay.sdk.models.InvoiceRequest;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OrvexClient {
    private final String apiKey;
    private final String baseUrl;
    private final OkHttpClient httpClient;
    private final Gson gson;

    public OrvexClient(String apiKey) {
        this(apiKey, "https://api.orvexpay.com");
    }

    public OrvexClient(String apiKey, String baseUrl) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        this.gson = new Gson();
    }

    public JsonObject createInvoice(InvoiceRequest request) throws OrvexException, IOException {
        String json = gson.toJson(request);
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));

        Request httpRequest = new Request.Builder()
                .url(baseUrl + "/api/invoice")
                .post(body)
                .addHeader("x-api-key", apiKey)
                .build();

        return executeRequest(httpRequest);
    }

    public JsonObject getInvoice(String invoiceId) throws OrvexException, IOException {
        Request httpRequest = new Request.Builder()
                .url(baseUrl + "/api/invoice/" + invoiceId)
                .get()
                .addHeader("x-api-key", apiKey)
                .build();

        return executeRequest(httpRequest);
    }

    private JsonObject executeRequest(Request request) throws OrvexException, IOException {
        try (Response response = httpClient.newCall(request).execute()) {
            String body = response.body() != null ? response.body().string() : "";

            if (!response.isSuccessful()) {
                throw new OrvexException("OrvexPay API Error: " + response.message(), response.code(), body);
            }

            return gson.fromJson(body, JsonObject.class);
        }
    }
}

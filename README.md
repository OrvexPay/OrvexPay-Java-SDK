# OrvexPay Java SDK

Official Java SDK for the OrvexPay Payment Gateway.

## Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.orvexpay</groupId>
    <artifactId>orvexpay-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```gradle
implementation 'com.orvexpay:orvexpay-sdk:1.0.0'
```

## Usage

```java
import com.orvexpay.sdk.OrvexClient;
import com.orvexpay.sdk.models.InvoiceRequest;
import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
        OrvexClient client = new OrvexClient("your-api-key");

        try {
            InvoiceRequest request = new InvoiceRequest()
                    .setPriceAmount("100.00")
                    .setPriceCurrency("USD")
                    .setPayCurrency("USDT")
                    .setOrderId("ORDER-123");

            JsonObject invoice = client.createInvoice(request);
            System.out.println("Invoice ID: " + invoice.get("id").getAsString());
            System.out.println("Payment URL: " + invoice.get("payUrl").getAsString());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Features

- **OkHttp 4**: High-performance HTTP client.
- **Gson**: Robust JSON serialization/deserialization.
- **Java 8+**: Wide compatibility for modern and legacy systems.
- **Fluent API**: Easy-to-use builder pattern for models.

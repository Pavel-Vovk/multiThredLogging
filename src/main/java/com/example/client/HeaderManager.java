package com.example.client;

import java.util.HashMap;
import java.util.Map;

public class HeaderManager {
    public static Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        // Додати будь-які інші загальні заголовки, які потрібні для всіх запитів
        return headers;
    }

    public static Map<String, String> getCustomHeaders(Map<String, String> customHeaders) {
        Map<String, String> headers = getDefaultHeaders();
        if (customHeaders != null) {
            headers.putAll(customHeaders);
        }
        return headers;
    }
}

package com.carbon.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class MetricsController {
    @GetMapping("/api/metrics")
    public Map<String, Object> metrics() {
        return Map.of(
                "site", "https://wikipedia.org",
                "pageSizeKB", 980,
                "loadTimeMs", 2100,
                "estimatedCO2g", 1.2,
                "status", "PASS"
        );
    }
}
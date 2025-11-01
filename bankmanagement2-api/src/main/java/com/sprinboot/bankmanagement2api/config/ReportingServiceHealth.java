package com.sprinboot.bankmanagement2api.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Component
public class ReportingServiceHealth implements HealthIndicator {

    private static final String REPORTING_SERVICE_URL = "http://localhost:8080/reporting/health";

    @Override
    public Health health() {
        boolean isHealthy = checkReportingServiceHealth();

        if (isHealthy) {
            return Health.up()
                    .withDetail("Reporting Service", "Available")
                    .build();
        } else {
            return Health.down()
                    .withDetail("Reporting Service", "Unavailable")
                    .build();
        }
    }

    private boolean checkReportingServiceHealth() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(REPORTING_SERVICE_URL, String.class);
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {

            return false;
        }
    }
}

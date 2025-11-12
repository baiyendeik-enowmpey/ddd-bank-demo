package com.example.demo.integration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("default")
class TransferIntegrationTest {

    @Autowired
    private TestRestTemplate rest;

    @Test
    void transferEndpointWorks() {
        @SuppressWarnings("rawtypes")
		ResponseEntity<Map> resp = rest.postForEntity("/api/accounts/transfer?from=1&to=2&amount=100", null, Map.class);
        assert(resp.getStatusCode().is2xxSuccessful());
    }
}

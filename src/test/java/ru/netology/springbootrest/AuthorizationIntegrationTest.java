package ru.netology.springbootrest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class AuthorizationIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private static final GenericContainer<?> devApp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    @Container
    private static final GenericContainer<?> prodApp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
    }

    @Test
    void testDevProfileAuthorization() {
        String url = "http://localhost:" + devApp.getMappedPort(8080) +
                "/authorize?user=admin&password=123";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("[\"READ\",\"WRITE\",\"DELETE\"]", response.getBody());
    }

    @Test
    void testProdProfileAuthorization() {
        String url = "http://localhost:" + prodApp.getMappedPort(8081) +
                "/authorize?user=admin&password=123";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("[\"READ\",\"WRITE\",\"DELETE\"]", response.getBody());
    }
}
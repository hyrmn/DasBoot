package com.boot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ShipwreckControllerWebIntegrationTest {
    @Test
    public void testListAll() throws IOException {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJson = mapper.readTree(response.getBody());
        assertThat(responseJson.isMissingNode(), is(false));
    }
}

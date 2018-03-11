package com.mimacom.shapeservice.controllers;

import com.mimacom.shapeservice.model.Shape;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class ShapeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_return_correct_shape() {
        ResponseEntity<Shape> triangleResponse = restTemplate
                .getForEntity(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:" + port + "/triangle")
                        .queryParam("length", 100.0)
                        .queryParam("width", 100.0)
                        .build().toString(), Shape.class);

        BDDAssertions.then(triangleResponse.getStatusCodeValue())
                .isEqualTo(200);

        BDDAssertions.then(triangleResponse.getBody().getArea())
                .isEqualTo(5000.0);

    }

    @Test
    public void should_return_400_with_invalid_values() {
        ResponseEntity<Shape> triangleResponse = restTemplate
                .getForEntity(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:" + port + "/triangle")
                        .queryParam("length", "bob")
                        .queryParam("width", 100.0)
                        .build().toString(), Shape.class);

        BDDAssertions.then(triangleResponse.getStatusCodeValue())
                .isEqualTo(400);

    }

    @Test
    public void should_return_400_with_missing_values() {
        ResponseEntity<Shape> triangleResponse = restTemplate
                .getForEntity(UriComponentsBuilder
                        .fromHttpUrl("http://localhost:" + port + "/triangle")
                        .queryParam("width", 100.0)
                        .build().toString(), Shape.class);

        BDDAssertions.then(triangleResponse.getStatusCodeValue())
                .isEqualTo(400);

    }

}
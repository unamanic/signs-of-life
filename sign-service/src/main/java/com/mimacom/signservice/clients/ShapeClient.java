package com.mimacom.signservice.clients;

import com.mimacom.signservice.model.Shape;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ShapeClient {

    private final RestTemplate restTemplate;
    private final String shapeServiceUrl;

    public ShapeClient(RestTemplate restTemplate, @Value("${shapeService.url}")String shapeServiceUrl) {
        this.restTemplate = restTemplate;
        this.shapeServiceUrl = shapeServiceUrl;
    }


    public Shape getTriangle(Double length, Double width) {
        return restTemplate.getForEntity(
                UriComponentsBuilder
                        .fromHttpUrl(this.shapeServiceUrl + "/triangle")
                        .queryParam("length", length)
                        .queryParam("width", width)
                        .build().toString(), Shape.class).getBody();
    };
}

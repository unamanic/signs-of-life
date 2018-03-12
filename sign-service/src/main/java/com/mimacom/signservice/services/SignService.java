package com.mimacom.signservice.services;

import com.mimacom.signservice.clients.ShapeClient;
import com.mimacom.signservice.model.Shape;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    private final ShapeClient shapeClient;

    public SignService(ShapeClient shapeClient) {
        this.shapeClient = shapeClient;
    }

    public Double getTrianglePriceForDimensions(Double price, Double height, Double width) {
        Shape shape = shapeClient.getTriangle(height, width);
        return shape.getArea() * price;
    }
}

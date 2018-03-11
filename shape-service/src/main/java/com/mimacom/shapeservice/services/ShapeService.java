package com.mimacom.shapeservice.services;

import com.mimacom.shapeservice.model.Shape;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {

    public Shape getTriangle(Double height, Double width) {
        Shape shape = Shape.builder()
                .area(height * width / 2)
                .build();
        return shape;
    }
}

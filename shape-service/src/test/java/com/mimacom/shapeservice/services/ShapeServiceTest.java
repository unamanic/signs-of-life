package com.mimacom.shapeservice.services;

import com.mimacom.shapeservice.model.Shape;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

public class ShapeServiceTest {

    ShapeService shapeService = new ShapeService();

    @Test
    public void should_return_correct_triangle_calculation() {
        Shape triangle = shapeService.getTriangle(100.0, 100.0);

        BDDAssertions.then(triangle.getArea()).isEqualTo(5000.0);
    }
}
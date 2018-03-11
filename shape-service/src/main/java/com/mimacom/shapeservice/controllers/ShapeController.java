package com.mimacom.shapeservice.controllers;

import com.mimacom.shapeservice.model.Shape;
import com.mimacom.shapeservice.services.ShapeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShapeController {

    private final ShapeService shapeService;

    public ShapeController(ShapeService shapeService) {
        this.shapeService = shapeService;
    }

    @GetMapping("/triangle")
    ResponseEntity<Shape> getTriangle(@RequestParam Double length, @RequestParam Double width) {
        return ResponseEntity.ok().body(shapeService.getTriangle(length, width));
    }

}
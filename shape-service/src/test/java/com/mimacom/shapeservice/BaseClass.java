package com.mimacom.shapeservice;

import com.mimacom.shapeservice.controllers.ShapeController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShapeServiceApplication.class)
public class BaseClass {
    @Autowired
    ShapeController shapeController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(shapeController);
    }

    @Test
    public void contextLoads() {
    }
}


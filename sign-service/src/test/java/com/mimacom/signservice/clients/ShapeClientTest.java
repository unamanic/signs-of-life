package com.mimacom.signservice.clients;

import com.mimacom.signservice.clients.ShapeClient;
import com.mimacom.signservice.model.Shape;
import org.assertj.core.api.BDDAssertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ShapeClientTest {

    @Autowired
    ShapeClient shapeClient;

    @Test
    @Ignore
    public void getTriangle_integration_test() throws Exception {
        Shape triangle = shapeClient.getTriangle(100.0, 100.0);
        BDDAssertions.then(triangle.getArea()).isEqualTo(5000.0);
    }

}
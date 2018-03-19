package com.mimacom.signservice.clients;

import com.mimacom.signservice.clients.ShapeClient;
import com.mimacom.signservice.model.Shape;
import org.assertj.core.api.BDDAssertions;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubFinder;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ShapeClientTest {

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.mimacom", "shape-service")
            .withPort(8082)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Autowired
    ShapeClient shapeClient;

    @Test
    public void getTriangle_integration_test() throws Exception {
        Shape triangle = shapeClient.getTriangle(100.0, 100.0);
        BDDAssertions.then(triangle.getArea()).isEqualTo(5000.0);
    }

}
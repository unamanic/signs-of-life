package com.mimacom.signservice.services;

import com.mimacom.signservice.clients.ShapeClient;
import com.mimacom.signservice.model.Shape;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.BDDMockito.given;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SignServiceTest {

    @MockBean
    ShapeClient shapeClient;

    @Autowired
    SignService signService;

    @Test
    public void should_return_correct_price() throws Exception {
        given(shapeClient.getTriangle(Mockito.anyDouble(), Mockito.anyDouble()))
                .willReturn(Shape.builder().area(10000.).build());

        Double price = signService.getTrianglePriceForDimensions(.50, 100.0, 200.0);

        BDDAssertions.then(price).isEqualTo(5000);
    }

}
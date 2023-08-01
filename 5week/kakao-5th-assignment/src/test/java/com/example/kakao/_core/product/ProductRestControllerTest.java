package com.example.kakao._core.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class ProductRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void findAll_test() throws Exception {
        // given
        Integer page = 0;
        // when
        mvc.perform(get("/products"));

        // then

    }

}

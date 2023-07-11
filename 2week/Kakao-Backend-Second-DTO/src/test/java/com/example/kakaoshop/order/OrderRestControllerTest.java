package com.example.kakaoshop.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class OrderRestControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    @WithMockUser
    public void orderCart_test() throws Exception{
        //given
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QG5hdGUuY29tIiwicm9sZSI6IlJPTEVfVVNFUiIsImlkIjoxLCJleHAiOjE2ODk1NTUzMDV9.CEMCn2i8IeebgoLpVPCJ615wOqZ1xAyKel7b8mEpjkIq2l0ryEUfapABKF6u2WqTVQeq2cnUO9ODXEQSXnxmDw";

        // when
        ResultActions resultActions = mvc.perform(
                post("/orders/add")
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
        );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("테스트 : " + responseBody);


        // verify
        resultActions.andExpect(jsonPath("$.success").value("true"));
        resultActions.andExpect(jsonPath("$.response.id").value(1));
        resultActions.andExpect(jsonPath("$.response.products[0].productName").value("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전"));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].id").value(4));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].optionName").value("01. 슬라이딩 지퍼백 크리스마스에디션 4종"));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].quantity").value(10));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].price").value(100000));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].id").value(5));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].optionName").value("02. 슬라이딩 지퍼백 플라워에디션 5종"));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].quantity").value(10));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].price").value(109000));
        resultActions.andExpect(jsonPath("$.response.totalPrice").value(209000));
    }

    @Test
    @WithMockUser
    public void findById_test() throws Exception{
        //given
        int id = 1;
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0QG5hdGUuY29tIiwicm9sZSI6IlJPTEVfVVNFUiIsImlkIjoxLCJleHAiOjE2ODk1NTUzMDV9.CEMCn2i8IeebgoLpVPCJ615wOqZ1xAyKel7b8mEpjkIq2l0ryEUfapABKF6u2WqTVQeq2cnUO9ODXEQSXnxmDw";

        // when
        ResultActions resultActions = mvc.perform(
                get("/orders/" + id)
                        .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
        );
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("테스트 : " + responseBody);


        // verify
        resultActions.andExpect(jsonPath("$.success").value("true"));
        resultActions.andExpect(jsonPath("$.response.id").value(1));
        resultActions.andExpect(jsonPath("$.response.products[0].productName").value("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전"));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].id").value(4));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].optionName").value("01. 슬라이딩 지퍼백 크리스마스에디션 4종"));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].quantity").value(10));
        resultActions.andExpect(jsonPath("$.response.products[0].items[0].price").value(100000));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].id").value(5));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].optionName").value("02. 슬라이딩 지퍼백 플라워에디션 5종"));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].quantity").value(10));
        resultActions.andExpect(jsonPath("$.response.products[0].items[1].price").value(109000));
        resultActions.andExpect(jsonPath("$.response.totalPrice").value(209000));
    }
}

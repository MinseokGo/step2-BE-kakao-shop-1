package com.example.kakao.order;

import com.example.kakao._core.security.SecurityConfig;
import com.example.kakao._core.utils.FakeStore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Import({
        FakeStore.class,
        SecurityConfig.class
})
@WebMvcTest(controllers = {OrderRestController.class})
public class OrderRestControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper om;

    @WithMockUser(username = "ssar@nate.com", roles = "USER")
    @Test
    public void save_test() throws Exception {
        // given

        // when
        ResultActions result = mvc.perform(
                MockMvcRequestBuilders
                        .post("/orders/save")
        );

        String responseBody = result.andReturn().getResponse().getContentAsString();
        System.out.println("테스트: " + responseBody);

        // then
        result.andExpect(MockMvcResultMatchers.jsonPath("$.success").value("true"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(1));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].id").value(1));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].productName").value("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].id").value(1));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].optionName").value("01. 슬라이딩 지퍼백 크리스마스에디션 4종"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].price").value(50000));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.totalPrice").value(104500));
    }

    @WithMockUser(username = "ssar@nate.com", roles = "USER")
    @Test
    public void findById_test() throws Exception {
        // given
        int id = 1;

        // when
        ResultActions result = mvc.perform(
                MockMvcRequestBuilders
                        .get("/orders/" + id)
        );

        String responseBody = result.andReturn().getResponse().getContentAsString();
        System.out.println("테스트: " + responseBody);

        // then
        result.andExpect(MockMvcResultMatchers.jsonPath("$.success").value("true"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(1));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].id").value(1));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].productName").value("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].id").value(1));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].optionName").value("01. 슬라이딩 지퍼백 크리스마스에디션 4종"));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].price").value(50000));
        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.totalPrice").value(104500));
    }

    @WithMockUser(username = "ssar@nate.com", roles = "USER")
    @Test
    public void findById_fail_test() throws Exception {
        // given
        int id = 3;

        // when
        ResultActions result = mvc.perform(
                MockMvcRequestBuilders
                        .get("/orders/" + id)
        );

        String responseBody = result.andReturn().getResponse().getContentAsString();
        System.out.println("테스트: " + responseBody);

        // then
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.success").value("true"));
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.id").value(1));
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].id").value(1));
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].productName").value("기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전"));
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].id").value(1));
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].optionName").value("01. 슬라이딩 지퍼백 크리스마스에디션 4종"));
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.products[0].items[0].price").value(50000));
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.response.totalPrice").value(104500));
    }
}

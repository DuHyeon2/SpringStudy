package com.springboot.test.controller;

import com.springboot.test.data.dto.ProductResponseDto;
import com.springboot.test.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    ProductServiceImpl productService;
    
    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception{
        given(productService.getProduct(123L)).willReturn(
                new ProductResponseDto(123L, "pen", 5000, 2000));

        String productId = "123";

        mockMvc.perform(
                        get("/product?number=" + productId))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath(
                        "$.number").exists())
                .andExpect((ResultMatcher) jsonPath("$.name").exists())
                .andExpect((ResultMatcher) jsonPath("$.price").exists())
                .andExpect((ResultMatcher) jsonPath("$.stock").exists())
                .andDo(print());

        verify(productService).getProduct(123L);
    }

}

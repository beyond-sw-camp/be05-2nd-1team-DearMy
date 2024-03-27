package com.encore.bbabap.api.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.PrivateKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


class UserApiTest {

    @Autowired
    private UserApi userApi;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("회원 가입이 성공하면 201 created 를 만들어 준다.")
    @Test
    void test() throws Exception {
        //given

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/members/register"))
                .andExpect(status().isCreated())
                .andExpect(content().string("This will return posts's URI."))
        ;
        //when

        //then
    }

}
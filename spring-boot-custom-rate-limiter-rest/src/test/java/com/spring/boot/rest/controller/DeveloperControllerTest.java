package com.spring.boot.rest.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.SharedHttpSessionConfigurer;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DeveloperControllerTest {

    private static MockMvc mockMvc;

    @BeforeAll
    public static void startup(){
        mockMvc = MockMvcBuilders.standaloneSetup(new DeveloperController())
                .apply(SharedHttpSessionConfigurer.sharedHttpSession())
                .build();
    }

    @Test
    public void shouldReturnDevelopersList() throws Exception {
        mockMvc.perform(get("/api/v1/developers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
package com.mobiquity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MobiquitycodechallengeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAllAtmsSuccess() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/atms/all");
        this.mockMvc.perform(requestBuilder).andExpect(status().is(200));
    }

    @Test
    public void testAllAtmsByCitySuccess() throws Exception{
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/atms/getbycity/{city}","Veenendaal");
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void testAllAtmsByCityFailure() throws Exception{
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/atms/getbycity/{city}","Veenendaal_wrong_city");
        this.mockMvc.perform(requestBuilder).andExpect(status().isBadRequest());
    }

}

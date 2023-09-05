package com.spring.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.spring.project.impl.CloudVendorServiceImpl;
import com.spring.project.model.CloudVendor;
import com.spring.project.response.ResponseHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
class ControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorServiceImpl cloudVendorService;
    @MockBean
    private ResponseHandler responseHandler;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("1","Amazon","Address1","8218634006");
        cloudVendorTwo = new CloudVendor("2","Dell","Address2","754798755");
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void index() {
    }

    @Test
    void testGetCloudAPI() throws Exception {
        when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/details/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllCloudAPI() throws Exception {
        when(cloudVendorService.getAllCloudVendor()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/details")).andDo(print()).andExpect(status().isOk());
    }


    @Test
    void testCreateCloudVendor() throws Exception {
        /*when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
        this.mockMvc.perform(post("/vendor/create")).andDo(print()).andExpect(status().is4xxClientError());*/
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
        this.mockMvc.perform(post("/vendor/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testUpdateCloudVendor() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);

        when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("success");
        this.mockMvc.perform(put("/vendor/update").contentType(MediaType.APPLICATION_JSON).content(requestJson)).
                andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testDeleteCloudVendor() throws Exception {
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Success");
        this.mockMvc.perform(delete("/vendor/delete/1")).andDo(print()).andExpect(status().isOk());
    }
}
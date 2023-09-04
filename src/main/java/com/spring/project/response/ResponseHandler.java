package com.spring.project.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseHandler {
    public  ResponseEntity<Object> responseBuilder(
            String message, HttpStatus httpStatus,Object responseObject)
    {
        Map<String,Object> response =new HashMap<>();
        response.put("message",message);
        response.put("httpStatus",httpStatus);
        response.put("data",responseObject);
        return new ResponseEntity<>(response,httpStatus);
    }

}


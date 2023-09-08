package com.spring.project.controller;

import com.spring.project.model.CloudVendor;
import com.spring.project.response.ResponseHandler;
import com.spring.project.service.CloudVendorService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;


@RestController
public class Controller {


    private static final Logger loginfo = LoggerFactory.getLogger(Controller.class);
    @Autowired
    CloudVendorService cloudVendorService;
    @Autowired
    ResponseHandler responseHandler;
    /* @Autowired
     CloudVendor cloudVendor;*/
    public Controller(CloudVendorService cloudVendorService,ResponseHandler responseHandler) {
        this.cloudVendorService = cloudVendorService;
        this.responseHandler = responseHandler;
        /* this.cloudVendor = cloudVendor;*/
    }


    @GetMapping(value="/vendor/1")
    public String index() {
        loginfo.info("logging is enable");
        loginfo.debug("Vendor debug logging is on");
        return "Greetings from Spring Boot 4!";
    }

    @GetMapping("/vendor/details/{id}")
    public ResponseEntity<Object> getCloudAPI(@PathVariable String id)
    {
        return responseHandler.responseBuilder("get object",HttpStatus.OK,cloudVendorService.getCloudVendor(id));

    }
    @GetMapping("/vendor/details")
    public ResponseEntity<Object> getAllCloudAPI()
    {
        return responseHandler.responseBuilder("get object",HttpStatus.OK,cloudVendorService.getAllCloudVendor());

        //return new ResponseEntity<>(cloudVendorService.getAllCloudVendor(), HttpStatus.OK);
    }

    @PostMapping("/vendor/create")
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor)
    {
        System.out.println("Hi");
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloudVendor create successfully";

    }

    @PutMapping("/vendor/update")
    public String updateCloudVendor(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloudVendor update successfully";

    }
    @DeleteMapping("/vendor/delete/{id}")
    public String deleteCloudVendor(@PathVariable String id)
    {
        cloudVendorService.deleteCloudVendor(id);
        return "cloudVendor deleted successfully";

    }

}

package com.spring.project.controller;

import com.spring.project.model.CloudVendor;
import com.spring.project.response.ResponseHandler;
import com.spring.project.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {


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


    @GetMapping(value="")
    public String index() {
        return "Greetings from Spring Boot 2!";
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Object> getCloudAPI(@PathVariable String id)
    {
        return responseHandler.responseBuilder("get object",HttpStatus.OK,cloudVendorService.getCloudVendor(id));

    }
    @GetMapping("/details")
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

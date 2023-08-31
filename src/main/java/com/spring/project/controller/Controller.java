package com.spring.project.controller;

import com.spring.project.model.CloudVendor;
import com.spring.project.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class Controller {


    @Autowired
    CloudVendorService cloudVendorService;
    /* @Autowired
     CloudVendor cloudVendor;*/
    public Controller(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
        /* this.cloudVendor = cloudVendor;*/
    }


    @GetMapping(value="")
    public String index() {
        return "Greetings from Spring Boot 2!";
    }

    @GetMapping("/details")
    public CloudVendor getCloudAPI()
    {

        // return new CloudVendor("1","Abc","Address1","9218383");
        /* return cloudVendor;*/
        return null;
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
        /*this.cloudVendor=null;*/
        return "cloudVendor deleted successfully";

    }

}

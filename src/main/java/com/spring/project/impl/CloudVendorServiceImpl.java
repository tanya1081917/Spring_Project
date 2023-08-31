package com.spring.project.impl;


import com.spring.project.model.CloudVendor;
import com.spring.project.repository.CloudVendorRepository;
import com.spring.project.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CloudVendorServiceImpl implements CloudVendorService {

    @Autowired
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl() {
    }

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.saveAndFlush(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.saveAndFlush(cloudVendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorID) {
        return null;
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorID) {
        return null;
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        /*cloudVendorRepository.findAll();*/
        return null;
    }
}

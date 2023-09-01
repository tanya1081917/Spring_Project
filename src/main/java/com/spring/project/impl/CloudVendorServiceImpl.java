package com.spring.project.impl;


import com.spring.project.exception.CloudVendorExceptionHandler;
import com.spring.project.exception.CloudVendorNotFoundException;
import com.spring.project.model.CloudVendor;
import com.spring.project.repository.CloudVendorRepository;
import com.spring.project.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        cloudVendorRepository.deleteById(cloudVendorID);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorID)  {
        Optional <CloudVendor> cloudVendor =cloudVendorRepository.findById(cloudVendorID);
        if(cloudVendor.isEmpty())
            throw new CloudVendorNotFoundException("Requested Exception Not Found ");
        return cloudVendor.get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {

        return cloudVendorRepository.findAll();
    }
}

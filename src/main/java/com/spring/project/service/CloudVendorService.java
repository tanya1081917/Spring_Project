package com.spring.project.service;


import com.spring.project.model.CloudVendor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorID);
    public CloudVendor getCloudVendor(String cloudVendorID);
    public List<CloudVendor> getAllCloudVendor();
}

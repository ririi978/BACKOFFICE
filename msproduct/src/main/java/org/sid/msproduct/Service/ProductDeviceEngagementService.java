package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.ProductDeviceEngagement;
import org.sid.msproduct.Repository.ProductDeviceEngagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeviceEngagementService {

    @Autowired
    private ProductDeviceEngagementRepo productDeviceEngagementRepo;

    public ProductDeviceEngagement saveProductDeviceEngagement(ProductDeviceEngagement engagement) {
        return productDeviceEngagementRepo.save(engagement);
    }
}
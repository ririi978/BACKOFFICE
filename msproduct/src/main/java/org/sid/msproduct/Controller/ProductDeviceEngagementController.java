package org.sid.msproduct.Controller;

import org.sid.msproduct.Entity.ProductDeviceEngagement;
import org.sid.msproduct.Service.ProductDeviceEngagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device-engagements")
public class ProductDeviceEngagementController {

    @Autowired
    private ProductDeviceEngagementService productDeviceEngagementService;

    @PostMapping
    public ResponseEntity<ProductDeviceEngagement> createProductDeviceEngagement(@RequestBody ProductDeviceEngagement engagement) {
        ProductDeviceEngagement savedEngagement = productDeviceEngagementService.saveProductDeviceEngagement(engagement);
        return new ResponseEntity<>(savedEngagement, HttpStatus.CREATED);
    }
}

package org.sid.msproduct.Controller;

import org.sid.msproduct.Entity.DeviceCriteria;
import org.sid.msproduct.Service.DeviceCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device-criteria")
public class DeviceCriteriaController {

    @Autowired
    private DeviceCriteriaService deviceCriteriaService;

    @PostMapping
    public ResponseEntity<DeviceCriteria> createDeviceCriteria(@RequestBody DeviceCriteria deviceCriteria) {
        DeviceCriteria savedDeviceCriteria = deviceCriteriaService.saveDeviceCriteria(deviceCriteria);
        return new ResponseEntity<>(savedDeviceCriteria, HttpStatus.CREATED);
    }
}

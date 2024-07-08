package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.DeviceCriteria;
import org.sid.msproduct.Repository.DeviceCriteriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceCriteriaService {

    @Autowired
    private DeviceCriteriaRepo deviceCriteriaRepo;

    public DeviceCriteria saveDeviceCriteria(DeviceCriteria deviceCriteria) {
        return deviceCriteriaRepo.save(deviceCriteria);
    }
}

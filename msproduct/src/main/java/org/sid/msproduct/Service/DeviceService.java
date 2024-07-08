package org.sid.msproduct.Service;

import org.sid.msproduct.Entity.Device;
import org.sid.msproduct.Repository.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    private final DeviceRepo deviceRepo;

    @Autowired
    public DeviceService(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    public Page<Device> searchDevices(String title, Pageable pageable) {
        return deviceRepo.findByTitleContainingIgnoreCase(title, pageable);
    }

    public Device addDevice(Device device) {
        return deviceRepo.save(device);
    }


    public Device updateDevice(Device device) {
        return deviceRepo.save(device);
    }


    public List<Device> findAllDevices() {
        return deviceRepo.findAll();
    }


    public Optional<Device> findDeviceById(Long id) {
        return deviceRepo.findById(id);
    }


    public void deleteDeviceById(Long id) {
        deviceRepo.deleteById(id);
    }
}


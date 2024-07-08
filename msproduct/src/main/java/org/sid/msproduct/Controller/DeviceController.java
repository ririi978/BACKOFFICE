package org.sid.msproduct.Controller;

import org.sid.msproduct.Entity.Device;
import org.sid.msproduct.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Device>> searchDevices(@RequestParam(required = false) String title, Pageable pageable) {
        Page<Device> devices = deviceService.searchDevices(title, pageable);
        return ResponseEntity.ok(devices);
    }

    @PostMapping("/create")
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device savedDevice = deviceService.addDevice(device);
        return ResponseEntity.ok(savedDevice);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device) {
        device.setId(id);
        Device updatedDevice = deviceService.updateDevice(device);
        return ResponseEntity.ok(updatedDevice);
    }


    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.findAllDevices();
        return ResponseEntity.ok(devices);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        return deviceService.findDeviceById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDeviceById(id);
        return ResponseEntity.ok().build();
    }
}


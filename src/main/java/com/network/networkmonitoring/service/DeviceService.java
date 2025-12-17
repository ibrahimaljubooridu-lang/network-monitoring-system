package com.network.networkmonitoring.service;

import com.network.networkmonitoring.entity.Device;
import com.network.networkmonitoring.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }


    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }


    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }


    public Device updateDevice(Long id, Device updatedDevice) {

        Optional<Device> optionalDevice = deviceRepository.findById(id);

        if (optionalDevice.isEmpty()) {
            return null;
        }

        Device existing = optionalDevice.get();
        existing.setName(updatedDevice.getName());
        existing.setIpAddress(updatedDevice.getIpAddress());
        existing.setMaxCapacity(updatedDevice.getMaxCapacity());
        existing.setCurrentUsage(updatedDevice.getCurrentUsage());
        existing.setUserId(updatedDevice.getUserId());

        return deviceRepository.save(existing);
    }


    public boolean deleteDevice(Long id) {
        if (!deviceRepository.existsById(id)) {
            return false;
        }
        deviceRepository.deleteById(id);
        return true;
    }
}

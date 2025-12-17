package com.network.networkmonitoring.service;

import com.network.networkmonitoring.entity.DeviceMetric;
import com.network.networkmonitoring.repository.DeviceMetricRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceMetricService {

    private final DeviceMetricRepository deviceMetricRepository;

    public DeviceMetricService(DeviceMetricRepository deviceMetricRepository) {
        this.deviceMetricRepository = deviceMetricRepository;
    }

    public List<DeviceMetric> getAllMetrics() {
        return deviceMetricRepository.findAll();
    }

    public DeviceMetric getMetricById(Long id) {
        return deviceMetricRepository.findById(id).orElse(null);
    }

    public DeviceMetric createMetric(DeviceMetric metric) {
        return deviceMetricRepository.save(metric);
    }

    public DeviceMetric updateMetric(Long id, DeviceMetric updatedMetric) {
        Optional<DeviceMetric> optional = deviceMetricRepository.findById(id);
        if (optional.isEmpty()) return null;

        DeviceMetric existing = optional.get();
        existing.setCurrentUsage(updatedMetric.getCurrentUsage());
        existing.setTimestamp(updatedMetric.getTimestamp());
        existing.setDevice(updatedMetric.getDevice());

        return deviceMetricRepository.save(existing);
    }

    public boolean deleteMetric(Long id) {
        if (!deviceMetricRepository.existsById(id)) return false;
        deviceMetricRepository.deleteById(id);
        return true;
    }
}

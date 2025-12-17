package com.network.networkmonitoring.controller;

import com.network.networkmonitoring.entity.DeviceMetric;
import com.network.networkmonitoring.service.DeviceMetricService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-metrics")
public class DeviceMetricController {

    private final DeviceMetricService deviceMetricService;

    public DeviceMetricController(DeviceMetricService deviceMetricService) {
        this.deviceMetricService = deviceMetricService;
    }

    @GetMapping
    public List<DeviceMetric> getAllMetrics() {
        return deviceMetricService.getAllMetrics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceMetric> getMetric(@PathVariable Long id) {
        DeviceMetric metric = deviceMetricService.getMetricById(id);
        return metric != null
                ? ResponseEntity.ok(metric)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public DeviceMetric createMetric(@RequestBody DeviceMetric metric) {
        return deviceMetricService.createMetric(metric);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceMetric> updateMetric(@PathVariable Long id, @RequestBody DeviceMetric metric) {
        DeviceMetric updated = deviceMetricService.updateMetric(id, metric);
        return updated != null
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetric(@PathVariable Long id) {
        boolean deleted = deviceMetricService.deleteMetric(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

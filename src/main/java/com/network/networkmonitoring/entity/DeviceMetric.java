package com.network.networkmonitoring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_metrics")
public class DeviceMetric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int currentUsage;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    public DeviceMetric() {}

    public DeviceMetric(Device device, int currentUsage, LocalDateTime timestamp) {
        this.device = device;
        this.currentUsage = currentUsage;
        this.timestamp = timestamp;
    }


    public Long getId() { return id; }
    public int getCurrentUsage() { return currentUsage; }
    public void setCurrentUsage(int currentUsage) { this.currentUsage = currentUsage; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public Device getDevice() { return device; }
    public void setDevice(Device device) { this.device = device; }
}

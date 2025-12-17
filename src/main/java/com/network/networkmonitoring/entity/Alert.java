package com.network.networkmonitoring.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private LocalDateTime createdAt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Alert() {}

    public Alert(Device device, String message, LocalDateTime createdAt, String status) {
        this.device = device;
        this.message = message;
        this.createdAt = createdAt;
        this.status = status;
    }


    public Long getId() { return id; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Device getDevice() { return device; }
    public void setDevice(Device device) { this.device = device; }
}

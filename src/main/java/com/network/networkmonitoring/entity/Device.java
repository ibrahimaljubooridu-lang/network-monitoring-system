package com.network.networkmonitoring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "ip_address", nullable = false)
    private String ipAddress;

    @Column(name = "max_capacity", nullable = false)
    private int maxCapacity;

    @Column(name = "current_usage", nullable = false)
    private int currentUsage;

    @Column(name = "user_id")
    private Long userId;


    public Device() {
    }

    public Device(String name, String ipAddress, int maxCapacity, int currentUsage, Long userId) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.maxCapacity = maxCapacity;
        this.currentUsage = currentUsage;
        this.userId = userId;
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(int currentUsage) {
        this.currentUsage = currentUsage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

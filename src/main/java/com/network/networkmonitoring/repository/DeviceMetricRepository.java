package com.network.networkmonitoring.repository;

import com.network.networkmonitoring.entity.DeviceMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMetricRepository extends JpaRepository<DeviceMetric, Long> {
}

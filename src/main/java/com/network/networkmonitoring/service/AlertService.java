package com.network.networkmonitoring.service;
import com.network.networkmonitoring.entity.Alert;
import com.network.networkmonitoring.repository.AlertRepository;
import org.springframework.stereotype.Service; import java.util.List;
import java.util.Optional;
@Service
public class AlertService
{ private final AlertRepository alertRepository;
    public AlertService(AlertRepository alertRepository) { this.alertRepository = alertRepository; }
    public List<Alert> getAllAlerts() { return alertRepository.findAll(); }
    public Alert getAlertById(Long id) { return alertRepository.findById(id).orElse(null); }
    public Alert createAlert(Alert alert) { return alertRepository.save(alert); }
    public Alert updateAlert(Long id, Alert updatedAlert) { Optional<Alert> optional = alertRepository.findById(id);
        if (optional.isEmpty())
            return null; Alert existing = optional.get();
            existing.setMessage(updatedAlert.getMessage());
            existing.setStatus(updatedAlert.getStatus());
            existing.setCreatedAt(updatedAlert.getCreatedAt());
            existing.setDevice(updatedAlert.getDevice());
            return alertRepository.save(existing);
    }
    public boolean deleteAlert(Long id) { if (!alertRepository.existsById(id)) return false;
        alertRepository.deleteById(id); return true; } }
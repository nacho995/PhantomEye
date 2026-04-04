package com.phantomeye.service;

import com.phantomeye.model.Alert;
import com.phantomeye.model.ScanResult;
import com.phantomeye.model.Severity;
import com.phantomeye.model.State;
import com.phantomeye.repository.AlertRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertService
{
    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository)
    {
        this.alertRepository = alertRepository;
    }

    public void evaluationScanner(ScanResult scanResult){
        if(scanResult.getSeverity() == Severity.HIGH){
            Alert alert = new Alert();
            alert.setAssetId(scanResult.getAssetId());
            alert.setTimeStamp(scanResult.getTimeStamp());
            alert.setSeverity(scanResult.getSeverity());
            alert.setState(State.OPEN);
            alert.setAttackDescription(scanResult.getOpenPorts().toString());
            alertRepository.save(alert);
        }
    }
}

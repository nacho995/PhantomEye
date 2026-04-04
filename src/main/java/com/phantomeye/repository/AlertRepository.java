package com.phantomeye.repository;

import com.phantomeye.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> getAlertByAssetId(Long assetId);
}

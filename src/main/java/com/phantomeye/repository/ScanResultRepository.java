package com.phantomeye.repository;

import com.phantomeye.model.ScanResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanResultRepository extends JpaRepository<ScanResult, Long> {
}

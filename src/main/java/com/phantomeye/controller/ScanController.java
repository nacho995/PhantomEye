package com.phantomeye.controller;

import com.phantomeye.model.ScanResult;
import com.phantomeye.model.Severity;
import com.phantomeye.repository.AssetRepository;
import com.phantomeye.repository.ScanResultRepository;
import com.phantomeye.service.AlertService;
import com.phantomeye.service.PortScannerService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/scan")
public class ScanController {

    private final AssetRepository assetRepository;
    private final ScanResultRepository scanResultRepository;
    private final PortScannerService portScannerService;
    private final AlertService alertService;

    public ScanController(AssetRepository assetRepository,
                          ScanResultRepository scanResultRepository,
                          PortScannerService portScannerService, AlertService alertService) {
        this.assetRepository = assetRepository;
        this.scanResultRepository = scanResultRepository;
        this.portScannerService = portScannerService;
        this.alertService = alertService;

    }

    @PostMapping("/{assetId}")
    public ScanResult scan(@PathVariable Long assetId) {
        var asset = assetRepository.findById(assetId).orElseThrow();
        var openPorts = portScannerService.scanPorts(
                asset.getIp(),
                List.of(22, 80, 443, 3306, 5432, 8080)
        );

        var scanResult = new ScanResult();
        scanResult.setAssetId(assetId);
        scanResult.setTimeStamp(LocalDateTime.now());
        scanResult.setOpenPorts(openPorts);
        scanResult.setSeverity(openPorts.isEmpty() ? Severity.LOW : Severity.HIGH);

        alertService.evaluationScanner(scanResult);
        return scanResultRepository.save(scanResult);
    }
}

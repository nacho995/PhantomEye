package com.phantomeye.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "scan_results")
public class ScanResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assetId;

    private LocalDateTime timeStamp;

    @ElementCollection
    @CollectionTable(name = "scan_result_open_ports", joinColumns = @JoinColumn(name = "scan_result_id"))
    @Column(name = "port")
    private List<Integer> openPorts;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAssetId() { return assetId; }
    public void setAssetId(Long assetId) { this.assetId = assetId; }

    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }

    public List<Integer> getOpenPorts() { return openPorts; }
    public void setOpenPorts(List<Integer> openPorts) { this.openPorts = openPorts; }

    public Severity getSeverity() { return severity; }
    public void setSeverity(Severity severity) { this.severity = severity; }
}

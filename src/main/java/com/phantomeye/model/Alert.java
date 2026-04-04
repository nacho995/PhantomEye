package com.phantomeye.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "alerts")
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assetId;

    private LocalDateTime timeStamp;

    @ElementCollection
    @CollectionTable(name = "alert_inform_documents", joinColumns = @JoinColumn(name = "alert_id"))
    @Column(name = "document")
    private List<String> informDocuments;

    private String attackDescription;

    @Enumerated(EnumType.STRING)
    private State state;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAssetId() { return assetId; }
    public void setAssetId(Long assetId) { this.assetId = assetId; }

    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }

    public List<String> getInformDocuments() { return informDocuments; }
    public void setInformDocuments(List<String> informDocuments) { this.informDocuments = informDocuments; }

    public String getAttackDescription() { return attackDescription; }
    public void setAttackDescription(String attackDescription) { this.attackDescription = attackDescription; }

    public State getState() { return state; }
    public void setState(State state) { this.state = state; }

    public Severity getSeverity() { return severity; }
    public void setSeverity(Severity severity) { this.severity = severity; }
}

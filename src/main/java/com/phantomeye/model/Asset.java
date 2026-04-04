package com.phantomeye.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AssetType assetType;

    private String name;
    private String ip;
    private String mac;
    private boolean isActive;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AssetType getAssetType() { return assetType; }
    public void setAssetType(AssetType assetType) { this.assetType = assetType; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public String getMac() { return mac; }
    public void setMac(String mac) { this.mac = mac; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}

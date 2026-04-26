package com.phantomeye.service;

import com.jetbrains.exported.JBRApi;
import com.phantomeye.dto.AssetRequest;
import com.phantomeye.dto.AssetResponse;
import com.phantomeye.model.Asset;
import com.phantomeye.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetService {
    private AssetRepository assetRepository;
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }


    public List<AssetResponse> getAllAssets() {
        List<AssetResponse> result = new ArrayList<>();
        List<Asset> assets = assetRepository.findAll();
        for (Asset asset : assets)
        {
            AssetResponse assetResponse = new AssetResponse();
            assetResponse.setAssetType(asset.getAssetType());
            assetResponse.setIp(asset.getIp());
            assetResponse.setMac(asset.getMac());
            assetResponse.setActive(asset.isActive());
            assetResponse.setName(asset.getName());
            assetResponse.setId(asset.getId());
            result.add(assetResponse);
        }
        return result;
    }

    public AssetResponse getAssets(AssetRequest assetRequest) {
        Asset asset = new Asset();
        AssetRequest assetRequest = new AssetRequest();
        AssetResponse assetResponse = new AssetResponse();

        asset.setIp(assetRequest.getIp());
        asset.setName(assetRequest.getName());

        assetRepository.save(asset);


        assetResponse.setName(assetRequest.getName());
        assetResponse.setId(assetRequest.getId());
        return assetResponse;

    }
}

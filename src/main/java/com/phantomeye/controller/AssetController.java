package com.phantomeye.controller;

import com.phantomeye.model.Asset;
import com.phantomeye.repository.AssetRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetRepository assetRepository;

    public AssetController(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @GetMapping
    public List<Asset> getAll() {
        return assetRepository.findAll();
    }

    @PostMapping
    public Asset create(@RequestBody Asset asset) {
        return assetRepository.save(asset);
    }
}

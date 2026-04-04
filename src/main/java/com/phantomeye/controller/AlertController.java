package com.phantomeye.controller;

import com.phantomeye.model.Alert;
import com.phantomeye.repository.AlertRepository;
import com.phantomeye.service.AlertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController
{
    private final AlertRepository alertRepository;
    public AlertController(AlertRepository alertRepository)
    {
        this.alertRepository = alertRepository;
    }

    @GetMapping
    public List<Alert> getAll() { return alertRepository.findAll();}
}

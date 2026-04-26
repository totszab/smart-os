package com.example.smart_os.controller;

import com.example.smart_os.service.SimulatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulation")
@RequiredArgsConstructor
public class SimulatorController {

    private final SimulatorService simulatorService;

    @PostMapping("/loadData")
    public String run() {
        simulatorService.loadData();
        return "Simulation executed";
    }
}
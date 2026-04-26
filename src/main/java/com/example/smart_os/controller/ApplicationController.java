package com.example.smart_os.controller;

import com.example.smart_os.converter.application.ApplicationConverter;
import com.example.smart_os.dto.application.ApplicationDto;
import com.example.smart_os.dto.application.CreateApplicationRequest;
import com.example.smart_os.dto.application.LaunchResponse;
import com.example.smart_os.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;
    private final ApplicationConverter applicationConverter;

    @PostMapping("/create")
    public ApplicationDto create(@RequestBody CreateApplicationRequest request) {
        return applicationConverter.toDto(applicationService.createApplication(request));
    }

    @PostMapping("/{id}/launch")
    public LaunchResponse launch(@PathVariable String id) {
        return applicationService.launch(id);
    }

    @GetMapping("/getAll")
    public List<ApplicationDto> getAll() {
        return applicationService.getAll()
                .stream()
                .map(applicationConverter::toDto)
                .toList();
    }
}

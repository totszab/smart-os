package com.example.smart_os.controller;

import com.example.smart_os.converter.background.BackgroundConverter;
import com.example.smart_os.converter.partner.PartnerConverter;
import com.example.smart_os.dto.background.AssignBackgroundRequest;
import com.example.smart_os.dto.background.BackgroundDto;
import com.example.smart_os.dto.background.CreateBackgroundRequest;
import com.example.smart_os.dto.partner.PartnerDto;
import com.example.smart_os.service.BackgroundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/background")
@RequiredArgsConstructor
public class BackgroundController {

    private final BackgroundService backgroundService;
    private final BackgroundConverter backgroundConverter;
    private final PartnerConverter partnerConverter;

    @PostMapping("/create")
    public BackgroundDto create(@RequestBody CreateBackgroundRequest req) {
        return backgroundConverter.toDto(
                backgroundService.create(req)
        );
    }

    @GetMapping("/getAll")
    public List<BackgroundDto> getAll() {
        return backgroundService.getAll()
                .stream()
                .map(backgroundConverter::toDto)
                .toList();
    }

    @PutMapping("/assignToPartner")
    public PartnerDto assignToPartner(@RequestBody AssignBackgroundRequest req) {

        return partnerConverter.toDto(
                backgroundService.assignToPartner(req)
        );
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        backgroundService.delete(id);
    }
}

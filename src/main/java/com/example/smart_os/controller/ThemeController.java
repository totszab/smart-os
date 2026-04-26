package com.example.smart_os.controller;

import com.example.smart_os.converter.theme.ThemeConverter;
import com.example.smart_os.converter.partner.PartnerConverter;
import com.example.smart_os.dto.theme.AssignThemeRequest;
import com.example.smart_os.dto.theme.CreateThemeRequest;
import com.example.smart_os.dto.theme.ThemeDto;
import com.example.smart_os.dto.partner.PartnerDto;
import com.example.smart_os.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theme")
@RequiredArgsConstructor
public class ThemeController {

    private final ThemeService themeService;
    private final ThemeConverter themeConverter;
    private final PartnerConverter partnerConverter;

    @PostMapping("/create")
    public ThemeDto create(@RequestBody CreateThemeRequest req) {
        return themeConverter.toDto(
                themeService.create(req)
        );
    }

    @GetMapping("/getAll")
    public List<ThemeDto> getAll() {
        return themeService.getAll()
                .stream()
                .map(themeConverter::toDto)
                .toList();
    }

    @PutMapping("/assignToPartner")
    public PartnerDto assignToPartner(@RequestBody AssignThemeRequest req) {

        return partnerConverter.toDto(
                themeService.assignToPartner(req)
        );
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        themeService.delete(id);
    }
}
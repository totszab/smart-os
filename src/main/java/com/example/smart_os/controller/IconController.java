package com.example.smart_os.controller;

import com.example.smart_os.converter.icon.IconConverter;
import com.example.smart_os.dto.icon.CreateIconRequest;
import com.example.smart_os.dto.icon.IconDto;
import com.example.smart_os.dto.icon.UpdateIconRequest;
import com.example.smart_os.service.IconService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/icon")
@RequiredArgsConstructor
public class IconController {

    private final IconConverter iconConverter;
    private final IconService iconService;

    @PostMapping("/create")
    public IconDto create(@RequestBody CreateIconRequest request) {
        return iconConverter.toDto(iconService.createIcon(request));
    }

    @PutMapping("/update/{id}")
    public IconDto update(@RequestBody UpdateIconRequest req) {
        return iconConverter.toDto(iconService.update(req));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        iconService.delete(id);
    }

    @GetMapping("/getAll")
    public List<IconDto> getAll() {
        return iconService.getAll()
                .stream()
                .map(iconConverter::toDto)
                .toList();
    }
}

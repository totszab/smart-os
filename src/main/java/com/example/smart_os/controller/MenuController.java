package com.example.smart_os.controller;

import com.example.smart_os.converter.menu.MenuConverter;
import com.example.smart_os.dto.menu.CreateMenuRequest;
import com.example.smart_os.dto.menu.MenuDto;
import com.example.smart_os.dto.menu.UpdateMenuRequest;
import com.example.smart_os.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;
    private final MenuConverter menuConverter;

    @PostMapping("/create")
    public MenuDto create(@RequestBody CreateMenuRequest request) {
        return menuConverter.toDto(menuService.createMenu(request));
    }

    @PutMapping("/update/{id}")
    public MenuDto update(@RequestBody UpdateMenuRequest req) {
        return menuConverter.toDto(menuService.update(req));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        menuService.delete(id);
    }

    @GetMapping("/getAll")
    public List<MenuDto> getAll() {
        return menuService.getAll()
                .stream()
                .map(menuConverter::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public MenuDto get(@PathVariable String id) {
        return menuConverter.toDto(
                menuService.getMenu(id)
        );
    }
}
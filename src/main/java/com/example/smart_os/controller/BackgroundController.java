package com.example.smart_os.controller;

import com.example.smart_os.converter.background.BackgroundConverter;
import com.example.smart_os.converter.user.UserConverter;
import com.example.smart_os.dto.background.AssignBackgroundRequest;
import com.example.smart_os.dto.background.BackgroundDto;
import com.example.smart_os.dto.background.CreateBackgroundRequest;
import com.example.smart_os.dto.user.UserDto;
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
    private final UserConverter userConverter;

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

    @PutMapping("/assignToUser")
    public UserDto assignToUser(@RequestBody AssignBackgroundRequest req) {

        return userConverter.toDto(
                backgroundService.assignToUser(req)
        );
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        backgroundService.delete(id);
    }
}

package com.example.smart_os.controller;

import com.example.smart_os.converter.user.UserConverter;
import com.example.smart_os.dto.user.CreateUserRequest;
import com.example.smart_os.dto.user.UpdateUserRequest;
import com.example.smart_os.dto.user.UserDto;
import com.example.smart_os.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping("/create")
    public UserDto create(@RequestBody CreateUserRequest request) {
        return userConverter.toDto(
                userService.createUser(request)
        );
    }

    @PutMapping("/update/{id}")
    public UserDto update(@RequestBody UpdateUserRequest req) {
        return userConverter.toDto(userService.update(req));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @GetMapping("/getAll")
    public List<UserDto> getAll() {
        return userService.getAll()
                .stream()
                .map(userConverter::toDto)
                .toList();
    }
}

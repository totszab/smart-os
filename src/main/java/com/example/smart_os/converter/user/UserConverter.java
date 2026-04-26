package com.example.smart_os.converter.user;

import com.example.smart_os.dto.user.UserDto;
import com.example.smart_os.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getGroups().getId(),
                user.getTheme() != null ? user.getTheme().getName() : null,
                user.getBackground() != null ? user.getBackground().getName() : null,
                user.getMenu() != null ? user.getMenu().getName() : null
        );
    }
}

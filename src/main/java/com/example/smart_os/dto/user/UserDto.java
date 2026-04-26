package com.example.smart_os.dto.user;

public record UserDto(
        String id,
        String name,
        String groupId,

        String themeName,
        String backgroundName,
        String menuName
) {
}

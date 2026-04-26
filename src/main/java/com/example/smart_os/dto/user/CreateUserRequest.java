package com.example.smart_os.dto.user;

public record CreateUserRequest(
        String name,
        String groupId
) {
}

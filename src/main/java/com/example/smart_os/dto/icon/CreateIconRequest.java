package com.example.smart_os.dto.icon;

public record CreateIconRequest(
        String name,
        int position,
        String menuId,
        String applicationId
) {
}

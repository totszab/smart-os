package com.example.smart_os.dto.icon;

import com.example.smart_os.model.entity.Application;

public record IconDto(
        String id,
        String name,
        int position,
        Application applicationName
) {
}

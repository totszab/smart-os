package com.example.smart_os.dto.menu;

import com.example.smart_os.dto.icon.IconDto;

import java.util.List;

public record MenuDto(
        String id,
        String name,
        List<IconDto> icons
) {
}

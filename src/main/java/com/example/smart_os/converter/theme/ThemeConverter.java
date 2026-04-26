package com.example.smart_os.converter.theme;

import com.example.smart_os.dto.theme.ThemeDto;
import com.example.smart_os.model.entity.Theme;
import org.springframework.stereotype.Component;

@Component
public class ThemeConverter {

    public ThemeDto toDto(Theme theme) {
        return new ThemeDto(
                theme.getId(),
                theme.getName()
        );
    }
}

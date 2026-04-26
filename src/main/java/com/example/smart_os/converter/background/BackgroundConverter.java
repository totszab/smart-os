package com.example.smart_os.converter.background;

import com.example.smart_os.dto.background.BackgroundDto;
import com.example.smart_os.model.entity.Background;
import org.springframework.stereotype.Component;

@Component
public class BackgroundConverter {

    public BackgroundDto toDto(Background background) {
        return new BackgroundDto(
                background.getId(),
                background.getName()
        );
    }
}
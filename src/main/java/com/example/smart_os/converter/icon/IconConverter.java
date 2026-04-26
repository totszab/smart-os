package com.example.smart_os.converter.icon;

import com.example.smart_os.dto.icon.IconDto;
import com.example.smart_os.model.entity.Icon;
import org.springframework.stereotype.Component;

@Component
public class IconConverter {

    public IconDto toDto(Icon icon) {
        return new IconDto(
                icon.getId(),
                icon.getName(),
                icon.getPosition(),
                icon.getApplication()
        );
    }
}

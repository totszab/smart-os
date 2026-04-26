package com.example.smart_os.converter.menu;

import com.example.smart_os.dto.icon.IconDto;
import com.example.smart_os.dto.menu.MenuDto;
import com.example.smart_os.model.entity.Menu;
import org.springframework.stereotype.Component;

@Component
public class MenuConverter {
    public MenuDto toDto(Menu menu) {
        return new MenuDto(
                menu.getId(),
                menu.getName(),
                menu.getIcons().stream()
                        .map(icon -> new IconDto(
                                icon.getId(),
                                icon.getName(),
                                icon.getPosition(),
                                icon.getApplication()
                        ))
                        .toList()
        );
    }
}

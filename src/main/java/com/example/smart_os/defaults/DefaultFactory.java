package com.example.smart_os.defaults;

import com.example.smart_os.model.entity.Background;
import com.example.smart_os.model.entity.Menu;
import com.example.smart_os.model.entity.Theme;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultFactory {

    public Theme defaultTheme() {
        Theme t = new Theme();
        t.setId(UUID.randomUUID().toString());
        t.setName("DEFAULT_THEME");
        return t;
    }

    public Background defaultBackground() {
        Background b = new Background();
        b.setId(UUID.randomUUID().toString());
        b.setName("DEFAULT_BACKGROUND");
        return b;
    }

    public Menu defaultMenu() {
        Menu m = new Menu();
        m.setId(UUID.randomUUID().toString());
        m.setName("DEFAULT_MENU");
        return m;
    }
}

package com.example.smart_os.defaults;

import com.example.smart_os.model.entity.*;
import com.example.smart_os.model.enums.ApplicationType;
import com.example.smart_os.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final GroupRepository groupRepository;
    private final PartnerRepository partnerRepository;
    private final MenuRepository menuRepository;
    private final IconRepository iconRepository;
    private final ApplicationRepository applicationRepository;
    private final BackgroundRepository backgroundRepository;
    private final ThemeRepository themeRepository;

    @Bean
    @Transactional
    CommandLineRunner init() {
        return args -> {

            Groups group = groupRepository.findById("DUMMY_MY_GROUP")
                    .orElseGet(() -> {
                        Groups g = new Groups();
                        g.setId("DUMMY_MY_GROUP");
                        g.setName("Interview");
                        return groupRepository.save(g);
                    });

            Background bg = backgroundRepository.findById("DUMMY_MY_BACKGROUND")
                    .orElseGet(() -> {
                        Background b = new Background();
                        b.setId("DUMMY_MY_BACKGROUND");
                        b.setName("Ocean");
                        return backgroundRepository.save(b);
                    });

            Theme theme = themeRepository.findById("DUMMY_MY_THEME")
                    .orElseGet(() -> {
                        Theme t = new Theme();
                        t.setId("DUMMY_MY_THEME");
                        t.setName("Light");
                        return themeRepository.save(t);
                    });

            Application chrome = getOrCreateApp("Chrome", ApplicationType.UTILITY);
            Application youtube = getOrCreateApp("Youtube", ApplicationType.ENTERTAINMENT);
            Application paint = getOrCreateApp("Paint", ApplicationType.MEDIA);
            Application contacts = getOrCreateApp("Contacts", ApplicationType.SYSTEM);

            Partner partner = partnerRepository.findById("DUMMY_MY_USER")
                    .orElseGet(() -> {

                        Menu menu = new Menu();
                        menu.setId("DUMMY_MY_MENU");
                        menu.setName("Homepage");
                        menuRepository.save(menu);

                        List<Icon> icons = List.of(
                                createIcon("Chrome", 0, chrome, menu),
                                createIcon("Youtube", 1, youtube, menu),
                                createIcon("Paint", 2, paint, menu),
                                createIcon("Contacts", 3, contacts, menu)
                        );

                        iconRepository.saveAll(icons);
                        menu.setIcons(icons);
                        menuRepository.save(menu);

                        Partner u = new Partner();
                        u.setId("DUMMY_MY_USER");
                        u.setName("Toth Szabolcs");
                        u.setGroups(group);
                        u.setMenu(menu);
                        u.setBackground(bg);
                        u.setTheme(theme);

                        return partnerRepository.save(u);
                    });

            System.out.println("A saját felhasználóm elkészült.");
        };
    }

    private Application getOrCreateApp(String name, ApplicationType type) {
        return applicationRepository.findById("DUMMY_MY_" + name.toUpperCase())
                .orElseGet(() -> {
                    Application app = new Application();
                    app.setId("DUMMY_MY_" + name.toUpperCase());
                    app.setName(name);
                    app.setType(type);
                    return applicationRepository.save(app);
                });
    }

    private Icon createIcon(String name, int position, Application app, Menu menu) {
        Icon icon = new Icon();
        icon.setId("DUMMY_MY_ICON_" + name.toUpperCase());
        icon.setName(name);
        icon.setPosition(position);
        icon.setApplication(app);
        icon.setMenu(menu);
        return icon;
    }
}
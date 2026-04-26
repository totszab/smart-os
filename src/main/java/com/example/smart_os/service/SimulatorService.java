package com.example.smart_os.service;

import com.example.smart_os.model.entity.*;
import com.example.smart_os.model.enums.ApplicationType;
import com.example.smart_os.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimulatorService {

    private final GroupRepository groupRepository;
    private final PartnerRepository partnerRepository;
    private final ApplicationRepository applicationRepository;
    private final MenuRepository menuRepository;
    private final IconRepository iconRepository;
    private final BackgroundRepository backgroundRepository;
    private final ThemeRepository themeRepository;

    @Transactional
    public void loadData() {

        if (groupRepository.existsById("SIMULATION_GROUP")) {
            return;
        }

        Groups group = new Groups();
        group.setId("SIMULATION_GROUP");
        group.setName("My Family");
        groupRepository.save(group);

        Application chrome = getOrCreateApp("Chrome", ApplicationType.UTILITY);
        Application youtube = getOrCreateApp("Youtube", ApplicationType.ENTERTAINMENT);
        Application paint = getOrCreateApp("Paint", ApplicationType.MEDIA);
        Application contacts = getOrCreateApp("Contacts", ApplicationType.SYSTEM);

        applicationRepository.saveAll(List.of(chrome, youtube, paint, contacts));

        Background bg = new Background();
        bg.setId("SIMULATION_BACKGROUND");
        bg.setName("Default Background");
        backgroundRepository.save(bg);

        Theme theme = new Theme();
        theme.setId("SIMULATION_THEME");
        theme.setName("Dark");
        themeRepository.save(theme);

        Menu menu = new Menu();
        menu.setId("SIMULATION_MENU_1");
        menu.setName("Main menu");
        menuRepository.save(menu);

        List<Icon> icons = List.of(
                createIcon("Chrome", 0, chrome, menu),
                createIcon("Youtube", 1, youtube, menu),
                createIcon("Paint", 2, paint, menu),
                createIcon("Contacts", 3, contacts, menu)
        );

        iconRepository.saveAll(icons);

        Partner partner = new Partner();
        partner.setId("SIMULATION_PARTNER_1");
        partner.setName("Szimuláló Szilárd");
        partner.setGroups(group);
        partner.setMenu(menu);
        partner.setBackground(bg);
        partner.setTheme(theme);

        partnerRepository.save(partner);
    }

    private Application getOrCreateApp(String name, ApplicationType type) {
        return applicationRepository.findById("SIMULATION" + name.toUpperCase())
                .orElseGet(() -> {
                    Application app = new Application();
                    app.setId("SIMULATION" + name.toUpperCase());
                    app.setName(name);
                    app.setType(type);
                    return applicationRepository.save(app);
                });
    }

    private Icon createIcon(String name, int position, Application app, Menu menu) {
        Icon icon = new Icon();
        icon.setId("SIMULATION" + name.toUpperCase());
        icon.setName(name);
        icon.setPosition(position);
        icon.setApplication(app);
        icon.setMenu(menu);
        return icon;
    }
}

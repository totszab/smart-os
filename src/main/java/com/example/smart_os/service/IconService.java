package com.example.smart_os.service;

import com.example.smart_os.dto.icon.CreateIconRequest;
import com.example.smart_os.dto.icon.UpdateIconRequest;
import com.example.smart_os.model.entity.Application;
import com.example.smart_os.model.entity.Icon;
import com.example.smart_os.model.entity.Menu;
import com.example.smart_os.repository.ApplicationRepository;
import com.example.smart_os.repository.IconRepository;
import com.example.smart_os.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IconService {

    private final IconRepository iconRepository;
    private final MenuRepository menuRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public Icon createIcon(CreateIconRequest request) {
        Menu menu = menuRepository.findById(request.menuId()).orElseThrow();
        Application app = applicationRepository.findById(request.applicationId()).orElseThrow();

        Icon icon = new Icon();
        icon.setId(UUID.randomUUID().toString());
        icon.setName(request.name());
        icon.setPosition(request.position());
        icon.setMenu(menu);
        icon.setApplication(app);

        return iconRepository.save(icon);
    }

    @Transactional
    public Icon update(UpdateIconRequest req) {

        Icon icon = iconRepository.findById(req.id())
                .orElseThrow(() -> new RuntimeException("Icon not found"));

        if (req.name() != null) {
            icon.setName(req.name());
        }

        if (req.positon() != null) {
            icon.setPosition(req.positon());
        }

        if (req.applicationId() != null) {
            Application app = applicationRepository.findById(req.applicationId())
                    .orElseThrow(() -> new RuntimeException("Application not found"));
            icon.setApplication(app);
        }

        return iconRepository.save(icon);
    }

    @Transactional
    public void delete(String id) {
        if (!iconRepository.existsById(id)) {
            throw new RuntimeException("Icon not found");
        }

        iconRepository.deleteById(id);
    }

    public List<Icon> getAll() {
        return iconRepository.findAll();
    }
}

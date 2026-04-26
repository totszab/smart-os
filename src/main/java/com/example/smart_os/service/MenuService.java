package com.example.smart_os.service;

import com.example.smart_os.dto.menu.CreateMenuRequest;
import com.example.smart_os.dto.menu.UpdateMenuRequest;
import com.example.smart_os.model.entity.Menu;
import com.example.smart_os.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    public Menu createMenu(CreateMenuRequest request) {
        Menu menu = new Menu();
        menu.setId(UUID.randomUUID().toString());
        menu.setName(request.name());

        return menuRepository.save(menu);
    }

    @Transactional
    public Menu update(UpdateMenuRequest req) {
        Menu menu = menuRepository.findById(req.id())
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        menu.setName(req.name());

        return menuRepository.save(menu);
    }

    @Transactional
    public void delete(String id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Menu not found");
        }

        menuRepository.deleteById(id);
    }

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Menu getMenu(String id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
    }
}

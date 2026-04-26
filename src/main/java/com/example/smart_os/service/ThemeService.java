package com.example.smart_os.service;

import com.example.smart_os.dto.theme.AssignThemeRequest;
import com.example.smart_os.dto.theme.CreateThemeRequest;
import com.example.smart_os.model.entity.Theme;
import com.example.smart_os.model.entity.User;
import com.example.smart_os.repository.ThemeRepository;
import com.example.smart_os.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final UserRepository userRepository;

    @Transactional
    public Theme create(CreateThemeRequest req) {

        Theme theme = new Theme();
        theme.setId(UUID.randomUUID().toString());
        theme.setName(req.name());

        return themeRepository.save(theme);
    }

    public List<Theme> getAll() {
        return themeRepository.findAll();
    }

    @Transactional
    public User assignToUser(AssignThemeRequest request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Theme theme = themeRepository.findById(request.themeId())
                .orElseThrow(() -> new RuntimeException("Theme not found"));

        user.setTheme(theme);

        return userRepository.save(user);
    }

    @Transactional
    public void delete(String id) {
        if (!themeRepository.existsById(id)) {
            throw new RuntimeException("Theme not found");
        }

        themeRepository.deleteById(id);
    }
}
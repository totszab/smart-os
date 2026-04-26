package com.example.smart_os.service;

import com.example.smart_os.dto.theme.AssignThemeRequest;
import com.example.smart_os.dto.theme.CreateThemeRequest;
import com.example.smart_os.model.entity.Partner;
import com.example.smart_os.model.entity.Theme;
import com.example.smart_os.repository.ThemeRepository;
import com.example.smart_os.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final PartnerRepository partnerRepository;

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
    public Partner assignToPartner(AssignThemeRequest request) {

        Partner partner = partnerRepository.findById(request.partnerId())
                .orElseThrow(() -> new RuntimeException("Partner not found"));

        Theme theme = themeRepository.findById(request.themeId())
                .orElseThrow(() -> new RuntimeException("Theme not found"));

        partner.setTheme(theme);

        return partnerRepository.save(partner);
    }

    @Transactional
    public void delete(String id) {
        if (!themeRepository.existsById(id)) {
            throw new RuntimeException("Theme not found");
        }

        themeRepository.deleteById(id);
    }
}
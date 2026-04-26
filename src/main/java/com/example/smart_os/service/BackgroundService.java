package com.example.smart_os.service;

import com.example.smart_os.dto.background.AssignBackgroundRequest;
import com.example.smart_os.dto.background.CreateBackgroundRequest;
import com.example.smart_os.model.entity.Background;
import com.example.smart_os.model.entity.Partner;
import com.example.smart_os.repository.BackgroundRepository;
import com.example.smart_os.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BackgroundService {

    private final BackgroundRepository backgroundRepository;
    private final PartnerRepository partnerRepository;

    @Transactional
    public Background create(CreateBackgroundRequest req) {
        Background bg = new Background();
        bg.setId(UUID.randomUUID().toString());
        bg.setName(req.name());

        return backgroundRepository.save(bg);
    }

    public List<Background> getAll() {
        return backgroundRepository.findAll();
    }

    @Transactional
    public Partner assignToPartner(AssignBackgroundRequest req) {
        Partner partner = partnerRepository.findById(req.partnerId())
                .orElseThrow(() -> new RuntimeException("Partner not found"));

        Background bg = backgroundRepository.findById(req.backgroundId())
                .orElseThrow(() -> new RuntimeException("Background not found"));

        partner.setBackground(bg);

        return partnerRepository.save(partner);
    }

    @Transactional
    public void delete(String id) {
        if (!backgroundRepository.existsById(id)) {
            throw new RuntimeException("Background not found");
        }

        backgroundRepository.deleteById(id);
    }
}

package com.example.smart_os.service;

import com.example.smart_os.defaults.DefaultFactory;
import com.example.smart_os.dto.partner.CreatePartnerRequest;
import com.example.smart_os.dto.partner.UpdatePartnerRequest;
import com.example.smart_os.model.entity.Groups;
import com.example.smart_os.model.entity.Partner;
import com.example.smart_os.repository.GroupRepository;
import com.example.smart_os.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PartnerService {

    private final PartnerRepository partnerRepository;
    private final GroupRepository groupRepository;
    private final DefaultFactory defaultFactory;

    @Transactional
    public Partner createPartner(CreatePartnerRequest req) {

        Groups groups = groupRepository.findById(req.groupId())
                .orElseThrow();

        Partner partner = new Partner();
        partner.setId(UUID.randomUUID().toString());
        partner.setName(req.name());
        partner.setGroups(groups);

        partner.setTheme(defaultFactory.defaultTheme());
        partner.setBackground(defaultFactory.defaultBackground());
        partner.setMenu(defaultFactory.defaultMenu());

        return partnerRepository.save(partner);
    }

    @Transactional
    public Partner update(UpdatePartnerRequest dto) {

        Partner partner = partnerRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("Partner not found"));

        partner.setName(dto.name());

        return partnerRepository.save(partner);
    }

    @Transactional
    public void delete(String id) {

        if (!partnerRepository.existsById(id)) {
            throw new RuntimeException("Partner not found");
        }

        partnerRepository.deleteById(id);
    }

    public List<Partner> getAll() {
        return partnerRepository.findAll();
    }
}

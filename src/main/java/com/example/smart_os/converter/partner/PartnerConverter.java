package com.example.smart_os.converter.partner;

import com.example.smart_os.dto.partner.PartnerDto;
import com.example.smart_os.model.entity.Partner;
import org.springframework.stereotype.Component;

@Component
public class PartnerConverter {
    public PartnerDto toDto(Partner partner) {
        return new PartnerDto(
                partner.getId(),
                partner.getName(),
                partner.getGroups().getId(),
                partner.getTheme() != null ? partner.getTheme().getName() : null,
                partner.getBackground() != null ? partner.getBackground().getName() : null,
                partner.getMenu() != null ? partner.getMenu().getName() : null
        );
    }
}

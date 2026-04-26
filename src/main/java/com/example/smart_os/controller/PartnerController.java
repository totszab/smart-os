package com.example.smart_os.controller;

import com.example.smart_os.converter.partner.PartnerConverter;
import com.example.smart_os.dto.partner.CreatePartnerRequest;
import com.example.smart_os.dto.partner.UpdatePartnerRequest;
import com.example.smart_os.dto.partner.PartnerDto;
import com.example.smart_os.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;
    private final PartnerConverter partnerConverter;

    @PostMapping("/create")
    public PartnerDto create(@RequestBody CreatePartnerRequest request) {
        return partnerConverter.toDto(
                partnerService.createPartner(request)
        );
    }

    @PutMapping("/update/{id}")
    public PartnerDto update(@RequestBody UpdatePartnerRequest req) {
        return partnerConverter.toDto(partnerService.update(req));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        partnerService.delete(id);
    }

    @GetMapping("/getAll")
    public List<PartnerDto> getAll() {
        return partnerService.getAll()
                .stream()
                .map(partnerConverter::toDto)
                .toList();
    }
}

package com.example.smart_os.dto.icon;

public record UpdateIconRequest(
        String id,
        String name,
        Integer positon,
        String applicationId
) {
}

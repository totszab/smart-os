package com.example.smart_os.converter.application;

import com.example.smart_os.dto.application.ApplicationDto;
import com.example.smart_os.model.entity.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConverter {

    public ApplicationDto toDto(Application application) {
        return new ApplicationDto(
                application.getId(),
                application.getName(),
                application.getType().name()
        );
    }
}

package com.example.smart_os.service;

import com.example.smart_os.dto.application.CreateApplicationRequest;
import com.example.smart_os.dto.application.LaunchResponse;
import com.example.smart_os.model.entity.Application;
import com.example.smart_os.model.enums.ApplicationType;
import com.example.smart_os.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Transactional
    public Application createApplication(CreateApplicationRequest request) {
        Application app = new Application();
        app.setId(UUID.randomUUID().toString());
        app.setName(request.name());
        app.setType(ApplicationType.valueOf(request.type()));

        return applicationRepository.save(app);
    }

    public LaunchResponse launch(String id) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        return new LaunchResponse(
                "Application " + app.getName() + " started"
        );
    }

    public List<Application> getAll() {
        return applicationRepository.findAll();
    }
}

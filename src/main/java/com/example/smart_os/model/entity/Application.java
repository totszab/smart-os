package com.example.smart_os.model.entity;

import com.example.smart_os.model.enums.ApplicationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application {

    @Id
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ApplicationType type;
}

package com.example.smart_os.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theme {

    @Id
    private String id;

    private String name;
}
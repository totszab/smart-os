package com.example.smart_os.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Icon {

    @Id
    private String id;

    private String name;

    private int position;

    @ManyToOne
    private Menu menu;

    @ManyToOne
    private Application application;
}

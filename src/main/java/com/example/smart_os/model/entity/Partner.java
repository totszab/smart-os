package com.example.smart_os.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Partner {

    @Id
    private String id;

    private String name;

    @ManyToOne
    private Groups groups;

    @OneToOne
    private Menu menu;

    @ManyToOne
    private Theme theme;

    @ManyToOne
    private Background background;
}
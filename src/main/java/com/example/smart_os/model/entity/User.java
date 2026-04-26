package com.example.smart_os.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    private String id;

    private String name;

    @ManyToOne
    private Groups groups;

    @OneToOne(cascade = CascadeType.ALL)
    private Menu menu;

    @ManyToOne(cascade = CascadeType.ALL)
    private Theme theme;

    @ManyToOne(cascade = CascadeType.ALL)
    private Background background;
}
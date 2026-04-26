package com.example.smart_os.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Menu {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Icon> icons = new ArrayList<>();
}

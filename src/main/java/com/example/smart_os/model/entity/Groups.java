package com.example.smart_os.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Groups {

    @Id
    private String id;

    private String name;

    @OneToMany(mappedBy = "groups")
    private List<Partner> partners = new ArrayList<>();
}
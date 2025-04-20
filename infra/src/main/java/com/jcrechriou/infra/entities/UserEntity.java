package com.jcrechriou.infra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class UserEntity {
    @Id
    private Long id;
    private String name;

    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

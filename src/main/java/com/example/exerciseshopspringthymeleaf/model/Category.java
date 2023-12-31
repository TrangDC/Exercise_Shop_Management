package com.example.exerciseshopspringthymeleaf.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ColumnDefault("true")
    private boolean isActive;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
        this.isActive = true;
    }

    public Category() {
        this.isActive = true;
    }

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

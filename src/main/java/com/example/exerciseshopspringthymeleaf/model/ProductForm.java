package com.example.exerciseshopspringthymeleaf.model;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {


    private Long id;

    @NotEmpty
    private String name;
    @NotNull
    private double price;
    private String description;


    private MultipartFile image;

    @ColumnDefault("1")
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    private Long quantity;

    @ColumnDefault("true")
    private boolean isActive;

    private Category category;

    public ProductForm() {
        this.quantity = 1L;
        this.isActive = true;
    }

    public ProductForm(String name, double price, String description, MultipartFile  image, Long quantity, boolean isActive, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.isActive = isActive;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile  image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

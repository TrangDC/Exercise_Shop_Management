package com.example.exerciseshopspringthymeleaf.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    @NotNull
    private double price;
    private String description;
    private String image;

    @ColumnDefault("1")
    private Long quantity;

    @ColumnDefault("true")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
        this.quantity = 1L;
        this.isActive = true;
    }

    public Product(String name, double price, String description, String image, Long quantity, boolean isActive, Category category) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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

    //trừ đi sản phẩm khi được thêm vào giỏ hàng
    public void decreaseQuantity(int quantityToDecrease) {
        System.out.println("Before decrease: " + quantity);
        if (quantityToDecrease > 0 && quantity >= quantityToDecrease) {
            quantity -= quantityToDecrease;
            System.out.println("After decrease: " + quantity);
        } else {
            System.out.println("Out of stock.");
        }
    }

    public void incrementQuantity(int quantityReturned) {
            quantity += quantityReturned;
    }
}

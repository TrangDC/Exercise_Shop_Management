package com.example.exerciseshopspringthymeleaf.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

    private String name;
    private double price;
    private String description;
    private MultipartFile imageFile;  // Trường đại diện cho tệp tin ảnh


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

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}

package com.example.exerciseshopspringthymeleaf.service;

import com.example.exerciseshopspringthymeleaf.model.Category;
import com.example.exerciseshopspringthymeleaf.model.Product;

public interface IProductService extends IGenerateService<Product> {
    public Iterable<Product> findByCategory(Category category);

    public Iterable<Product> searchByWord(String word);
}

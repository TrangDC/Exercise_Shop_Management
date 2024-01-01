package com.example.exerciseshopspringthymeleaf.service;

import com.example.exerciseshopspringthymeleaf.model.Category;
import com.example.exerciseshopspringthymeleaf.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGenerateService<Product> {
    public Iterable<Product> findByCategory(Category category);

    public Iterable<Product> searchByWord(String word);

    public Page<Product> searchByWord(String word, Pageable pageable);

    public Iterable<Product> sortPriceAscending();
    public Iterable<Product> sortPriceDescending();
}

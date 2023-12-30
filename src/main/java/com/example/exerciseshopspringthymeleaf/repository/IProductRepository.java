package com.example.exerciseshopspringthymeleaf.repository;

import com.example.exerciseshopspringthymeleaf.model.Category;
import com.example.exerciseshopspringthymeleaf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long> {
    public Iterable<Product> findAllByCategory(Category category);

}

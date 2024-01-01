package com.example.exerciseshopspringthymeleaf.repository;

import com.example.exerciseshopspringthymeleaf.model.Category;
import com.example.exerciseshopspringthymeleaf.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    public Iterable<Product> findAllByCategory(Category category);

    public Iterable<Product> findByNameContaining(String word);

    public Iterable<Product> findAllByOrderByPriceAsc();
    public Iterable<Product> findAllByOrderByPriceDesc();

    Page<Product> findAllByNameContaining(String word, Pageable pageable);
}

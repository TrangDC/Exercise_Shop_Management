package com.example.exerciseshopspringthymeleaf.repository;

import com.example.exerciseshopspringthymeleaf.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long>, PagingAndSortingRepository<Category, Long> {
}

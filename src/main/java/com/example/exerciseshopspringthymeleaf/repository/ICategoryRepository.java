package com.example.exerciseshopspringthymeleaf.repository;

import com.example.exerciseshopspringthymeleaf.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
}

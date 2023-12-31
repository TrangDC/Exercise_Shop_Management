package com.example.exerciseshopspringthymeleaf.service.impl;

import com.example.exerciseshopspringthymeleaf.model.Category;
import com.example.exerciseshopspringthymeleaf.model.Product;
import com.example.exerciseshopspringthymeleaf.repository.IProductRepository;
import com.example.exerciseshopspringthymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> searchByWord(String word) {
        return iProductRepository.findByNameContaining(word);
    }

    @Override
    public Iterable<Product> findByCategory(Category category) {
        return iProductRepository.findAllByCategory(category);
    }
}

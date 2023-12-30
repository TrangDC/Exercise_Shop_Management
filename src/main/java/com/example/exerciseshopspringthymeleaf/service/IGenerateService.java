package com.example.exerciseshopspringthymeleaf.service;

import java.util.Optional;

public interface IGenerateService<T> {
    public Iterable<T> findAll();
    public void save(T t);
    Optional<T> findById(Long id);
    public void remove(Long id);
}

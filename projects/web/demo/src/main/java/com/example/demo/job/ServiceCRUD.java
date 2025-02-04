package com.example.demo.job;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ServiceCRUD<T> {

    List<T> findAll();

    String create(T obj);

    ResponseEntity<T> findById(Long id);

    boolean deleteById(Long id);

}

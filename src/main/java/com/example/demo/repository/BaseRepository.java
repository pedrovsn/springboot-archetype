package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseRepository<T, ID> {

    T save(T t);

    T findById(ID id);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    Long count();

    void deleteById(ID id);
}

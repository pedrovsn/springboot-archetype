package com.example.demo.repository.impl;

import com.example.demo.domain.orm.Demo;
import com.example.demo.exception.DemoNotFoundException;
import com.example.demo.repository.DatabaseExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoRepositoryWithSQL implements DatabaseExternal<Demo, Long> {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public Demo save(Demo t) {
        return demoRepository.save(t);
    }

    @Override
    public Demo findById(Long id) {
        return demoRepository.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
    }

    @Override
    public List<Demo> findAll() {
        List<Demo> list = new ArrayList<>();
        demoRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Page<Demo> findAll(Pageable pageable) {
        return demoRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return demoRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        demoRepository.deleteById(id);
    }
}

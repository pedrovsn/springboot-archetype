package com.example.demo.repository;

import com.example.demo.model.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<Demo, Long> {

    Page<Demo> findAll(PageRequest pageRequest);
}

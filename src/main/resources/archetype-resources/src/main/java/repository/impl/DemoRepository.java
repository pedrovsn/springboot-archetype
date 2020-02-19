package ${package}.repository.impl;

import ${package}.domain.orm.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<Demo, Long> {

    Page<Demo> findAll(Pageable pageable);
}

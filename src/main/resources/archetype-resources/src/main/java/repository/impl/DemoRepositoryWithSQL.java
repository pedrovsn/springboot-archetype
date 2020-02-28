package ${groupId}.repository.impl;

import ${groupId}.domain.orm.Demo;
import ${groupId}.exception.DemoNotFoundException;
import ${groupId}.repository.DatabaseExternal;
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

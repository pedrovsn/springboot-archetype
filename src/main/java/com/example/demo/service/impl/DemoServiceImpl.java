package com.example.demo.service.impl;

import com.example.demo.domain.bean.ListResponseDTO;
import com.example.demo.domain.bean.PageRequestDTO;
import com.example.demo.domain.dto.DemoRequestDTO;
import com.example.demo.domain.dto.DemoResponseDTO;
import com.example.demo.domain.orm.Demo;
import com.example.demo.repository.DatabaseExternal;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    private DatabaseExternal<Demo, Long> demoRepository;

    @Autowired
    public DemoServiceImpl(DatabaseExternal<Demo, Long> demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public DemoResponseDTO save(DemoRequestDTO demoRequestDTO) {
        Demo demo = DemoRequestDTO.fromDTO(demoRequestDTO);
        return DemoResponseDTO.toDTO(demoRepository.save(demo));
    }

    @Override
    public DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO) {
        Demo demo = demoRepository.findById(id);
        demo.setDemo(demoRequestDTO.getDemo());

        Demo saved = demoRepository.save(demo);
        return DemoResponseDTO.toDTO(saved);
    }

    @Override
    public DemoResponseDTO findById(Long id) {
        Demo demo = demoRepository.findById(id);
        return DemoResponseDTO.toDTO(demo);
    }

    @Override
    public ListResponseDTO<DemoResponseDTO> findAll(PageRequestDTO<DemoRequestDTO> filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(Sort.Direction.DESC,
                filter.getOrderBy()));
        Page<Demo> all = demoRepository.findAll(pageRequest);

        ListResponseDTO<DemoResponseDTO> response = new ListResponseDTO<>();
        response.setTotalRegister(all.getTotalElements());

        return response;
    }

    @Override
    public void delete(Long id) {
        demoRepository.findById(id);
        demoRepository.deleteById(id);
    }
}

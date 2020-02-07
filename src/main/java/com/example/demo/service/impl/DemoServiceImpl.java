package com.example.demo.service.impl;

import com.example.demo.model.Demo;
import com.example.demo.model.dto.DemoRequestDTO;
import com.example.demo.model.dto.DemoResponseDTO;
import com.example.demo.model.dto.ListResponseDTO;
import com.example.demo.model.dto.PageRequestDTO;
import com.example.demo.repository.DemoRepository;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DemoServiceImpl implements DemoService {

    private DemoRepository demoRepository;

    @Autowired
    public DemoServiceImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public DemoResponseDTO save(DemoRequestDTO demoRequestDTO) {
        Demo demo = DemoRequestDTO.fromDTO(demoRequestDTO);
        return DemoResponseDTO.toDTO(demoRepository.save(demo));
    }

    @Override
    public DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO) {
        Demo demo = demoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        demo.setDemo(demoRequestDTO.getDemo());

        Demo saved = demoRepository.save(demo);
        return DemoResponseDTO.toDTO(saved);
    }

    @Override
    public DemoResponseDTO findById(Long id) {
        Demo demo = demoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return DemoResponseDTO.toDTO(demo);
    }

    @Override
    public ListResponseDTO<DemoResponseDTO> findAll(PageRequestDTO<DemoResponseDTO> filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(Sort.Direction.DESC,
                filter.getOrderBy()));
        Page<Demo> all = demoRepository.findAll(pageRequest);

        ListResponseDTO<DemoResponseDTO> response = new ListResponseDTO<>();
        response.setTotalRegister(all.getTotalElements());

        return response;
    }

    @Override
    public void delete(Long id) {
        demoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        demoRepository.deleteById(id);
    }
}

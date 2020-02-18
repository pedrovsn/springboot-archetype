package com.example.demo.service;

import com.example.demo.domain.dto.DemoRequestDTO;
import com.example.demo.domain.dto.DemoResponseDTO;
import com.example.demo.domain.bean.ListResponseDTO;
import com.example.demo.domain.bean.PageRequestDTO;

public interface DemoService {

    DemoResponseDTO save(DemoRequestDTO demoRequestDTO);
    DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO);
    DemoResponseDTO findById(Long id);
    ListResponseDTO<DemoResponseDTO> findAll(PageRequestDTO<DemoRequestDTO> filter);
    void delete(Long id);
}

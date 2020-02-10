package com.example.demo.service;

import com.example.demo.model.dto.DemoRequestDTO;
import com.example.demo.model.dto.DemoResponseDTO;
import com.example.demo.model.dto.ListResponseDTO;
import com.example.demo.model.dto.PageRequestDTO;

public interface DemoService {

    DemoResponseDTO save(DemoRequestDTO demoRequestDTO);
    DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO);
    DemoResponseDTO findById(Long id);
    ListResponseDTO<DemoResponseDTO> findAll(PageRequestDTO<DemoRequestDTO> filter);
    void delete(Long id);
}

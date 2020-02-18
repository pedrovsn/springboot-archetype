package ${groupId}.${artifactId}.service;

import ${groupId}.${artifactId}.domain.dto.DemoRequestDTO;
import ${groupId}.${artifactId}.domain.dto.DemoResponseDTO;
import ${groupId}.${artifactId}.domain.bean.ListResponseDTO;
import ${groupId}.${artifactId}.domain.bean.PageRequestDTO;

public interface DemoService {

    DemoResponseDTO save(DemoRequestDTO demoRequestDTO);
    DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO);
    DemoResponseDTO findById(Long id);
    ListResponseDTO<DemoResponseDTO> findAll(PageRequestDTO<DemoRequestDTO> filter);
    void delete(Long id);
}

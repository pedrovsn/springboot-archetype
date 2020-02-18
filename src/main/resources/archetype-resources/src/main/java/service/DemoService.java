package ${groupId}.${artifactId}.service;

import ${groupId}.${artifactId}.domain.dto.DemoRequestDTO;
import ${groupId}.${artifactId}.domain.dto.DemoResponseDTO;
import ${groupId}.${artifactId}.domain.bean.ListResponse;
import ${groupId}.${artifactId}.domain.bean.PageRequest;

public interface DemoService {

    DemoResponseDTO save(DemoRequestDTO demoRequestDTO);
    DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO);
    DemoResponseDTO findById(Long id);
    ListResponse<DemoResponseDTO> findAll(PageRequest<DemoRequestDTO> filter);
    void delete(Long id);
}

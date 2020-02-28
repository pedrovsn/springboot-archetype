package ${groupId}.service;

import ${groupId}.domain.dto.DemoRequestDTO;
import ${groupId}.domain.dto.DemoResponseDTO;
import ${groupId}.domain.bean.ListResponse;
import ${groupId}.domain.bean.PagedRequest;

public interface DemoService {

    DemoResponseDTO save(DemoRequestDTO demoRequestDTO);
    DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO);
    DemoResponseDTO findById(Long id);
    ListResponse<DemoResponseDTO> findAll(PagedRequest<DemoRequestDTO> filter);
    void delete(Long id);
}

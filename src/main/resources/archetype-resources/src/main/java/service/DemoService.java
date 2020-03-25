package ${package}.service;

import ${package}.domain.dto.DemoRequestDTO;
import ${package}.domain.dto.DemoResponseDTO;
import ${package}.domain.bean.ListResponse;
import ${package}.domain.bean.PagedRequest;

public interface DemoService {

    DemoResponseDTO save(DemoRequestDTO demoRequestDTO);
    DemoResponseDTO update(Long id, DemoRequestDTO demoRequestDTO);
    DemoResponseDTO findById(Long id);
    ListResponse<DemoResponseDTO> findAll(PagedRequest<DemoRequestDTO> filter);
    void delete(Long id);
}

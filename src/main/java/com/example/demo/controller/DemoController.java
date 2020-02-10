package com.example.demo.controller;

import com.example.demo.model.dto.DemoRequestDTO;
import com.example.demo.model.dto.DemoResponseDTO;
import com.example.demo.model.dto.ListResponseDTO;
import com.example.demo.model.dto.PageRequestDTO;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/demos")
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/")
    public ResponseEntity<DemoResponseDTO> createDemo(DemoRequestDTO demo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(demoService.save(demo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemoResponseDTO> updateDemo(@PathVariable("id") Long id, DemoRequestDTO demo) {
        return ResponseEntity.status(HttpStatus.OK).body(demoService.update(id, demo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeDemo(@PathVariable("id") Long id) {
        demoService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemoResponseDTO> findOneDemo(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(demoService.findById(id));
    }

    @GetMapping("/")
    public ListResponseDTO<DemoResponseDTO> findAllByFilters(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("orderBy") String orderBy, @RequestParam("desc") boolean desc) {
        PageRequestDTO<DemoRequestDTO> pageRequestDTO = new PageRequestDTO<>();
        pageRequestDTO.setPage(page);
        pageRequestDTO.setPageSize(pageSize);
        pageRequestDTO.setOrderBy(orderBy);
        pageRequestDTO.setDesc(desc);

        return demoService.findAll(pageRequestDTO);
    }
}

package ${package}.controller;

import ${package}.domain.dto.DemoRequestDTO;
import ${package}.domain.dto.DemoResponseDTO;
import ${package}.domain.bean.ListResponse;
import ${package}.domain.bean.PageRequest;
import ${package}.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demos")
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public DemoResponseDTO createDemo(DemoRequestDTO demo) {
        return demoService.save(demo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DemoResponseDTO updateDemo(@PathVariable("id") Long id, DemoRequestDTO demo) {
        return demoService.update(id, demo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeDemo(@PathVariable("id") Long id) {
        demoService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DemoResponseDTO findOneDemo(Long id) {
        return demoService.findById(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<DemoResponseDTO> findAllByFilters(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("orderBy") String orderBy, @RequestParam("desc") boolean desc) {
        PageRequest<DemoRequestDTO> pageRequest = new PageRequest<>();
        pageRequest.setPage(page);
        pageRequest.setPageSize(pageSize);
        pageRequest.setOrderBy(orderBy);
        pageRequest.setDesc(desc);

        return demoService.findAll(pageRequest);
    }
}

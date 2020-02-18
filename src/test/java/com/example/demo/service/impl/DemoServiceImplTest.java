package com.example.demo.service.impl;

import com.example.demo.domain.bean.ListResponseDTO;
import com.example.demo.domain.bean.PageRequestDTO;
import com.example.demo.domain.dto.DemoRequestDTO;
import com.example.demo.domain.dto.DemoResponseDTO;
import com.example.demo.domain.orm.Demo;
import com.example.demo.repository.DatabaseExternal;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DemoServiceImplTest {

    @Mock
    DatabaseExternal<Demo, Long> demoRepository;

    @InjectMocks
    DemoService demoService = new DemoServiceImpl(demoRepository);

    private static final Long DEFAULT_ID = 1L;

    Demo demo;

    DemoRequestDTO demoRequestDTO;

    DemoResponseDTO demoResponseDTO;

    @BeforeEach
    void setupMockTests() {
        demo = new Demo();
        demo.setId(DEFAULT_ID);
        demo.setDemo("example");

        demoRequestDTO = DemoRequestDTO.toDTO(demo);
        demoResponseDTO = DemoResponseDTO.toDTO(demo);
    }

    @DisplayName("Test Mock demoService + demoRepository - Save")
    @Test
    void testSaveDemo() {
        when(demoRepository.save(any(Demo.class)))
                .thenReturn(demo);

        DemoResponseDTO save = demoService.save(demoRequestDTO);
        assertThat(save.getId()).isEqualTo(1L);
    }

    @DisplayName("Test Mock demoService + demoRepository - Update")
    @Test
    void testUpdateDemo() {
        when(demoRepository.findById(eq(DEFAULT_ID)))
                .thenReturn(demo);

        Demo newDemo = new Demo();
        newDemo.setId(DEFAULT_ID);
        newDemo.setDemo("edited demo");

        when(demoRepository.save(eq(demo)))
                .thenReturn(newDemo);

        DemoRequestDTO newDemoRequestDTO = DemoRequestDTO.toDTO(newDemo);

        DemoResponseDTO update = demoService.update(DEFAULT_ID, newDemoRequestDTO);

        assertThat(update.getId()).isEqualTo(1L);
        assertThat(update.getDemo()).isEqualTo("edited demo");
    }

    @DisplayName("Test Mock demoService + demoRepository - Get One")
    @Test
    void testGetOne() {
        when(demoRepository.findById(eq(DEFAULT_ID)))
                .thenReturn(demo);

        DemoResponseDTO found = demoService.findById(DEFAULT_ID);
        assertThat(found.getId()).isEqualTo(1L);
    }

    @DisplayName("Test Mock demoService + demoRepository - Get All")
    @Test
    void testGetAll() {
        PageRequestDTO<DemoRequestDTO> pageRequestDTO = new PageRequestDTO<>();
        pageRequestDTO.setPageSize(10);
        pageRequestDTO.setPage(0);
        pageRequestDTO.setOrderBy("Id");
        pageRequestDTO.setDesc(Boolean.TRUE);

        Page<Demo> page = new PageImpl<Demo>(Arrays.asList(demo));

        when(demoRepository.findAll(any(PageRequest.class)))
                .thenReturn(page);

        ListResponseDTO<DemoResponseDTO> items = demoService.findAll(pageRequestDTO);
        assertThat(items.getTotalRegister()).isEqualTo(1L);
    }
}

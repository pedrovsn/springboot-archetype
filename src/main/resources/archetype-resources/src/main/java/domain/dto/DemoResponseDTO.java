package ${package}.domain.dto;

import ${package}.domain.orm.Demo;

public class DemoResponseDTO {

    private Long id;

    private String demo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    public String toString() {
        return "DemoResponse{" +
                "id=" + id +
                ", demo='" + demo + '\'' +
                '}';
    }

    public static DemoResponseDTO toDTO(Demo demo) {
        DemoResponseDTO demoResponseDTO = new DemoResponseDTO();
        demoResponseDTO.setId(demo.getId());
        demoResponseDTO.setDemo(demo.getDemo());

        return demoResponseDTO;
    }

    public static Demo fromDTO(DemoResponseDTO demoResponseDTO) {
        Demo demo = new Demo();
        demo.setId(demoResponseDTO.getId());
        demo.setDemo(demoResponseDTO.getDemo());

        return demo;
    }
}

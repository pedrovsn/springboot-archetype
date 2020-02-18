package ${groupId}.${artifactId}.domain.dto;

import ${groupId}.${artifactId}.domain.orm.Demo;

public class DemoRequestDTO {

    public String demo;

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    public String toString() {
        return "DemoRequest{" +
                "demo='" + demo + '\'' +
                '}';
    }

    public static DemoRequestDTO toDTO(Demo demo) {
        DemoRequestDTO demoRequestDTO = new DemoRequestDTO();
        demoRequestDTO.setDemo(demo.getDemo());

        return demoRequestDTO;
    }

    public static Demo fromDTO(DemoRequestDTO demoRequestDTO) {
        Demo demo = new Demo();
        demo.setDemo(demoRequestDTO.getDemo());

        return demo;
    }
}

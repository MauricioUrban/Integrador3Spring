package tpintegrador3.Service.DTO.Estudiante_Carrera;

import lombok.Data;

@Data
public class Estudiante_CarreraDTO {
    private Long idEstudiante;
    private Long idCarrera;
    private int year;
    private boolean graduado;

    public Estudiante_CarreraDTO(Long idEstudiante, Long idCarrera, int year, boolean graduado){
        this.idEstudiante= idEstudiante;
        this.idCarrera = idCarrera;
        this.year= year;
        this.graduado = graduado;
    }
}

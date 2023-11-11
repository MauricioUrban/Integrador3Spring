package tpintegrador3.Service.DTO.Estudiante_Carrera;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estudiante_CarreraDTO {

    @NotNull(message = "El id del estudiante es un campo obligatorio.")
    private Long idEstudiante;
    @NotNull(message = "El id de la carrera es un campo obligatorio.")
    private Long idCarrera;
    @NotNull(message = "El año es un campo obligatorio.")
    private int year;
    @NotNull(message = "El estado de graduado es un campo obligatorio.")
    private boolean graduado;

    public Estudiante_CarreraDTO(Long idEstudiante, Long idCarrera, int year, boolean graduado){
        this.idEstudiante= idEstudiante;
        this.idCarrera = idCarrera;
        this.year= year;
        this.graduado = graduado;
    }
}

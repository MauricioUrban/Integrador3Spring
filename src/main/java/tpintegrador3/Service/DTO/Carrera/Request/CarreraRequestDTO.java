package tpintegrador3.Service.DTO.Carrera.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class CarreraRequestDTO {
    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private String nombreCarrera;
    private Long cantEstudiante;
}

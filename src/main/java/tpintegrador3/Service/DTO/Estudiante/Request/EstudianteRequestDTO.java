package tpintegrador3.Service.DTO.Estudiante.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class EstudianteRequestDTO {
    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private String fullName;
    @NotNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")
    private int  nroDocumento, nroLibreta;

    private String genero, ciudadResidencia;
    private int edad;
}

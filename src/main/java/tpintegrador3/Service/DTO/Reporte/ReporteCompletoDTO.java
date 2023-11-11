package tpintegrador3.Service.DTO.Reporte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteCompletoDTO {
    @NotNull
    private String nombreCarrera;
    @NotNull
    private long cantidadEstudiantes;


    public ReporteCompletoDTO(String nombreCarrera, long cantidadEstudiantes) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

}

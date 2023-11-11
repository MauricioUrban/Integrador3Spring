package tpintegrador3.Service.DTO.Reporte;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReporteDTO {
    @NotNull
    private String nombreCarrera;
    private int antiguedad;
    @NotNull
    private long cantidadEstudiantes;
    private long cantidadGraduados;


    public ReporteDTO(String nombreCarrera, long cantidadEstudiantes) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public ReporteDTO(String nombreCarrera, int antiguedad, long cantidadEstudiantes, long cantidadGraduados) {
        this.nombreCarrera = nombreCarrera;
        this.antiguedad = antiguedad;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.cantidadGraduados = cantidadGraduados;
    }


}

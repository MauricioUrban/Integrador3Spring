package tpintegrador3.Service.DTO.Reporte;

import lombok.Data;

@Data
public class ReporteDTO {
    private String nombreCarrera;
//    private int antiguedad;
    private long cantidadEstudiantes;
//    private long cantidadGraduados;


//    public ReporteDTO(String nombreCarrera, int antiguedad, long cantidadEstudiantes, long cantidadGraduados) {
//        this.nombreCarrera = nombreCarrera;
//        this.antiguedad = antiguedad;
//        this.cantidadEstudiantes = cantidadEstudiantes;
//        this.cantidadGraduados = cantidadGraduados;
//    }

    public ReporteDTO(String nombreCarrera, long cantidadEstudiantes) {
        this.nombreCarrera = nombreCarrera;
        this.cantidadEstudiantes = cantidadEstudiantes;
    }
}

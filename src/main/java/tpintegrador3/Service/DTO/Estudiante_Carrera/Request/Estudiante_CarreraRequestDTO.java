package tpintegrador3.Service.DTO.Estudiante_Carrera.Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class Estudiante_CarreraRequestDTO {

        private String nombreCarrera;
        private int year;
        private long inscriptos;
        private long egresados;

        public Estudiante_CarreraRequestDTO() {
        }

        public Estudiante_CarreraRequestDTO(String nombreCarrera, int year, long inscriptos, long egresados) {
                this.nombreCarrera = nombreCarrera;
                this.year = year;
                this.inscriptos = inscriptos;
                this.egresados = egresados;
        }
}

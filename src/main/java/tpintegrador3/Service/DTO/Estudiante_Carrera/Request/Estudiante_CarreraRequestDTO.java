package tpintegrador3.Service.DTO.Estudiante_Carrera.Request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class Estudiante_CarreraRequestDTO {

        private Long idEstudiante;
        private Long idCarrera;
        private int year;
        private boolean graduado;

        public Estudiante_CarreraRequestDTO(Long idEstudiante, Long idCarrera, int year, boolean graduado){

                this.idEstudiante= idEstudiante;
                this.idCarrera = idCarrera;
                this.year= year;
                this.graduado = graduado;


        }

        public Estudiante_CarreraRequestDTO() {
        }

}

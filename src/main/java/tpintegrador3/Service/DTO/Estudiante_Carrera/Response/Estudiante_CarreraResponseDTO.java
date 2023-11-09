package tpintegrador3.Service.DTO.Estudiante_Carrera.Response;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import tpintegrador3.Entidades.Estudiante_Carrera;

@Data
@RequiredArgsConstructor
public class Estudiante_CarreraResponseDTO {

        private String nombreCarrera;
        private int year;
        private int inscriptos;
        private Long egresados;


        public Estudiante_CarreraResponseDTO( Estudiante_Carrera ec ) {
            this.nombreCarrera = ec.getCarrera().getNombreCarrera();
            this.year = ec.getAntiguedad();
            this.inscriptos = ec.getCarrera().getEstudianteCarrera().size();
            //  esto es para contar los egresados
            this.egresados = ec.getCarrera().getEstudianteCarrera().stream().filter(e -> e.isGraduado()).count();
        }

}

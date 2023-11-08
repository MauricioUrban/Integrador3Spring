package tpintegrador3.Service.DTO.Carrera.Response;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import tpintegrador3.Entidades.Carrera;

@Data
@RequiredArgsConstructor
public class CarreraResponseDTO {

    private String nombre;
    private int cantEstudiante;

    public CarreraResponseDTO(Carrera c){
        this.nombre = c.getNombreCarrera();
        this.cantEstudiante = c.getEstudianteCarrera().size();
    }


}

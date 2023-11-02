package tpintegrador3.Service.DTO;

import java.io.Serializable;

public class CarreraDTO implements Serializable {
   private String nombre;
   private Long cantEstudiante;

   public CarreraDTO(String nombre, Long cantEstudiante){
        this.nombre = nombre;
        this.cantEstudiante = cantEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getCantEstudiantes() {
        return cantEstudiante;
    }

    @Override
    public String toString() {
        return "nroEstudiantes: "+getCantEstudiantes()+" Carrera: "+ getNombre();
    }
}

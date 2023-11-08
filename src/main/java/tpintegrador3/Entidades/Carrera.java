package tpintegrador3.Entidades;


import jakarta.persistence.*;
import lombok.Data;
import tpintegrador3.Service.DTO.Carrera.Request.CarreraRequestDTO;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrera;
    @Column
    private String nombreCarrera;
    
    @OneToMany(mappedBy = "carrera", fetch = FetchType.EAGER)
    private List<Estudiante_Carrera> estudianteCarrera;

    public Carrera() {
        super();
    }

    public Carrera(CarreraRequestDTO request) {
        this.nombreCarrera = request.getNombre();
        this.estudianteCarrera = new LinkedList<>();
    }

    public void setNombre(String nombre) {
    }
}

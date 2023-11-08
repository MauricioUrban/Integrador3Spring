package tpintegrador3.Entidades;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Estudiante_Carrera implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumns({
            @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante"),
    })
    private Estudiante estudiante;


    @Id
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera")
    private Carrera carrera;
    
    private int antiguedad;
    private boolean graduado;

    public Estudiante_Carrera() {
        super();
    }

    public Estudiante_Carrera(Estudiante estudiante, Carrera carrera, int antiguedad, boolean graduado) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.antiguedad = antiguedad;
        this.graduado = graduado;
    }

}

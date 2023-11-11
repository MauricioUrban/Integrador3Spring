package tpintegrador3.Entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Data
@Getter
@Setter
@Table(name = "estudiante_carrera")
public class Estudiante_Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idEstudiante", referencedColumnName = "idEstudiante")
    private Estudiante estudiante;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCarrera", referencedColumnName = "idCarrera")
    private Carrera carrera;

    @Column
    private int antiguedad;
    @Column
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

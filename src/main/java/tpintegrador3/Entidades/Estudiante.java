
package tpintegrador3.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstudiante;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private String apellido;
    @Column
    private int edad;
    @Column
    private String genero;
    @Column(nullable=false)
    private int nroDocumento;
    @Column(nullable=false)
    private String ciudadResidencia;
    @Column(nullable=false)
    private int nroLibreta;

    @OneToMany(mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<Estudiante_Carrera> estudianteCarrera;

    public Estudiante(String nombre, String apellido, int edad, String genero, int nroDocumento, String ciudadResidencia, int nroLibreta) {
        //this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.nroDocumento = nroDocumento;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibreta = nroLibreta;
        //this.carreras = carreras;
    }

    public Estudiante() {

    }

    public Estudiante(EstudianteRequestDTO request) {
    }
}

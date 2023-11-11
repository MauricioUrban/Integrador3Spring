
package tpintegrador3.Entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstudiante;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private int edad;
    @Column
    private String genero;
    @Column
    private int nroDocumento;
    @Column
    private String ciudadResidencia;
    @Column
    private int nroLibreta;

    @OneToMany(mappedBy = "estudiante")
    private List<Estudiante_Carrera> inscripciones;


    public Estudiante(String nombre, String apellido, int edad, String genero, int nroDocumento, String ciudadResidencia, int nroLibreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.nroDocumento = nroDocumento;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibreta = nroLibreta;
        this.inscripciones = new LinkedList<>();
    }

    public Estudiante() {
        this.inscripciones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre+", "+apellido+"\n";
    }


}
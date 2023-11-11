
package tpintegrador3.Entidades;

import jakarta.persistence.*;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;
import lombok.Getter;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstudiante;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private int nroDocumento;
    private String ciudadResidencia;
    private int nroLibreta;

    @OneToMany(mappedBy = "estudiante")
    private List<Estudiante_Carrera> inscripciones;

    public Estudiante(String nombre, String apellido, int edad, String genero, int nroDocumento, String ciudadResidencia, int nroLibreta) {
        //this.idEstudiante = idEstudiante;
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
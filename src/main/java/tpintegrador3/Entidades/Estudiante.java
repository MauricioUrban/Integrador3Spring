
package tpintegrador3.Entidades;

import jakarta.persistence.*;
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


    public void addInscripcion(Estudiante_Carrera inscripcion){
        if(!inscripciones.contains(inscripcion)){
            inscripciones.add(inscripcion);
        }
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public void setNroLibreta(int nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCiudad(String ciudad) {
        this.ciudadResidencia = ciudad;
    }

    public void setInscripciones(List<Estudiante_Carrera> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return nombre+", "+apellido+"\n";
    }

//    public void setEstudianteId(EstudianteId estudianteId) {
//        this.estudianteId = estudianteId;
//    }
}
package tpintegrador3.Service.DTO.Estudiante;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import java.io.Serializable;

@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstudianteDTO implements Serializable {

    @NotNull(message = "El nombre es un campo obligatorio.")
    @NotEmpty(message = "El nombre es un campo obligatorio.")
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private int nroDocumento;
    private String ciudadResidencia;
    private int nroLibreta;


    public EstudianteDTO(String nombre, String apellido, int edad,
                         String genero, int nroDocumento,
                         String ciudadResidencia, int nroLibreta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.nroDocumento = nroDocumento;
        this.ciudadResidencia = ciudadResidencia;
        this.nroLibreta = nroLibreta;
    }

    @JsonCreator
    public EstudianteDTO() {
        // Constructor sin argumentos requerido por Json
    }

    public EstudianteDTO(String nombre) {
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", nroDocumento=" + nroDocumento +
                ", ciudadResidencia='" + ciudadResidencia + '\'' +
                ", nroLibreta=" + nroLibreta +
                '}';
    }
}
//public class EstudianteDTO {
//    private int nroDocumento,nroLibreta,edad;
//    private String nombre,apellido,genero,ciudadResidencia;
//
//    public EstudianteDTO(int dni, int libreta, int edad, String nombre, String apellido, String genero, String ciudad) {
//        this.nroDocumento = dni;
//        this.nroLibreta = libreta;
//        this.edad = edad;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.genero = genero;
//        this.ciudadResidencia = ciudad;
//    }
//
//    public int getNroDocumento() {
//        return nroDocumento;
//    }
//
//    public void setNroDocumento(int nroDocumento) {
//        this.nroDocumento = nroDocumento;
//    }
//
//    public int getNroLibreta() {
//        return nroLibreta;
//    }
//
//    public void setNroLibreta(int nroLibreta) {
//        this.nroLibreta = nroLibreta;
//    }
//
//    public int getEdad() {
//        return edad;
//    }
//
//    public void setEdad(int edad) {
//        this.edad = edad;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public String getGenero() {
//        return genero;
//    }
//
//    public void setGenero(String genero) {
//        this.genero = genero;
//    }
//
//    public String getCiudadResidencia() {
//        return ciudadResidencia;
//    }
//
//    public void setCiudadResidencia(String ciudadResidencia) {
//        this.ciudadResidencia = ciudadResidencia;
//    }
//
//    @Override
//    public String toString() {
//        return "EstudianteDTO{" +
//                "nroDocumento=" + nroDocumento +
//                ", nroLibreta=" + nroLibreta +
//                ", edad=" + edad +
//                ", nombre='" + nombre + '\'' +
//                ", apellido='" + apellido + '\'' +
//                ", genero='" + genero + '\'' +
//                ", ciudadResidencia='" + ciudadResidencia + '\'' +
//                '}';
//    }
//
//}

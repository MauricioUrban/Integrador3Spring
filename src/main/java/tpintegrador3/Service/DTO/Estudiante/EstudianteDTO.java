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

    public int getDni() {
        return this.nroDocumento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getNumeroLibreta() {
        return this.nroLibreta;
    }
}

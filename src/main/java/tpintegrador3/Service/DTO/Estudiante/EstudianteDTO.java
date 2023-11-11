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
    @NotNull(message = "El apellido es un campo obligatorio.")
    private String apellido;
    @NotNull(message = "La edad es un campo obligatorio.")
    private int edad;
    @NotNull(message = "El genero es un campo obligatorio.")
    private String genero;
    @NotNull(message = "El numero de documento es un campo obligatorio.")
    private int nroDocumento;
    @NotNull(message = "La ciudad de residencia es un campo obligatorio.")
    private String ciudadResidencia;
    @NotNull(message = "El numero de libreta es un campo obligatorio.")
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
    public EstudianteDTO() {    }



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

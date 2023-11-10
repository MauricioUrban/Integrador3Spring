package tpintegrador3.Service.DTO.Carrera;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import tpintegrador3.Entidades.Carrera;

import java.io.Serializable;

//@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarreraDTO implements Serializable {

    @NotNull(message = "El nombre es un campo obligatorio.")
    @NotEmpty(message = "El nombre es un campo obligatorio.")
    private String nombreCarrera;

   public CarreraDTO(String nombreCarrera) {
          this.nombreCarrera = nombreCarrera;
    }

    @JsonCreator
    public CarreraDTO() {
        // Constructor sin argumentos requerido por Jackson
    }

    @Override
    public String toString(){
        return "Nombre: " +nombreCarrera;
    }


}
package tpintegrador3.Service.DTO.Carrera;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarreraDTO implements Serializable {

    //@NotNull(message = "El nombre es un campo obligatorio.")
   // @NotEmpty(message = "El nombre es un campo obligatorio.")
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
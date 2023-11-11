package tpintegrador3.Service.DTO.Carrera;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarreraDTO implements Serializable {

    @NotNull
    private String nombreCarrera;

   public CarreraDTO(String nombreCarrera) {
          this.nombreCarrera = nombreCarrera;
    }

    @JsonCreator
    public CarreraDTO() {    }

    @Override
    public String toString(){
        return "Nombre: " +nombreCarrera;
    }


}
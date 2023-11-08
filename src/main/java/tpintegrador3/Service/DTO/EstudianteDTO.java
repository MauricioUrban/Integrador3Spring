package tpintegrador3.Service.DTO;

import java.io.Serializable;

public class EstudianteDTO implements Serializable {
    private String fullName, genero, ciudadResidencia;
    private int edad, nroDocumento, nroLibreta;

    public EstudianteDTO(String fullName, String genero, String ciudadResidencia, int edad, int nroDocumento, int nroLibreta) {
        this.fullName = fullName;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.edad = edad;
        this.nroDocumento = nroDocumento;
        this.nroLibreta = nroLibreta;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public int getEdad() {
        return edad;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public int getNroLibreta() {
        return nroLibreta;
    }

    @Override
    public String toString() {
        return String.format("%-42s %-10s %-30s %20d %20s %20s",
                fullName, genero, ciudadResidencia, edad, nroDocumento, nroLibreta);
    }
}

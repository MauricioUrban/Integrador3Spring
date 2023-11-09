package tpintegrador3.Entidades;

import java.io.Serializable;

public class EstudianteCarreraId implements Serializable {
    private Long estudiante;
    private Long carrera;

    // getters, setters y equals, hashCode si es necesario

    public EstudianteCarreraId() {
        super();
    }

    public EstudianteCarreraId(Long estudiante, Long carrera) {
        this.estudiante = estudiante;
        this.carrera = carrera;
    }

    public Long getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Long estudiante) {
        this.estudiante = estudiante;
    }


    public Long getCarrera() {
        return carrera;
    }

    public void setCarrera(Long carrera) {
        this.carrera = carrera;
    }




}
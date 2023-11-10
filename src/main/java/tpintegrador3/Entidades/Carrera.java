package tpintegrador3.Entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tpintegrador3.Service.DTO.Carrera.CarreraDTO;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "carrera")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarrera;
    @Column(name = "nombreCarrera")
    private String nombreCarrera;
    
    @OneToMany(mappedBy = "carrera", fetch = FetchType.EAGER)
    private List<Estudiante_Carrera> estudianteCarrera;

    public Carrera() {
        super();
    }

    public Carrera(long idCarrera, String nombreCarrera){
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
    }

    public Carrera(CarreraDTO request) {
        this.nombreCarrera = request.getNombreCarrera();
        this.estudianteCarrera = new LinkedList<>();
    }

   public void setNombre(String nombre) {
        this.nombreCarrera = nombre;
    }
}

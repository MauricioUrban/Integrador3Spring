package tpintegrador3.Entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
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


    public Carrera(int id, String nombre) {
        this.idCarrera = id;
        this.nombreCarrera = nombre;
    }

    public void setNombre(String nombre) {
        this.nombreCarrera = nombre;
    }
}

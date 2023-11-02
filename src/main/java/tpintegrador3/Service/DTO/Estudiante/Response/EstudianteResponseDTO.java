package tpintegrador3.Service.DTO.Estudiante.Response;



import lombok.Data;
import lombok.RequiredArgsConstructor;
import tpintegrador3.Entidades.Estudiante;

@Data
@RequiredArgsConstructor
public class EstudianteResponseDTO {
    private final String name;
    private final String lastName;
    private final String genero;
    private final String ciudadResidencia;
    private final int edad;
    private final int nroDocumento;
    private final int nroLibreta;


    public EstudianteResponseDTO( Estudiante e ) {
        this.name = e.getNombre();
        this.lastName = e.getApellido();
        this.genero = e.getGenero();
        this.ciudadResidencia = e.getCiudadResidencia();
        this.edad = e.getEdad();
        this.nroDocumento = e.getNroDocumento();
        this.nroLibreta = e.getNroLibreta();
    }


}

package tpintegrador3.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Service.DTO.Estudiante.Request.EstudianteRequestDTO;
import tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> findAll() {


        return this.estudianteRepository.findAll().stream().map(EstudianteResponseDTO::new).toList();


    }


    @Transactional(readOnly = true)
    public EstudianteResponseDTO findById(Long id) {

        return this.estudianteRepository.findById(id).map(EstudianteResponseDTO::new).orElse(null);


    }

    @Transactional
    public EstudianteResponseDTO save(EstudianteRequestDTO request) {
        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(estudiante);
        return new EstudianteResponseDTO(result.getNombre(), result.getApellido(), result.getGenero(), result.getCiudadResidencia(), result.getEdad(), result.getNroDocumento(), result.getNroLibreta());

    }

    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> findAllOrderByName() {

        return this.estudianteRepository.findAllOrderByName().stream().map(EstudianteResponseDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> findByGenero(String genero) {

        return this.estudianteRepository.findByGenero(genero).stream().map(EstudianteResponseDTO::new).toList();

    }

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    @Transactional(readOnly = true)
    public EstudianteResponseDTO findByNroLibreta(int nroLibreta) {

        return this.estudianteRepository.findByNroLibreta(nroLibreta).stream().map(EstudianteResponseDTO::new).findFirst().orElse(null) ;

    }
    //findEstudiantesByCarreraAndCiudad
    @Transactional(readOnly = true)
    public List<EstudianteResponseDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {

        return this.estudianteRepository.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia).stream().map(EstudianteResponseDTO::new).toList();

    }

    //b) matricular un estudiante en una carrera
    @Transactional
    public EstudianteResponseDTO matEstudianteCarrera(EstudianteRequestDTO request) {
        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(estudiante);
        return new EstudianteResponseDTO(result);

    }


}

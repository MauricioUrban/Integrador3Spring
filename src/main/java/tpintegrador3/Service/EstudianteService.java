package tpintegrador3.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Service.DTO.Carrera.CarreraDTO;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> findAllEstudiantes() {
        return estudianteRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Estudiante> findById(Long id) {

        return this.estudianteRepository.findById(id);


    }

//    @Transactional
//    public EstudianteDTO save(Estudiante request) {
//        final var estudiante = new Estudiante(request);
//        final var result = this.estudianteRepository.save(request);
//        return new EstudianteDTO(result.getNombre(), result.getApellido(), result.getGenero(), result.getCiudadResidencia(), result.getEdad(), result.getNroDocumento(), result.getNroLibreta());
//
//    }

    @Transactional
    public Estudiante save(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return estudiante;
    }



    @Transactional(readOnly = true)
    public List<EstudianteDTO> findAllOrderByName() {

        return this.estudianteRepository.findAllOrderByName();

    }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> findByGenero(String genero) {

        return this.estudianteRepository.findByGenero(genero);

    }

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    @Transactional(readOnly = true)
    public EstudianteDTO findByNroLibreta(int nroLibreta) {

        return this.estudianteRepository.findByNroLibreta(nroLibreta);

    }
    //findEstudiantesByCarreraAndCiudad
    @Transactional(readOnly = true)
    public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {

        return this.estudianteRepository.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia);

    }


    //b) matricular un estudiante en una carrera
//    @Transactional
//    public EstudianteDTO matEstudianteCarrera(EstudianteDTO request) {
//        final var estudiante = new Estudiante(request);
//        final var result = this.estudianteRepository.save(estudiante);
//        return new EstudianteDTO(result);
//
//    }


}

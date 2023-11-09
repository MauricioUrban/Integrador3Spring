package tpintegrador3.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Transactional(readOnly = true)
    public List<EstudianteDTO> findAllByOrderByDniDesc() {
        List<Estudiante> resultado = this.estudianteRepository.findAll();   //resultado de la query
        List<EstudianteDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (Estudiante estudiante : resultado) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getNroDocumento(), estudiante.getNombre(),
                    estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(),
                    estudiante.getCiudadResidencia(), estudiante.getNroLibreta());


            listaNueva.add(estudianteDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }


    @Transactional(readOnly = true)
    public EstudianteDTO findById(Long id) {

        return this.estudianteRepository.findById(id).map(EstudianteDTO::new).orElse(null);


    }

    @Transactional
    public EstudianteDTO save(Estudiante request) {
//        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(request);
        return new EstudianteDTO(result.getNombre(), result.getApellido(), result.getGenero(), result.getCiudadResidencia(), result.getEdad(), result.getNroDocumento(), result.getNroLibreta());

    }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> findAllOrderByName() {

        return this.estudianteRepository.findAllOrderByName().stream().map(EstudianteDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> findByGenero(String genero) {

        return this.estudianteRepository.findByGenero(genero).stream().map(EstudianteDTO::new).toList();

    }

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    @Transactional(readOnly = true)
    public EstudianteDTO findByNroLibreta(int nroLibreta) {

        return this.estudianteRepository.findByNroLibreta(nroLibreta).stream().map(EstudianteDTO::new).findFirst().orElse(null) ;

    }
    //findEstudiantesByCarreraAndCiudad
    @Transactional(readOnly = true)
    public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {

        return this.estudianteRepository.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia).stream().map(EstudianteDTO::new).toList();

    }

    //b) matricular un estudiante en una carrera
    @Transactional
    public EstudianteDTO matEstudianteCarrera(EstudianteRequestDTO request) {
        final var estudiante = new Estudiante(request);
        final var result = this.estudianteRepository.save(estudiante);
        return new EstudianteDTO(result);

    }


}

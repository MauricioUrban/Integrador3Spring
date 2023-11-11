package tpintegrador3.Service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Service.DTO.Carrera.CarreraDTO;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;

import java.util.ArrayList;
import java.util.List;


@Service("EstudianteService")
//@RequiredArgsConstructor
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

//    @Transactional(readOnly = true)
//    public List<Estudiante> findAll() {
//        return estudianteRepository.findAll();
//    }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> findAll() {
        List<Estudiante> resultado = this.estudianteRepository.findAll();
        List<EstudianteDTO> listaNueva = new ArrayList<>();

        for (Estudiante estudiante : resultado) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(
                    estudiante.getNombre(),
                    estudiante.getApellido(),
                    estudiante.getEdad(),
                    estudiante.getGenero(),
                    estudiante.getNroDocumento(),
                    estudiante.getCiudadResidencia(),
                    estudiante.getNroLibreta()
            );
            listaNueva.add(estudianteDTO);
        }

        return listaNueva;
    }


//    @Transactional(readOnly = true)
//    public Optional<Estudiante> findById(Long id) {
//
//        return this.estudianteRepository.findById(id);
//
//
//    }
    @Transactional(readOnly = true)
    public EstudianteDTO findById(Long id) {
        return this.estudianteRepository.findById(id)
                .map(estudiante -> new EstudianteDTO(
                        estudiante.getNombre(),
                        estudiante.getApellido(),
                        estudiante.getEdad(),
                        estudiante.getGenero(),
                        estudiante.getNroDocumento(),
                        estudiante.getCiudadResidencia(),
                        estudiante.getNroLibreta()

                ))
                .orElse(null);
    }

//    @Transactional(readOnly = true)
//    public EstudianteDTO findByNroLibreta(int nroLib) {
//        return this.estudianteRepository.findByNroLibreta(nroLib)
//                .map(estudiante -> new EstudianteDTO(
//                        estudiante.getNombre(),
//                        estudiante.getApellido(),
//                        estudiante.getEdad(),
//                        estudiante.getGenero(),
//                        estudiante.getNroDocumento(),
//                        estudiante.getCiudadResidencia(),
//                        estudiante.getNroLibreta()
//
//                ))
//                .orElse(null);
//    }


    @Transactional
    public Estudiante save(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return estudiante;
    }


//    @Transactional(readOnly = true)
//    public List<EstudianteDTO> findAllOrderByName() {
//
//        return this.estudianteRepository.findAllOrderByName();
//
//    }

    public List<EstudianteDTO> findAllOrderByNombre() {
        List<EstudianteDTO> resultado = this.estudianteRepository.findAllOrderByNombre();   //resultado de la query
        List<EstudianteDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (EstudianteDTO estudiante : resultado) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getNombre(),
                                                            estudiante.getApellido(),
                                                            estudiante.getEdad(),
                                                            estudiante.getGenero(),
                                                            estudiante.getDni(),
                                                            estudiante.getCiudadResidencia(),
                                                            estudiante.getNumeroLibreta());
            listaNueva.add(estudianteDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> findByGenero(String genero) {
        List<Estudiante> estudiantes = this.estudianteRepository.findByGenero(genero);
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(
                    estudiante.getNombre(),
                    estudiante.getApellido(),
                    estudiante.getEdad(),
                    estudiante.getGenero(),
                    estudiante.getNroDocumento(),
                    estudiante.getCiudadResidencia(),
                    estudiante.getNroLibreta()
            );
            estudiantesDTO.add(estudianteDTO);
        }

        return estudiantesDTO;
    }



    //d) recuperar un estudiante, en base a su número de libreta universitaria.
//    @Transactional(readOnly = true)
    public EstudianteDTO findByNroLibreta(int nroLibreta) {
        return estudianteRepository.findByNroLibreta(nroLibreta);
    }

    //findEstudiantesByCarreraAndCiudad
 //   @Transactional(readOnly = true)
 //   public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {

 //       return this.estudianteRepository.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia);

  //  }

    @Transactional(readOnly = true)
    public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<Estudiante> estudiantes = this.estudianteRepository.findEstudiantesByCarreraAndCiudad(nombreCarrera, ciudadResidencia);
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(
                    estudiante.getNombre(),
                    estudiante.getApellido(),
                    estudiante.getEdad(),
                    estudiante.getGenero(),
                    estudiante.getNroDocumento(),
                    estudiante.getCiudadResidencia(),
                    estudiante.getNroLibreta()
            );
            estudiantesDTO.add(estudianteDTO);
        }

        return estudiantesDTO;
    }


}

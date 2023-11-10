package tpintegrador3.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Entidades.Estudiante_Carrera;
import tpintegrador3.Repository.CarreraRepository;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Repository.Estudiante_CarreraRepository;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Request.Estudiante_CarreraRequestDTO;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Response.Estudiante_CarreraResponseDTO;
import tpintegrador3.Service.DTO.Reporte.ReporteDTO;

import java.util.List;
import java.util.Optional;


@Service("Estudiante_CarreraService")
public class Estudiante_CarreraService {
    @Autowired
    private Estudiante_CarreraRepository estudianteCarreraRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CarreraRepository carreraRepository;
    public Estudiante_CarreraResponseDTO save(Estudiante_CarreraRequestDTO ec) throws Exception {
        //carrera obtenida por id
        Carrera c = carreraRepository.findById(ec.getIdCarrera()).orElseThrow(() -> new Exception("Carrera no encontrada"));
        //estudiante obtenido por id
        Estudiante e = estudianteRepository.findById(ec.getIdEstudiante()).orElseThrow(() -> new Exception("Estudiante no encontrado"));

        Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera(e,c, ec.getYear(), ec.isGraduado());

        estudianteCarreraRepository.save(estudianteCarrera);

        //retorno Estudiante_CarreraResponseDTO
        return new Estudiante_CarreraResponseDTO(estudianteCarrera);
    }

    public List<Estudiante_CarreraResponseDTO> findAll() {
        return null;
    }

    public Estudiante_CarreraResponseDTO findById(Long id) {
        return null;
    }

    public List<Estudiante_CarreraResponseDTO> search(Estudiante_CarreraRequestDTO request) {
        return null;
    }

    public List<Estudiante_CarreraResponseDTO> bestStudentCarrera() {
        return null;
    }



/*
generar un reporte de las carreras, que para cada carrera incluya información de los
inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
presentar los años de manera cronológica.


    public ReporteDTO getReporte() {
        //obtenemos todos los años en donde hubieron graduaciones
        List<Integer> aniosDeGraduaciones = estudianteCarreraRepository.getAniosDeGraduacionesAsc();
        //obtenemos todos los años en donde hubieron inscripciones
        List<Integer> aniosDeInscripciones = matriculacionRepository.getAniosDeInscripcionesAsc();

        List<Carrera> allCarreras = carreraRepository.findAllByOrderByNombreAsc();
        ReporteDTO reporte = new ReporteDTO();

        //por cada carrera persistida
        for (Carrera c: allCarreras) {
            //CarreraDTO que tendrá dentro todos los estudiantes que se inscribieron y egresaron en ella
            CarreraConInscriptosYEgresadosDTO carreraConInscriptosYEgresadosDTO = new CarreraConInscriptosYEgresadosDTO(c.getNombre());
            //por cada año se obtienen los estudiantes que se graduaron en la carrera 'x'
            for (Integer anio : aniosDeGraduaciones) {
                List<EstudianteDTO> estudianteGraduadosDTOs = new ArrayList<>();
                for (Estudiante e : estudianteRepository.findAllGraduatedByCarreraAndYear(c, anio)) {
                    estudianteGraduadosDTOs.add(new EstudianteDTO(e.getDni(), e.getNombres(), e.getApellido(), e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumeroLibreta()));
                }
                if (!estudianteGraduadosDTOs.isEmpty()){
                    carreraConInscriptosYEgresadosDTO.agregarGraduadosEnAnio(estudianteGraduadosDTOs, anio);
                }
            }
            //por cada año se obtienen los estudiantes que se inscribieron en la carrera 'x'
            for (Integer anio : aniosDeInscripciones) {
                List<EstudianteDTO> estudianteInscriptosDTOs = new ArrayList<>();
                for (Estudiante e : estudianteRepository.findAllInscribedByCarreraAndYear(c, anio)) {
                    estudianteInscriptosDTOs.add(new EstudianteDTO(e.getDni(), e.getNombres(), e.getApellido(), e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumeroLibreta()));
                }
                if (!estudianteInscriptosDTOs.isEmpty()){
                    carreraConInscriptosYEgresadosDTO.agregarInscriptosEnAnio(estudianteInscriptosDTOs, anio);
                }
            }
            //agregamos la carrera al reporte
            reporte.agregarCarrerasConInscriptosEnAnio(carreraConInscriptosYEgresadosDTO);
        }
        return reporte;

    }*/


}

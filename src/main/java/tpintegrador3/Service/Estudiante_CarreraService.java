package tpintegrador3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Entidades.Estudiante_Carrera;
import tpintegrador3.Repository.CarreraRepository;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Repository.Estudiante_CarreraRepository;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Estudiante_CarreraDTO;
import tpintegrador3.Service.DTO.Reporte.ReporteDTO;

import java.util.ArrayList;
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
    public Estudiante_CarreraDTO save(Estudiante_Carrera ec) throws Exception {
        //carrera obtenida por id
        Carrera c = carreraRepository.findById(ec.getCarrera().getIdCarrera()).orElseThrow(() -> new Exception("Carrera no encontrada"));
        //estudiante obtenido por id
        Estudiante e = estudianteRepository.findById(ec.getEstudiante().getIdEstudiante()).orElseThrow(() -> new Exception("Estudiante no encontrado"));

        Estudiante_Carrera estudianteCarrera = new Estudiante_Carrera(e,c, ec.getAntiguedad(), ec.isGraduado());

        estudianteCarreraRepository.save(estudianteCarrera);

        //retorno Estudiante_CarreraResponseDTO
        return new Estudiante_CarreraDTO(estudianteCarrera.getEstudiante().getIdEstudiante(), estudianteCarrera.getCarrera().getIdCarrera(), estudianteCarrera.getAntiguedad(), estudianteCarrera.isGraduado());
    }


    public Estudiante_CarreraDTO findById(Long id) {
        Optional<Estudiante_Carrera> estudianteCarreraOptional = estudianteCarreraRepository.findById(id);

        if (estudianteCarreraOptional.isPresent()) {
            Estudiante_Carrera estudianteCarrera = estudianteCarreraOptional.get();
            return new Estudiante_CarreraDTO(estudianteCarrera.getEstudiante().getIdEstudiante(), estudianteCarrera.getCarrera().getIdCarrera(), estudianteCarrera.getAntiguedad(), estudianteCarrera.isGraduado());

        } else {
            return null;
        }
    }




    public List<ReporteDTO> reporteEstudiantesPorCarrera() {
        List<Object[]> reporteData = estudianteCarreraRepository.getReporte();
        List<ReporteDTO> reporteResponseList = new ArrayList<>();

        for (Object[] data : reporteData) {
            String nombreCarrera = (String) data[0];
            int antiguedad = (int) data[1];
            long cantidadEstudiantes = (long) data[2];
            long cantidadGraduados = (long) data[3];

            ReporteDTO reporteResponseDTO = new ReporteDTO(nombreCarrera, antiguedad, cantidadEstudiantes, cantidadGraduados);
            reporteResponseList.add(reporteResponseDTO);
        }

        return reporteResponseList;

    }




}

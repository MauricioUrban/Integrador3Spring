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
import tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;
import tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Request.Estudiante_CarreraRequestDTO;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Response.Estudiante_CarreraResponseDTO;

import java.util.List;
import java.util.Optional;


@Service("Estudiante_CarreraService")
@RequiredArgsConstructor
public class Estudiante_CarreraService {
    @Autowired
    private final Estudiante_CarreraRepository estudianteCarreraRepository;
    @Autowired
    private final EstudianteRepository estudianteRepository;
    @Autowired
    private final CarreraRepository carreraRepository;


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

    public Estudiante_CarreraResponseDTO save(Estudiante_CarreraRequestDTO ec) throws Exception {
// Obtener las instancias de Estudiante y Carrera a partir de sus IDs
        Carrera carrera = carreraRepository.findByNombreCarrera(ec.getNombreCarrera())
                .orElseThrow(() -> new Exception("Carrera no encontrada"));
    }


}

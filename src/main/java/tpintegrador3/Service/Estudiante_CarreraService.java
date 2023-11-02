package tpintegrador3.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Repository.Estudiante_CarreraRepository;
import tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;
import tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Request.Estudiante_CarreraRequestDTO;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Response.Estudiante_CarreraResponseDTO;

import java.util.List;


@Service
@RequiredArgsConstructor
public class Estudiante_CarreraService {

    private final Estudiante_CarreraRepository estudianteCarreraRepository;
    private final EstudianteService estudianteService;
    private final CarreraService carreraService;


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

    public Object save(Estudiante_CarreraRequestDTO request) {
        return null;
    }

    public Estudiante_CarreraResponseDTO luckyStudent_Carrera() {
        return null;
    }
}

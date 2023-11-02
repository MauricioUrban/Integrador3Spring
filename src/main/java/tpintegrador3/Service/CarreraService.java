package tpintegrador3.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Repository.CarreraRepository;
import tpintegrador3.Service.DTO.Carrera.Request.CarreraRequestDTO;
import tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;

import java.util.List;

@Service
public class CarreraService {
    //repository
    @Autowired
    private CarreraRepository carreraRepository;

    @Transactional(readOnly = true)
    public List<CarreraResponseDTO> findAll() {

            return  this.carreraRepository.findAll().stream().map(CarreraResponseDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public CarreraResponseDTO findById(Long id) {

            return this.carreraRepository.findById(id).map(CarreraResponseDTO::new).orElse(null);



    }

    @Transactional(readOnly = true)
    public List<CarreraResponseDTO> search(CarreraRequestDTO request) {

            return this.carreraRepository.search(request.getNombre()).stream().map(CarreraResponseDTO::new).toList();

    }

    @Transactional
    public CarreraResponseDTO save(CarreraRequestDTO request) {
            final var carrera = new Carrera(request);
            final var result = this.carreraRepository.save(carrera);
            return new CarreraResponseDTO(result);
    }


    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @Transactional(readOnly = true)
    public List<CarreraResponseDTO> carrerasWithEstudiantes() {

                return this.carreraRepository.carrerasWithEstudiantes().stream().map(CarreraResponseDTO::new).toList();
    }


}

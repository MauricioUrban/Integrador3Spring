package tpintegrador3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Repository.CarreraRepository;
import tpintegrador3.Service.DTO.Carrera.CarreraDTO;
import java.util.ArrayList;
import java.util.List;

@Service("CarreraService")
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    @Transactional(readOnly = true)
    public List<CarreraDTO> findAll() {
        List<Carrera> resultado = this.carreraRepository.findAll();
        List<CarreraDTO> listaNueva = new ArrayList<>();

        for (Carrera carrera : resultado) {
            CarreraDTO carreraDTO = new CarreraDTO(
                    carrera.getNombreCarrera()
            );
            listaNueva.add(carreraDTO);
        }

        return listaNueva;
    }

    @Transactional(readOnly = true)
    public CarreraDTO findById(Long id) {
        return this.carreraRepository.findById(id)
                .map(carrera -> new CarreraDTO(
                        carrera.getNombreCarrera()
                ))
                .orElse(null);
    }

    @Transactional(readOnly = true)
    public List<CarreraDTO> search(CarreraDTO request) {
        List<Carrera> resultado = this.carreraRepository.search(request.getNombreCarrera());
        List<CarreraDTO> listaNueva = new ArrayList<>();

        for (Carrera carrera : resultado) {
            CarreraDTO carreraDTO = new CarreraDTO(
                 carrera.getNombreCarrera()
            );

            listaNueva.add(carreraDTO);
        }

        return listaNueva;
    }


    @Transactional
    public CarreraDTO save(Carrera carrera) {
            Carrera result = this.carreraRepository.save(carrera);
            return new CarreraDTO(result.getNombreCarrera());
    }


    @Transactional
    public CarreraDTO update(Long id, CarreraDTO request) {
        Carrera carrera = carreraRepository.findById(id).orElse(null);
        if (carrera == null) {
            return null;
        }
        carrera.setNombre(request.getNombreCarrera());
        carrera = carreraRepository.save(carrera);
        return new CarreraDTO(carrera.getNombreCarrera());
    }


    @Transactional
    public void delete(Long id) {
        Carrera carrera = carreraRepository.findById(id).orElse(null);
        if (carrera != null) {
           carreraRepository.delete(carrera);
        }
    }


}

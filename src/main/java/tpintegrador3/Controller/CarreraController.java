package tpintegrador3.Controller;


import org.springframework.web.bind.annotation.*;
import tpintegrador3.Service.CarreraService;
import tpintegrador3.Service.DTO.Carrera.Request.CarreraRequestDTO;
import tpintegrador3.Service.DTO.Carrera.Response.CarreraResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/carrera")
public class CarreraController {
    private CarreraService carreraService;

    // Crea una nueva carrera
    @PostMapping("/save")
    public CarreraResponseDTO save(CarreraRequestDTO request) {
        return carreraService.save(request);
    }

    // Busca una carrera especifica por id
    @GetMapping("/findById/{id}")
    public CarreraResponseDTO findById(@PathVariable String id) {
        Long _id = Long.valueOf(id);
        CarreraResponseDTO carrera = carreraService.findById(_id);
        return carrera;
    }

    // Actualiza una carrera
    @PutMapping("/update/{id}")
    public CarreraResponseDTO update(@PathVariable String id, @RequestBody CarreraRequestDTO request) {
        Long _id = Long.valueOf(id);
        CarreraResponseDTO updatedCarrera = carreraService.update(_id, request);
        return updatedCarrera;
    }

    // Elimina una carrera
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        Long _id = Long.valueOf(id);
        carreraService.delete(_id);
    }

    // Devuelve todas las carreras
    @GetMapping("/findAll")
    public List<CarreraResponseDTO> findAll() {
        List<CarreraResponseDTO> carreras = carreraService.findAll();
        return carreras;
    }

    // Devuelve las carreras que tienen estudiantes inscriptos
    @GetMapping("/carrerasWithEstudiantes")
    public List<CarreraResponseDTO> carrerasWithEstudiantes() {
        return carreraService.carrerasWithEstudiantes();
    }

    // Recibe un objeto CarreraRequestDTO, que contiene un criterio de búsqueda.
    @GetMapping("/search")
    public List<CarreraResponseDTO> search(CarreraRequestDTO request) {

        return carreraService.search(request);
    }

}

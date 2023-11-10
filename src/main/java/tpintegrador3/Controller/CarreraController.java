package tpintegrador3.Controller;


import org.springframework.web.bind.annotation.*;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Service.CarreraService;
import tpintegrador3.Service.DTO.Carrera.CarreraDTO;
import java.util.List;

@RestController("CarreraController")
@RequestMapping("/carrera")
public class CarreraController {
    private CarreraService carreraService;

    // Crea una nueva carrera
    @PostMapping("/save")
    public CarreraDTO save(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    // Busca una carrera especifica por id
    @GetMapping("/findById/{id}")
    public CarreraDTO findById(@PathVariable String id) {
        Long _id = Long.valueOf(id);
        CarreraDTO carrera = carreraService.findById(_id);
        return carrera;
    }

    // Actualiza una carrera
    @PutMapping("/update/{id}")
    public CarreraDTO update(@PathVariable String id, @RequestBody CarreraDTO request) {
        Long _id = Long.valueOf(id);
        CarreraDTO updatedCarrera = carreraService.update(_id, request);
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
    public List<CarreraDTO> findAll() {
        List<CarreraDTO> carreras = carreraService.findAll();
        return carreras;
    }

    // Devuelve las carreras que tienen estudiantes inscriptos
    @GetMapping("/carrerasWithEstudiantes")
    public List<CarreraDTO> carrerasWithEstudiantes() {
        return carreraService.carrerasWithEstudiantes();
    }

    // Recibe un objeto CarreraRequestDTO, que contiene un criterio de búsqueda.
    @GetMapping("/search")
    public List<CarreraDTO> search(CarreraDTO request) {

        return carreraService.search(request);
    }

}

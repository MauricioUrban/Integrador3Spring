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

    @GetMapping("/findAll")
    public List<CarreraResponseDTO> findAll() {

        List<CarreraResponseDTO> carreras = carreraService.findAll();

        return carreras;
    }

    @GetMapping("/findById/{id}")
    public CarreraResponseDTO findById(@PathVariable String id) {
        Long _id = Long.valueOf(id);
        CarreraResponseDTO carrera = carreraService.findById(_id);
        return carrera;
    }

    @GetMapping("/search")
    public List<CarreraResponseDTO> search(CarreraRequestDTO request) {

        return carreraService.search(request);
    }



    @PostMapping("/save")
    public CarreraResponseDTO save(CarreraRequestDTO request) {

        return carreraService.save(request);
    }

    @GetMapping("/carrerasWithEstudiantes")
    public List<CarreraResponseDTO> carrerasWithEstudiantes() {

        return carreraService.carrerasWithEstudiantes();
    }

    //@DeleteMapping
    //@PutMapping
}

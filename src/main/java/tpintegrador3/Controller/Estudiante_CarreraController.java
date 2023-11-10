package tpintegrador3.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Entidades.Estudiante_Carrera;
import tpintegrador3.Repository.CarreraRepository;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Estudiante_CarreraDTO;
import tpintegrador3.Service.Estudiante_CarreraService;

import java.util.Optional;

@RestController("Estudiante_CarreraController")
@RequestMapping("/estudiante_carrera")
public class Estudiante_CarreraController {

    @Autowired
    private Estudiante_CarreraService estudiante_carreraService;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    //Devuelvo el reporte de estudiantes por carrera
    @GetMapping("/reporteEstudiantesPorCarrera")
    public void reporteEstudiantesPorCarrera() throws Exception {
        estudiante_carreraService.reporteEstudiantesPorCarrera();
    }

    //Save
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestParam Long idEstudiante,
                                       @RequestParam Long idCarrera,
                                       @RequestParam int year,
                                       @RequestParam boolean graduado){

        Optional<Estudiante> estudianteOptional = estudianteRepository.findById(idEstudiante);
        Optional<Carrera> carreraOptional = carreraRepository.findById(idCarrera);

        if (estudianteOptional.isPresent() && carreraOptional.isPresent()) {
            Estudiante estudiante = estudianteOptional.get();
            Carrera carrera = carreraOptional.get();

            Estudiante_Carrera estudiante_carrera = new Estudiante_Carrera(estudiante, carrera, year, graduado);

            try {
                estudiante_carreraService.save(estudiante_carrera);
                return ResponseEntity.ok("Estudiante_Carrera guardado exitosamente");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar Estudiante_Carrera");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudiante o Carrera no encontrados");
        }
    }

    //findById
    @GetMapping("/findById/{id}")
    public Estudiante_CarreraDTO findById(@PathVariable Long id) {
        return estudiante_carreraService.findById(id);
    }

}

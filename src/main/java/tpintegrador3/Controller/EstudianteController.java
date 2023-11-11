package tpintegrador3.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;
import tpintegrador3.Service.EstudianteService;

import java.util.List;

@RestController("EstudianteController")
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    // Devuelve todos los estudiantes
    @GetMapping("/findAll")
    public List<EstudianteDTO> findAll() {
        return estudianteService.findAll();
    }

    // Busca un estudiante especifico por id
    @GetMapping("/findById/{id}")
    public EstudianteDTO findById(@PathVariable String id) {
        Long _id = Long.valueOf(id);
        EstudianteDTO estudiante = estudianteService.findById(_id);
        return estudiante;
    }


    // Agrega un estudiante
    @PostMapping("/save")
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante request) {
        Estudiante estudiante = estudianteService.save(request);
        return ResponseEntity.accepted().body(estudiante);
    }


    // Lista todos los estudiantes ordenados por nombre
    @GetMapping("/findAllOrderByNombre")
    public List<EstudianteDTO> findAllOrderByName() {
        List<EstudianteDTO> estudiantes = estudianteService.findAllOrderByNombre();
        return estudiantes;
    }

    // Lista todos los estudiantes ordenador por genero
    @GetMapping("/findByGenero/{genero}")
    public List<EstudianteDTO> findByGenero(@PathVariable String genero) {
        List<EstudianteDTO> estudiantes = estudianteService.findByGenero(genero);
        return estudiantes;
    }


    // Devuelve un estudiante por numero de libreta
    @GetMapping("/findByNroLibreta/{libreta}")
    public EstudianteDTO findByNroLibreta(@PathVariable int libreta){
        return estudianteService.findByNroLibreta(libreta);
    }


    //Devuelve lista de estudiantes ordenados por carrera y ciudad
    @RequestMapping("/findEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}")
    public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(@PathVariable String nombreCarrera, @PathVariable String ciudadResidencia) {
        List<EstudianteDTO> estudiantes = estudianteService.findEstudiantesByCarreraAndCiudad(nombreCarrera, ciudadResidencia);
        return estudiantes;
    }


}

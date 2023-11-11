package tpintegrador3.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;
import tpintegrador3.Service.EstudianteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @GetMapping("/findAll")
    public List<EstudianteDTO> findAll() {
        return estudianteService.findAll();
    }

    @GetMapping("/findById/{id}")
    public EstudianteDTO findById(@PathVariable String id) {
        Long _id = Long.valueOf(id);
        EstudianteDTO estudiante = estudianteService.findById(_id);
        return estudiante;
    }

//    @GetMapping("/findByNroLibreta/{nroLibreta}")
//    public EstudianteDTO findByNroLibreta(@PathVariable String nroLibreta) {
//        Integer _nroLibreta = Integer.parseInt(nroLibreta);
//        EstudianteDTO estudiante = estudianteService.findByNroLibreta(_nroLibreta);
//        return estudiante;
//    }

    @PostMapping("/save")
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante request) {
        Estudiante estudiante = estudianteService.save(request);
        return ResponseEntity.accepted().body(estudiante);
    }



    @GetMapping("/findAllOrderByNombre")
    public List<EstudianteDTO> findAllOrderByName() {
        List<EstudianteDTO> estudiantes = estudianteService.findAllOrderByNombre();
        return estudiantes;
    }

    @GetMapping("/findByGenero/{genero}")
    public List<EstudianteDTO> findByGenero(@PathVariable String genero) {
        List<EstudianteDTO> estudiantes = estudianteService.findByGenero(genero);
        return estudiantes;
    }


//
//    @RequestMapping(value="/getByLibreta/{libreta}", method=RequestMethod.GET)
//    public EstudianteDTO getByGenero(@PathVariable int libreta){
//        return estudianteService.findByNroLibreta(libreta);
//    }

    @GetMapping(value="/findByNroLibreta/{libreta}")
    public EstudianteDTO findByNroLibreta(@PathVariable int libreta){
        return estudianteService.findByNroLibreta(libreta);
    }

//    @RequestMapping(value="/genre/{genero}", method=RequestMethod.GET)
//    public List<EstudianteDTO> getByGenero(@PathVariable String genero){
//        return estudianteService.findByGenero(genero);
//    }

    @RequestMapping("/findEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}")
    public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(@PathVariable String nombreCarrera, @PathVariable String ciudadResidencia) {
        List<EstudianteDTO> estudiantes = estudianteService.findEstudiantesByCarreraAndCiudad(nombreCarrera, ciudadResidencia);
        return estudiantes;
    }


}

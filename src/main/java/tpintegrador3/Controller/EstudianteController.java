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
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @RequestMapping("/findAll")
    public List<Estudiante> findAll() {
        List<Estudiante> estudiantes = estudianteService.findAllEstudiantes();
        return estudiantes;
    }

    @RequestMapping("/findById/{id}")
    public Optional<Estudiante> findById(String id) {
        Long _id = Long.valueOf(id);
        Optional<Estudiante> estudiante = estudianteService.findById(_id);
        return estudiante;
    }

    @PostMapping("/save")
    public ResponseEntity<Estudiante> save(@RequestBody Estudiante request) {
        Estudiante estudiante = estudianteService.save(request);
        return ResponseEntity.accepted().body(estudiante);
    }


    /*
    @PostMapping("")
    public ResponseEntity<ClienteResponseDTO> save( @RequestBody @Valid ClienteRequestDTO request ){
        final var result = this.clienteService.save( request );
        return ResponseEntity.accepted().body( result );
    }
*/


    @RequestMapping("/findAllOrderByName")
    public List<EstudianteDTO> findAllOrderByName() {
        List<EstudianteDTO> estudiantes = estudianteService.findAllOrderByName();
        return estudiantes;
    }

    @RequestMapping("/findByGenero/{genero}")
    public List<EstudianteDTO> findByGenero(String genero) {
        List<EstudianteDTO> estudiantes = estudianteService.findByGenero(genero);
        return estudiantes;
    }

//    @RequestMapping("/findByNroLibreta/{nroLibreta}")
//    public EstudianteDTO findByNroLibreta(String nroLibreta) {
//        int _nroLibreta = Integer.valueOf(nroLibreta);
//        EstudianteDTO estudiante = estudianteService.findByNroLibreta(_nroLibreta);
//        return estudiante;
//    }

    @RequestMapping(value="/getByLibreta/{libreta}", method=RequestMethod.GET)
    public EstudianteDTO getByGenero(@PathVariable int libreta){
        return estudianteService.findByNroLibreta(libreta);
    }

    @RequestMapping(value="/genre/{genero}", method=RequestMethod.GET)
    public List<EstudianteDTO> getByGenero(@PathVariable String genero){
        return estudianteService.findByGenero(genero);
    }

    @RequestMapping("/findEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}")
    public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<EstudianteDTO> estudiantes = estudianteService.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia);
        return estudiantes;
    }

}

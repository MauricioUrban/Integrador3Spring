package tpintegrador3.Controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;
import tpintegrador3.Service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @RequestMapping("/findAll")
    public List<EstudianteDTO> findAll() {
        List<EstudianteDTO> estudiantes = estudianteService.findAll();
        return estudiantes;
    }

    @RequestMapping("/findById/{id}")
    public EstudianteDTO findById(String id) {
        Long _id = Long.valueOf(id);
        EstudianteDTO estudiante = estudianteService.findById(_id);
        return estudiante;
    }

    @PostMapping("/save")
    public ResponseEntity<EstudianteDTO> save(@RequestBody Estudiante request) {
        EstudianteDTO estudiante = estudianteService.save(request);
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

    @RequestMapping("/findByNroLibreta/{nroLibreta}")
    public EstudianteDTO findByNroLibreta(String nroLibreta) {
        int _nroLibreta = Integer.valueOf(nroLibreta);
        EstudianteDTO estudiante = estudianteService.findByNroLibreta(_nroLibreta);
        return estudiante;
    }

    @RequestMapping("/findEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}")
    public List<EstudianteDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<EstudianteDTO> estudiantes = estudianteService.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia);
        return estudiantes;
    }

}

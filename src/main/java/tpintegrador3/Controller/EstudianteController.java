package tpintegrador3.Controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tpintegrador3.Service.DTO.Estudiante.Request.EstudianteRequestDTO;
import tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import tpintegrador3.Service.EstudianteService;

import java.util.List;

@RequestMapping("/estudiante")
public class EstudianteController {

    private EstudianteService estudianteService;


    @RequestMapping("/findAll")
    public List<EstudianteResponseDTO> findAll() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findAll();
        return estudiantes;
    }

    @RequestMapping("/findById/{id}")
    public EstudianteResponseDTO findById(String id) {
        Long _id = Long.valueOf(id);
        EstudianteResponseDTO estudiante = estudianteService.findById(_id);
        return estudiante;
    }

    @PostMapping("/save")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody @Valid EstudianteRequestDTO request) {
        EstudianteResponseDTO estudiante = estudianteService.save(request);
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
    public List<EstudianteResponseDTO> findAllOrderByName() {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findAllOrderByName();
        return estudiantes;
    }

    @RequestMapping("/findByGenero/{genero}")
    public List<EstudianteResponseDTO> findByGenero(String genero) {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findByGenero(genero);
        return estudiantes;
    }

    @RequestMapping("/findByNroLibreta/{nroLibreta}")
    public EstudianteResponseDTO findByNroLibreta(String nroLibreta) {
        int _nroLibreta = Integer.valueOf(nroLibreta);
        EstudianteResponseDTO estudiante = estudianteService.findByNroLibreta(_nroLibreta);
        return estudiante;
    }

    @RequestMapping("/findEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}")
    public List<EstudianteResponseDTO> findEstudiantesByCarreraAndCiudad(String nombreCarrera, String ciudadResidencia) {
        List<EstudianteResponseDTO> estudiantes = estudianteService.findEstudiantesByCarreraAndCiudad(nombreCarrera,ciudadResidencia);
        return estudiantes;
    }

}

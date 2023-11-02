package tpintegrador3.rest.Estudiante;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpintegrador3.Service.DTO.Estudiante.Response.EstudianteResponseDTO;
import tpintegrador3.Service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("api/carreras")
@RequiredArgsConstructor
public class EstudianteResource {

    private final EstudianteService estudianteService;

    @GetMapping("")
    public List<EstudianteResponseDTO> findAll(){
        return this.estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteResponseDTO findById( @PathVariable Long id ){
        return this.estudianteService.findById( id );
    }
/*
    @GetMapping("/search")
    public List<EstudianteResponseDTO> findById( EstudianteRequestDTO request ){
        return this.estudianteService.search( request );
    }

    @GetMapping("/bests")
    public List<EstudianteResponseDTO> bestStudents(){
        return this.estudianteService.bestStudents();
    }

    @PostMapping("")
    public ResponseEntity<EstudianteResponseDTO> save(@RequestBody @Valid EstudianteRequestDTO request ){
        final var result = this.estudianteService.save( request );
        return ResponseEntity.accepted().body((EstudianteResponseDTO) result);
    }

    @GetMapping("/lucky")
    public EstudianteResponseDTO luckyStudent(){
        return this.estudianteService.luckyStudent();
    }
*/
}



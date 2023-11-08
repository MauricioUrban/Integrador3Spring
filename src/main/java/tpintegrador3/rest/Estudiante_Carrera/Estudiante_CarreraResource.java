package tpintegrador3.rest.Estudiante_Carrera;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Request.Estudiante_CarreraRequestDTO;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Response.Estudiante_CarreraResponseDTO;
import tpintegrador3.Service.Estudiante_CarreraService;

import java.util.List;

@RestController
@RequestMapping("api/estudiante_carrera")
@RequiredArgsConstructor
public class Estudiante_CarreraResource {

    private final Estudiante_CarreraService estudiante_carreraService;

    @GetMapping("")
    public List<Estudiante_CarreraResponseDTO> findAll(){
        return this.estudiante_carreraService.findAll();
    }

    @GetMapping("/{id}")
    public Estudiante_CarreraResponseDTO findById( @PathVariable Long id ){
        return this.estudiante_carreraService.findById( id );
    }

    @GetMapping("/search")
    public List<Estudiante_CarreraResponseDTO> findById( Estudiante_CarreraRequestDTO request ){
        return this.estudiante_carreraService.search( request );
    }

    @GetMapping("/bests")
    public List<Estudiante_CarreraResponseDTO> bestStudentCarrera(){
        return this.estudiante_carreraService.bestStudentCarrera();
    }

    @PostMapping("")
    public ResponseEntity<Estudiante_CarreraResponseDTO> save(@RequestBody @Valid Estudiante_CarreraRequestDTO request ){
        final var result = this.estudiante_carreraService.save( request );
        return ResponseEntity.accepted().body((Estudiante_CarreraResponseDTO) result);
    }

    @GetMapping("/lucky")
    public Estudiante_CarreraResponseDTO luckyStudent_Carrera(){
        return this.estudiante_carreraService.luckyStudent_Carrera();
    }
}

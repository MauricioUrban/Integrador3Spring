package tpintegrador3.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Service.DTO.Estudiante.EstudianteDTO;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

//c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.

    @Query("SELECT NEW tpintegrador3.Service.DTO.Estudiante.EstudianteDTO(e.nombre, e.apellido, e.edad, e.genero, e.nroDocumento, e.ciudadResidencia, e.nroLibreta) FROM Estudiante e ORDER BY e.nombre ASC")
    public List<EstudianteDTO> findAllOrderByNombre();

    //b) matricular un estudiante en una carrera


    //e) recuperar todos los estudiantes, en base a su género.
    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    List<Estudiante> findByGenero(String genero);

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    @Query("SELECT NEW tpintegrador3.Service.DTO.Estudiante.EstudianteDTO(e.nombre, e.apellido, e.edad, e.genero, e.nroDocumento, e.ciudadResidencia, e.nroLibreta) FROM Estudiante e WHERE e.nroLibreta = :nroLibreta")
    EstudianteDTO findByNroLibreta(@Param("nroLibreta") int nroLibreta);

    //g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia


    @Query("SELECT ec.estudiante " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.estudiante e " +
            "JOIN ec.carrera c " +
            "WHERE c.nombreCarrera = :nombreCarrera " +
            "AND e.ciudadResidencia = :ciudadResidencia")
    List<Estudiante> findEstudiantesByCarreraAndCiudad(@Param("nombreCarrera") String nombreCarrera, @Param("ciudadResidencia") String ciudadResidencia);

    //Find by id
    @Query("SELECT e FROM Estudiante e WHERE e.idEstudiante = :id")
    public Estudiante findById(int id);

    @Query("SELECT e FROM Estudiante e")
    List<EstudianteDTO> findAllEstudiantes();


}


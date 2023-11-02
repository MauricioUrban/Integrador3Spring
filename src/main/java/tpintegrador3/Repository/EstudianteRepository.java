package tpintegrador3.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tpintegrador3.Entidades.Estudiante;

import java.util.Collection;
import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
/*
 */

//c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.

    @Query("SELECT e FROM Estudiante e ORDER BY e.nombre ASC")
    public List<Estudiante> findAllOrderByName();

    //b) matricular un estudiante en una carrera


    //e) recuperar todos los estudiantes, en base a su género.
    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    public List<Estudiante> findByGenero(String genero);

    //d) recuperar un estudiante, en base a su número de libreta universitaria.
    @Query("SELECT e FROM Estudiante e WHERE e.nroLibreta = :nroLibreta")
    public List<Estudiante> findByNroLibreta(int nroLibreta);

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
    public List<Estudiante> findById(int id);

}

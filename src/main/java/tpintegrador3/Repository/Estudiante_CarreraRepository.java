package tpintegrador3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tpintegrador3.Entidades.Estudiante_Carrera;
import java.util.List;

@Repository
public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_Carrera, Long> {

    List<Estudiante_Carrera> findAll();


    //  Genera un reporte de la carrera y la cantidad de estudiantes que se inscribieron en ella y
    //  graduados en un rango de años
    @Query("SELECT c.nombreCarrera, ec.antiguedad, " +
            "COUNT(ec), " +
            "SUM(CASE WHEN ec.graduado = true THEN 1 ELSE 0 END) " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.carrera c " +
            "WHERE ec.antiguedad BETWEEN 1990 AND :currentYear " +
            "GROUP BY c.nombreCarrera, ec.antiguedad " +
            "ORDER BY c.nombreCarrera ASC, ec.antiguedad ASC")
    List<Object[]> getReporte(@Param("currentYear") int currentYear);


    // Recupera las carreras con estudiantes inscriptos ordenadas por cantidad de inscriptos
    @Query("SELECT c.nombreCarrera, " +
            "COUNT(ec) AS cantidadInscritos " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.carrera c " +
            "WHERE ec.antiguedad BETWEEN 1990 AND :currentYear " +
            "GROUP BY c.nombreCarrera " +
            "ORDER BY cantidadInscritos DESC")
    List<Object[]> getCarrerasConInscriptos(@Param("currentYear") int currentYear);


}


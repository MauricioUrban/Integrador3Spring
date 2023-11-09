package tpintegrador3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tpintegrador3.Entidades.Estudiante_Carrera;

import java.util.List;

@Repository
public interface Estudiante_CarreraRepository extends JpaRepository<Estudiante_Carrera, Long> {


    @Query("SELECT c.nombreCarrera, ec.antiguedad, " +
            "COUNT(ec), " +
            "SUM(CASE WHEN ec.graduado = true THEN 1 ELSE 0 END) " +
            "FROM Estudiante_Carrera ec " +
            "JOIN ec.carrera c " +
            "WHERE ec.antiguedad BETWEEN 1990 AND :currentYear " +
            "GROUP BY c.nombreCarrera, ec.antiguedad " +
            "ORDER BY c.nombreCarrera ASC, ec.antiguedad ASC")
    List<Estudiante_Carrera> getReporte();
}

package tpintegrador3.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tpintegrador3.Entidades.Carrera;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarreraRepository  extends JpaRepository<Carrera, Long> {

    @Query( "SELECT c " +
            "FROM Carrera c " +
            "WHERE (:nombreCarrera IS NULL OR c.nombreCarrera LIKE :nombreCarrera) ")
    List<Carrera> search(String nombreCarrera);


    @Query( "SELECT c " +
            "FROM Carrera c " +
            "JOIN Estudiante_Carrera ec ON (c.idCarrera = ec.carrera.idCarrera) "+
            "GROUP BY c.idCarrera " +
            "ORDER BY COUNT(ec) DESC ")
    List<Carrera> carrerasWithEstudiantes();



    @Query( "SELECT c " +
            "FROM Carrera c " +
            "WHERE c.nombreCarrera = :nombreCarrera ")
    Carrera findByNombreCarrera(String nombreCarrera);
}


package tpintegrador3.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tpintegrador3.Entidades.Carrera;



@Repository("CarreraRepository")
public interface CarreraRepository  extends JpaRepository<Carrera, Long> {

}


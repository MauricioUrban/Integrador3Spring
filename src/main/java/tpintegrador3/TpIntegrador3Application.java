package tpintegrador3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import tpintegrador3.util.Csv;

import java.io.IOException;

/**
 * The type Tp integrador 3 application.
 */
@SpringBootApplication
@EntityScan("tpintegrador3")
public class TpIntegrador3Application {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    @Autowired
    private Csv csv;

    public static void main(String[] args) {
        SpringApplication.run(TpIntegrador3Application.class, args);

    }

    @PostConstruct
    public void init() throws Exception{
        csv.InsertarCSV("estudiantes.csv", "carreras.csv", "estudianteCarrera.csv");
    }
}

package tpintegrador3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

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
    public static void main(String[] args) {
          SpringApplication.run(TpIntegrador3Application.class, args);
    }
}

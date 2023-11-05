package tpintegrador3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("tpintegrador3")
public class TpIntegrador3Application {
    public static void main(String[] args) {
          SpringApplication.run(TpIntegrador3Application.class, args);
    }
}

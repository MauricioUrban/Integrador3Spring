package tpintegrador3.util;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Entidades.Estudiante_Carrera;
import tpintegrador3.Repository.CarreraRepository;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Repository.Estudiante_CarreraRepository;
import java.io.FileReader;
import java.io.IOException;


@Component
public class Csv {

    private final EstudianteRepository er;
    private final CarreraRepository cr;
    private final Estudiante_CarreraRepository ecr;


    public Csv(EstudianteRepository er, CarreraRepository cr, Estudiante_CarreraRepository ecr) {
        this.er = er;
        this.cr = cr;
        this.ecr = ecr;
    }


    // Metodo para insertar los datos de los csv en la base de datos
    public void InsertarCSV(String csvEstudiante, String csvCarrera, String csvEstudianteCarrera) throws IOException {

        String path = "src/main/java/tpintegrador3/CSV";

        String csvFilePath = path + "/" + csvEstudiante;
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {
            Estudiante estudiante = new Estudiante(row.get("nombre"),
                    row.get("apellido"),
                    Integer.parseInt(row.get("edad")),
                    row.get("genero"),
                    (Integer.parseInt(row.get("nroDocumento"))),
                    row.get("ciudadResidencia"),
                    Integer.parseInt(row.get("nroLibreta")));
            er.save(estudiante);
        }

        csvFilePath = path + "/" + csvCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));


        for (CSVRecord row : parser) {
            Carrera carrera = new Carrera(Integer.parseInt(row.get("idCarrera")), row.get("nombreCarrera"));
            cr.save(carrera);
        }

        csvFilePath = path + "/" + csvEstudianteCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {

            Estudiante e = this.er.findById(Long.parseLong(row.get("idEstudiante"))).get();
            Carrera c = this.cr.findById(Long.parseLong(row.get("idCarrera"))).get();
            Estudiante_Carrera ec = new Estudiante_Carrera
                    (e, c, Integer.parseInt(row.get("antiguedad")),
                            Boolean.parseBoolean(row.get("graduado")));
            ecr.save(ec); //guarda a la matriculacion en la base de datos

        }
    }
}


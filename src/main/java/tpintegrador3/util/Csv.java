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
<<<<<<< HEAD
=======

>>>>>>> 12c99b74355ce686e86a296a3ae0801a27507776

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class Csv {
//    @Autowired
//    private EstudianteRepository er;
//
//    @Autowired
//    private CarreraRepository cr;
//
//    @Autowired
//    private Estudiante_CarreraRepository ecr;

    private List<Estudiante> estudiantes = new LinkedList<>();
    private List<Carrera> carreras = new LinkedList<>();
    private List<Estudiante_Carrera> inscripciones = new LinkedList<>();
    private final EstudianteRepository er;
    private final CarreraRepository cr;
    private final Estudiante_CarreraRepository ecr;

//    @Autowired
//    public CSV(EstudianteRepository er, CarreraRepository cr, Estudiante_CarreraRepository ecr){
//        this.er=er;
//        this.cr=cr;
//        this.ecr=ecr;
//    }

    public Csv(EstudianteRepository er, CarreraRepository cr, Estudiante_CarreraRepository ecr) {
        this.er = er;
        this.cr = cr;
        this.ecr = ecr;
    }

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
<<<<<<< HEAD

//        csvFilePath = System.getProperty("user.dir") + "/" + csvCarrera;
        csvFilePath = path + "/" + csvCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

=======
        csvFilePath = path + "/" + csvCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

>>>>>>> 12c99b74355ce686e86a296a3ae0801a27507776
        for (CSVRecord row : parser) {
            Carrera carrera = new Carrera(Integer.parseInt(row.get("idCarrera")), row.get("nombreCarrera"));
            cr.save(carrera);
        }
<<<<<<< HEAD

//        csvFilePath = System.getProperty("user.dir") + "/" + csvEstudianteCarrera;
=======
>>>>>>> 12c99b74355ce686e86a296a3ae0801a27507776
        csvFilePath = path + "/" + csvEstudianteCarrera;
        parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(csvFilePath));

        for (CSVRecord row : parser) {
<<<<<<< HEAD
//            Estudiante_Carrera ic = new Estudiante_Carrera(Integer.parseInt(row.get("dni")), Integer.parseInt(row.get("libretaUniversitaria")), Integer.parseInt(row.get("carrera")), Integer.parseInt(row.get("antiguedad")), row.get("graduado").equals("true"), Integer.parseInt(row.get("anioIngreso")));
//            ecr.save(ic);

            Estudiante e = this.er.findById(Long.parseLong(row.get("idEstudiante"))).get();
            Carrera c = this.cr.findById(Long.parseLong(row.get("idCarrera"))).get();
            Estudiante_Carrera ec = new Estudiante_Carrera
                    (e, c, Integer.parseInt(row.get("antiguedad")),
                            Boolean.parseBoolean(row.get("graduado")));
            ecr.save(ec); //guarda a la matriculacion en la base de datos
=======
            Estudiante e = this.er.findById(Long.parseLong(row.get("idEstudiante"))).get();
                Carrera c = this.cr.findById(Long.parseLong(row.get("idCarrera"))).get();
                Estudiante_Carrera ec = new Estudiante_Carrera
                                    (e, c, Integer.parseInt(row.get("antiguedad")),
                                    Boolean.parseBoolean(row.get("graduado")));
                ecr.save(ec); //guarda a la matriculacion en la base de datos
>>>>>>> 12c99b74355ce686e86a296a3ae0801a27507776

        }
    }
}

<<<<<<< HEAD
//
//    public void csv() throws IOException, Exception {
//        cargarDatosEstudiante();
//        cargarDatosCarrera();
//        cargarDatosEstudianteCarrera();
//    }
//
//    public void cargarDatosEstudiante() throws IOException {
//        File archivoCSV = ResourceUtils.getFile("integrador3Arqui/src/main/java/application/csv/estudiantes.csv");
//
//        try (FileReader reader = new FileReader(archivoCSV);
//             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
//
//            for (CSVRecord csvRecord : csvParser) {
//                Estudiante estudiante = new Estudiante();
//
//                estudiante.setNroDocumento(Integer.parseInt(csvRecord.get("dni")));
//                estudiante.setNombre(csvRecord.get("nombres"));
//                estudiante.setApellido(csvRecord.get("apellido"));
//                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
//                estudiante.setGenero(csvRecord.get("genero"));
//                estudiante.setCiudadResidencia(csvRecord.get("ciudad_residencia"));
//                estudiante.setNroLibreta(Integer.parseInt(csvRecord.get("nroLibreta")));
//
//
//                this.estudianteRepository.save(estudiante); //guarda al estudiante en la base de datos
//            }
//        }
//    }
//
//    public void cargarDatosCarrera() throws IOException {
//        File archivoCSV = ResourceUtils.getFile("src/main/java/tpintegrador3/CSV/carreras.csv");
//
//        try (FileReader reader = new FileReader(archivoCSV);
//             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
//
//            for (CSVRecord csvRecord : csvParser) {
//                Carrera carrera = new Carrera();
//
//                carrera.setNombre(csvRecord.get("nombreCarrera"));
//
//
//                this.carreraRepository.save(carrera);
//            }
//        }
//    }
//
//    public void cargarDatosEstudianteCarrera() throws IOException, Exception {
//        File archivoCSV = ResourceUtils.getFile("src/main/java/tpintegrador3/CSV/estudianteCarrera.csv");
//
//        try (FileReader reader = new FileReader(archivoCSV);
//             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
//
//            for (CSVRecord csvRecord : csvParser) {
//                Estudiante e = this.estudianteRepository.findById(Long.parseLong(csvRecord.get("idEstudiante"))).get();
//                Carrera c = this.carreraRepository.findById(Long.parseLong(csvRecord.get("idCarrera"))).get();
//                Estudiante_CarreraRequestDTO estudiante_carrera = new Estudiante_CarreraRequestDTO
//                                    (e.getIdEstudiante(),
//                                    c.getIdCarrera(), Integer.parseInt(csvRecord.get("antiguedad")),
//                                    Boolean.parseBoolean(csvRecord.get("graduado")));
//
//
//
//                this.estudiante_carreraService.save(estudiante_carrera); //guarda a la matriculacion en la base de datos
//            }
//        }
//    }
//}
=======

>>>>>>> 12c99b74355ce686e86a296a3ae0801a27507776

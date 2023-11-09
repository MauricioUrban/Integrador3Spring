package tpintegrador3.util;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import tpintegrador3.Entidades.Carrera;
import tpintegrador3.Entidades.Estudiante;
import tpintegrador3.Repository.CarreraRepository;
import tpintegrador3.Repository.EstudianteRepository;
import tpintegrador3.Service.DTO.Estudiante_Carrera.Request.Estudiante_CarreraRequestDTO;
import tpintegrador3.Service.Estudiante_CarreraService;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class Csv {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private Estudiante_CarreraService estudiante_carreraService;



    public void csv() throws IOException, Exception {
        cargarDatosEstudiante();
        cargarDatosCarrera();
        cargarDatosEstudianteCarrera();
    }


    public void cargarDatosEstudiante() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/tpintegrador3/CSV/estudiantes.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();

                estudiante.setIdEstudiante(Long.parseLong(csvRecord.get("nroDocumento")));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setCiudadResidencia(csvRecord.get("ciudadResidencia"));
                estudiante.setNroLibreta(Integer.parseInt(csvRecord.get("nroLibreta")));

                this.estudianteRepository.save(estudiante); //guarda al estudiante en la base de datos
            }
        }
    }

    public void cargarDatosCarrera() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/tpintegrador3/CSV/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();

                carrera.setNombre(csvRecord.get("nombreCarrera"));


                this.carreraRepository.save(carrera);
            }
        }
    }

    public void cargarDatosEstudianteCarrera() throws IOException, Exception {
        File archivoCSV = ResourceUtils.getFile("src/main/java/tpintegrador3/CSV/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante e = this.estudianteRepository.findById(Long.parseLong(csvRecord.get("idEstudiante"))).get();
                Carrera c = this.carreraRepository.findById(Long.parseLong(csvRecord.get("idCarrera"))).get();
                Estudiante_CarreraRequestDTO estudiante_carrera = new Estudiante_CarreraRequestDTO
                                    (e.getIdEstudiante(),
                                    c.getIdCarrera(), Integer.parseInt(csvRecord.get("antiguedad")),
                                    Boolean.parseBoolean(csvRecord.get("graduado")));



                this.estudiante_carreraService.save(estudiante_carrera); //guarda a la matriculacion en la base de datos
            }
        }
    }
}
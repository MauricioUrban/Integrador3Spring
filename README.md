# Integrador 3 Spring Boot

### a) Dar de alta un estudiante
- Método HTTP: POST
- Endpoint: localhost:8083/estudiantes/save
- Json de prueba: 
{
    "nombre" : "Pepa",
    "apellido" : "Papa",
    "edad" : 45,
    "genero" : "Female",
    "nroDocumento" : 23566987,
    "ciudadResidencia" : "Olavarría",
    "nroLibreta" : 654456    
}

![Captura de pantalla 2023-11-11 a la(s) 17 01 38](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/99225f20-ffec-4d16-a5ba-4ce0f58122e3)

#

### b) Matricular un estudiante en una carrera
- Método HTTP: POST
- Endpoint: localhost:8083/estudiantes_carreras/save/{idEstudiante}/{idCarrera}/{añoInscripcion}/{graduado}
- Observación:
  - datos usados de ejemplo:
    - {idEstudiante} : 1
    - {idCarrera} : 15
    - {añoInscripcion} : 2023
    - {graduado} : false
![Captura de pantalla 2023-11-11 a la(s) 17 24 07](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/4fefa318-7747-4e35-b241-f1343b7b9b34)

#

### c) Recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiantes/findAllOrderByNombre
- Observación: se listan los estudiantes ordenados alfabéticamente por nombre
![Captura de pantalla 2023-11-11 a la(s) 17 35 16](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/6769204d-3d67-4f5b-8522-adb9361cae05)

#

### d) Recuperar un estudiante, en base a su número de libreta universitaria.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiantes/findByNroLibreta/{nroLibreta}
- Observación:
  - datos usados de ejemplo:
    - {nroLibreta} : 80067  
![Captura de pantalla 2023-11-11 a la(s) 17 38 24](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/29ed088d-1559-496c-8c76-461630653f0c)

#

### e) Recuperar todos los estudiantes, en base a su género.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiantes/findByGenero/{genero}
- Observación:
  - datos usados de ejemplo:
    - {genero} : Male

![Captura de pantalla 2023-11-11 a la(s) 17 46 41](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/c324fd92-baeb-4cff-a1e7-e273e5902510)

#

### f) Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiantes_carreras/getCarrerasConInscriptos
- Observación: nos devuelve las carreras con Inscriptos ordenada de mayor a menor cantidad de inscriptos
  
![Captura de pantalla 2023-11-11 a la(s) 17 58 52](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/78aec2c5-4176-4e70-ad82-5a7169205519)

#

### g) Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiantes/findEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}
- Observación:
  - datos usados de ejemplo:
    - {nombreCarrera} : Medicina
    - {ciudadResidencia} : Miami
      
![Captura de pantalla 2023-11-11 a la(s) 18 02 52](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/9d0052ef-03a1-42bc-bf70-198a0f1f0f8c)

#

### h) generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiantes_carreras/reporteEstudiantesPorCarrera

<<<<<<< HEAD
![Captura de pantalla 2023-11-11 a la(s) 19.33.09.png](..%2F..%2F..%2F..%2F..%2F..%2Fvar%2Ffolders%2Fhd%2Ffzw5hgnj10n48vhkbckgqc3c0000gn%2FT%2FTemporaryItems%2FNSIRD_screencaptureui_sHQQWR%2FCaptura%20de%20pantalla%202023-11-11%20a%20la%28s%29%2019.33.09.png)
=======
![Captura de pantalla 2023-11-11 a la(s) 19 28 33](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/f93cfbe3-b615-4213-bbab-dfcab8ebbfd3)

>>>>>>> 88c7dd35ee842816ae8db24561199ffd6268137d


 




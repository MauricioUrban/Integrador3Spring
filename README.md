# Integrador 3 Spring Boot

### a) Dar de alta un estudiante
- Método HTTP: POST
- Endpoint: localhost:8083/estudiante/save
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
- Endpoint: localhost:8083/estudiante_carrera/save/{idEstudiante}/{idCarrera}/{añoInscripcion}/{graduado}
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
- Endpoint: localhost:8083/estudiante/findAllOrderByNombre
- Observación: se listan los estudiantes ordenados alfabéticamente por nombre
![Captura de pantalla 2023-11-11 a la(s) 17 35 16](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/6769204d-3d67-4f5b-8522-adb9361cae05)

#

### d) Recuperar un estudiante, en base a su número de libreta universitaria.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiante/findByNroLibreta/{nroLibreta}
- Observación:
  - datos usados de ejemplo:
    - {nroLibreta} : 80067  
![Captura de pantalla 2023-11-11 a la(s) 17 38 24](https://github.com/MauricioUrban/Integrador3Spring/assets/126684289/29ed088d-1559-496c-8c76-461630653f0c)

#

### e) Recuperar todos los estudiantes, en base a su género.
- Método HTTP: GET
- Endpoint: localhost:8083/estudiante/findByGenero/{genero}
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






 




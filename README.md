#  Hospital Backend API

API REST desarrollada con Spring Boot y Java 17 para la gestión de un sistema hospitalario.

##  Backlog del proyecto
 [Ver Trello](https://trello.com/invite/b/69ed80e55a05ad78549a676e/ATTI32b0b6c67407df58ae9909de04e165e074221DC7/backend)

##  Tecnologías
- Java 17
- Spring Boot 4.0.6
- Spring Data JPA
- PostgreSQL
- Docker
- Maven
- Swagger (SpringDoc OpenAPI)
- GitHub Actions (CI/CD)

##  Estructura del proyecto
src/main/java/com/hospital/backend/
├── controller/    → Recibe las peticiones HTTP
├── service/       → Lógica de negocio (interfaces)
│   └── impl/      → Implementación de los servicios
├── repository/    → Comunicación con la base de datos
├── model/         → Entidades de la base de datos
├── dto/           → Objetos de transferencia de datos
├── mapper/        → Conversión entre Model y DTO
└── config/        → Configuración CORS y Swagger

##  Entidades
- **Patient** → Paciente
- **Doctor** → Médico  
- **Appointment** → Cita médica

##  Endpoints

### Patients
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/patients | Obtener todos |
| GET | /api/patients/{id} | Obtener por ID |
| POST | /api/patients | Crear |
| PUT | /api/patients/{id} | Actualizar |
| DELETE | /api/patients/{id} | Eliminar |

### Doctors
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/doctors | Obtener todos |
| GET | /api/doctors/{id} | Obtener por ID |
| POST | /api/doctors | Crear |
| PUT | /api/doctors/{id} | Actualizar |
| DELETE | /api/doctors/{id} | Eliminar |

### Appointments
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/appointments | Obtener todos |
| GET | /api/appointments/{id} | Obtener por ID |
| POST | /api/appointments | Crear |
| PUT | /api/appointments/{id} | Actualizar |
| DELETE | /api/appointments/{id} | Eliminar |

##  Ramas
| Rama | Descripción |
|------|-------------|
| `main` | Producción, nunca se toca directo |
| `release` | Versión lista para entregar |
| `qa` | Ambiente de pruebas |
| `develop` | Integración del trabajo |
| `feature/HU-XX` | Una rama por historia de usuario |

##  Cómo ejecutar

### Con Docker
```bash
docker-compose up
```

### Sin Docker
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

##  Ambientes
| Ambiente | Archivo |
|----------|---------|
| Desarrollo | application-dev.properties |
| QA | application-qa.properties |
| Producción | application-prod.properties |

##  Documentación API
Una vez levantado el proyecto accede a:
 http://localhost:8080/swagger-ui.html
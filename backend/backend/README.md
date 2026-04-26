##  Entidades
- **Patient** → Paciente
- **Doctor** → Médico
- **Appointment** → Cita médica

##  Endpoints

### Patients
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/patients | Obtener todos |
| GET | /api/patients/{id} | Obtener uno |
| POST | /api/patients | Crear |
| PUT | /api/patients/{id} | Actualizar |
| DELETE | /api/patients/{id} | Eliminar |

### Doctors
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/doctors | Obtener todos |
| GET | /api/doctors/{id} | Obtener uno |
| POST | /api/doctors | Crear |
| PUT | /api/doctors/{id} | Actualizar |
| DELETE | /api/doctors/{id} | Eliminar |

### Appointments
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | /api/appointments | Obtener todos |
| GET | /api/appointments/{id} | Obtener uno |
| POST | /api/appointments | Crear |
| PUT | /api/appointments/{id} | Actualizar |
| DELETE | /api/appointments/{id} | Eliminar |

##  Cómo ejecutar

### Con Docker
```bash
docker-compose up
```

### Sin Docker
```bash
mvn spring-boot:run
```

##  Variables de entorno
- `DB_URL` → URL de la base de datos
- `DB_USERNAME` → Usuario de PostgreSQL
- `DB_PASSWORD` → Contraseña de PostgreSQL
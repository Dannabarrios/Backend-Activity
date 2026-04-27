package com.hospital.backend.controller;

import com.hospital.backend.dto.AppointmentDTO;
import com.hospital.backend.mapper.AppointmentMapper;
import com.hospital.backend.model.Appointment;
import com.hospital.backend.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
@Tag(name = "Appointments", description = "Gestión de citas médicas")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @PostMapping
    @Operation(summary = "Crear cita médica")
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO dto) {
        Appointment appointment = appointmentMapper.toModel(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appointmentMapper.toDTO(appointmentService.create(appointment)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar cita médica")
    public ResponseEntity<AppointmentDTO> update(@PathVariable UUID id, @RequestBody AppointmentDTO dto) {
        return ResponseEntity.ok(appointmentMapper.toDTO(appointmentService.update(id, appointmentMapper.toModel(dto))));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cita médica")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener cita por ID")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(appointmentMapper.toDTO(appointmentService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Obtener todas las citas")
    public ResponseEntity<List<AppointmentDTO>> findAll() {
        return ResponseEntity.ok(appointmentService.findAll()
                .stream().map(appointmentMapper::toDTO).collect(Collectors.toList()));
    }
}
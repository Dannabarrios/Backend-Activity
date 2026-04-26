package com.hospital.backend.controller;

import com.hospital.backend.dto.PatientDTO;
import com.hospital.backend.mapper.PatientMapper;
import com.hospital.backend.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@Tag(name = "Patients", description = "Gestión de pacientes")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @PostMapping
    @Operation(summary = "Crear paciente")
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(patientMapper.toDTO(patientService.create(patientMapper.toModel(dto))));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar paciente")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO dto) {
        return ResponseEntity.ok(patientMapper.toDTO(patientService.update(id, patientMapper.toModel(dto))));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar paciente")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener paciente por ID")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(patientMapper.toDTO(patientService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los pacientes")
    public ResponseEntity<List<PatientDTO>> findAll() {
        return ResponseEntity.ok(patientService.findAll()
                .stream().map(patientMapper::toDTO).collect(Collectors.toList()));
    }
}
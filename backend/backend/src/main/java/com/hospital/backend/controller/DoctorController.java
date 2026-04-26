package com.hospital.backend.controller;

import com.hospital.backend.dto.DoctorDTO;
import com.hospital.backend.mapper.DoctorMapper;
import com.hospital.backend.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
@Tag(name = "Doctors", description = "Gestión de médicos")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @PostMapping
    @Operation(summary = "Crear médico")
    public ResponseEntity<DoctorDTO> create(@RequestBody DoctorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(doctorMapper.toDTO(doctorService.create(doctorMapper.toModel(dto))));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar médico")
    public ResponseEntity<DoctorDTO> update(@PathVariable Long id, @RequestBody DoctorDTO dto) {
        return ResponseEntity.ok(doctorMapper.toDTO(doctorService.update(id, doctorMapper.toModel(dto))));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar médico")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        doctorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener médico por ID")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorMapper.toDTO(doctorService.findById(id)));
    }

    @GetMapping
    @Operation(summary = "Obtener todos los médicos")
    public ResponseEntity<List<DoctorDTO>> findAll() {
        return ResponseEntity.ok(doctorService.findAll()
                .stream().map(doctorMapper::toDTO).collect(Collectors.toList()));
    }
}
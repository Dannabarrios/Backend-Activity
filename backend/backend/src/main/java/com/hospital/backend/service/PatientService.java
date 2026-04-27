package com.hospital.backend.service;

import com.hospital.backend.model.Patient;
import java.util.List;
import java.util.UUID;

public interface PatientService {
    Patient create(Patient patient);
    Patient update(UUID id, Patient patient);
    void delete(UUID id);
    Patient findById(UUID id);
    List<Patient> findAll();
}
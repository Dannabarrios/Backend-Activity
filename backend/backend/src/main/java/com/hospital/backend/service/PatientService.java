package com.hospital.backend.service;

import com.hospital.backend.model.Patient;
import java.util.List;

public interface PatientService {
    Patient create(Patient patient);
    Patient update(Long id, Patient patient);
    void delete(Long id);
    Patient findById(Long id);
    List<Patient> findAll();
}
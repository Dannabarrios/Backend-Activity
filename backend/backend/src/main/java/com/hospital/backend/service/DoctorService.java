package com.hospital.backend.service;

import com.hospital.backend.model.Doctor;
import java.util.List;
import java.util.UUID;

public interface DoctorService {
    Doctor create(Doctor doctor);
    Doctor update(UUID id, Doctor doctor);
    void delete(UUID id);
    Doctor findById(UUID id);
    List<Doctor> findAll();
}
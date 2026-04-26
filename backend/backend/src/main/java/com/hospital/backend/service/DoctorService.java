package com.hospital.backend.service;

import com.hospital.backend.model.Doctor;
import java.util.List;

public interface DoctorService {
    Doctor create(Doctor doctor);
    Doctor update(Long id, Doctor doctor);
    void delete(Long id);
    Doctor findById(Long id);
    List<Doctor> findAll();
}
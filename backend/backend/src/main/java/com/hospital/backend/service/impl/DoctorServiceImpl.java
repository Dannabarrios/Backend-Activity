package com.hospital.backend.service.impl;

import com.hospital.backend.model.Doctor;
import com.hospital.backend.repository.DoctorRepository;
import com.hospital.backend.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Long id, Doctor doctor) {
        Doctor existing = findById(id);
        existing.setName(doctor.getName());
        existing.setSpecialty(doctor.getSpecialty());
        existing.setEmail(doctor.getEmail());
        existing.setPhone(doctor.getPhone());
        return doctorRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
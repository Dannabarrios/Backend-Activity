package com.hospital.backend.mapper;

import com.hospital.backend.dto.DoctorDTO;
import com.hospital.backend.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public DoctorDTO toDTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setId(doctor.getId());
        dto.setName(doctor.getName());
        dto.setSpecialty(doctor.getSpecialty());
        dto.setEmail(doctor.getEmail());
        dto.setPhone(doctor.getPhone());
        return dto;
    }

    public Doctor toModel(DoctorDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setEmail(dto.getEmail());
        doctor.setPhone(dto.getPhone());
        return doctor;
    }
}
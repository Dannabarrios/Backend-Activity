package com.hospital.backend.mapper;

import com.hospital.backend.dto.AppointmentDTO;
import com.hospital.backend.model.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentDTO toDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setId(appointment.getId());
        dto.setPatientId(appointment.getPatient().getId());
        dto.setPatientName(appointment.getPatient().getName());
        dto.setDoctorId(appointment.getDoctor().getId());
        dto.setDoctorName(appointment.getDoctor().getName());
        dto.setAppointmentDate(appointment.getAppointmentDate().toString());
        dto.setStatus(appointment.getStatus());
        return dto;
    }

    public Appointment toModel(AppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setStatus(dto.getStatus());
        return appointment;
    }
}
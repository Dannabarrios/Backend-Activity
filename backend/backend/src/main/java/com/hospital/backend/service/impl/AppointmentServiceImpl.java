package com.hospital.backend.service.impl;

import com.hospital.backend.model.Appointment;
import com.hospital.backend.repository.AppointmentRepository;
import com.hospital.backend.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(UUID id, Appointment appointment) {
        Appointment existing = findById(id);
        existing.setPatient(appointment.getPatient());
        existing.setDoctor(appointment.getDoctor());
        existing.setAppointmentDate(appointment.getAppointmentDate());
        existing.setStatus(appointment.getStatus());
        return appointmentRepository.save(existing);
    }

    @Override
    public void delete(UUID id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment findById(UUID id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
}
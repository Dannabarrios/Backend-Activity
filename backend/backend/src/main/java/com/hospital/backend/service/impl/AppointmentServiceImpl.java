package com.hospital.backend.service.impl;

import com.hospital.backend.model.Appointment;
import com.hospital.backend.repository.AppointmentRepository;
import com.hospital.backend.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        Appointment existing = findById(id);
        existing.setPatient(appointment.getPatient());
        existing.setDoctor(appointment.getDoctor());
        existing.setAppointmentDate(appointment.getAppointmentDate());
        existing.setStatus(appointment.getStatus());
        return appointmentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
}
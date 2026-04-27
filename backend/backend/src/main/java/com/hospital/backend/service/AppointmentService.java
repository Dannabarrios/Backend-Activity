package com.hospital.backend.service;

import com.hospital.backend.model.Appointment;
import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    Appointment create(Appointment appointment);
    Appointment update(UUID id, Appointment appointment);
    void delete(UUID id);
    Appointment findById(UUID id);
    List<Appointment> findAll();
}
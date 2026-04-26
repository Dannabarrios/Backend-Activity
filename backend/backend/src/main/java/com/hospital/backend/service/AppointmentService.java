package com.hospital.backend.service;

import com.hospital.backend.model.Appointment;
import java.util.List;

public interface AppointmentService {
    Appointment create(Appointment appointment);
    Appointment update(Long id, Appointment appointment);
    void delete(Long id);
    Appointment findById(Long id);
    List<Appointment> findAll();
}
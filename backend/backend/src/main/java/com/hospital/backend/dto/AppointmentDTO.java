package com.hospital.backend.dto;

import lombok.Data;

@Data
public class AppointmentDTO {
    private Long id;
    private Long patientId;
    private String patientName;
    private Long doctorId;
    private String doctorName;
    private String appointmentDate;
    private String status;
}
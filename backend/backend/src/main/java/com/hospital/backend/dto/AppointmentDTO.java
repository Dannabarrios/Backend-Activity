package com.hospital.backend.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class AppointmentDTO {
    private UUID id;
    private UUID patientId;
    private String patientName;
    private UUID doctorId;
    private String doctorName;
    private String appointmentDate;
    private String status;
}
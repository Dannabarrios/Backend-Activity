package com.hospital.backend.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class DoctorDTO {
    private UUID id;
    private String name;
    private String specialty;
    private String email;
    private String phone;
}
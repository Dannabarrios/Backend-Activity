package com.hospital.backend.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PatientDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
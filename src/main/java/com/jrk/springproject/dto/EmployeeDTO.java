package com.jrk.springproject.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private Date dateOfBirth;
    private String countryOfBirth;
    private Long bicycleId;
}

package com.blumbit.web.api.store.dto;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class EmployeeDto {

    private String employeeId;
    private String lastName;
    private String firstName;
    private String title;
    private String reportsTo;
    private LocalDateTime birthDate;
    private LocalDateTime hireDate;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

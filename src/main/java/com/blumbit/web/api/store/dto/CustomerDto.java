package com.blumbit.web.api.store.dto;

import com.blumbit.web.api.store.entity.Employee;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class CustomerDto {

    private String customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
    private Employee supportRepId;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

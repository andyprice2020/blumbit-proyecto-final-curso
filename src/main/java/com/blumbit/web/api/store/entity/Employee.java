package com.blumbit.web.api.store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Setter
@Table(name = "employees", schema = "store")
public class Employee {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "employee_id", nullable = false, unique = true)
    private UUID employeeId;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(length = 10)
    private String title;

    @Column(name = "reports_to", length = 80)
    private String reportsTo;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "hire_date")
    private LocalDateTime hireDate;

    @Column(length = 200)
    private String address;

    @Column(length = 80)
    private String city;

    @Column(length = 80)
    private String state;

    @Column(length = 80)
    private String country;

    @Column(name = "postal_code", length = 20)
    private String postalCode;

    @Column(length = 30)
    private String phone;

    @Column(length = 30)
    private String fax;

    @Column(length = 80)
    @Email
    private String email;

    private boolean enabled;

    @CreatedBy
    @Column(name = "created_by_user", nullable = false, length = 50)
    private String createdByUser;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by_user", nullable = false, length = 50)
    private String lastModifiedByUser;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;

    @Version
    @Column(name = "count_modified")
    private long countModified;
}

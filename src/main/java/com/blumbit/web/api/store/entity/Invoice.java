package com.blumbit.web.api.store.entity;

import jakarta.persistence.*;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Setter
@Table(name = "invoices", schema = "store")
public class Invoice {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "invoice_id", nullable = false, unique = true)
    private UUID invoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @Column(name = "invoice_date")
    private LocalDateTime invoiceDate;

    @Column(name = "billing_address", length = 200)
    private String billingAddress;

    @Column(name = "billing_city", length = 80)
    private String billingCity;

    @Column(name = "billing_state", length = 80)
    private String billingState;

    @Column(name = "billing_country", length = 80)
    private String billingCountry;

    @Column(name = "billing_postal_code", length = 20)
    private String billingPostalCode;

    private BigDecimal total;

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

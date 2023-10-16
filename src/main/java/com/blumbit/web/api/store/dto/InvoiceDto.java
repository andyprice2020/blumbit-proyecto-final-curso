package com.blumbit.web.api.store.dto;

import com.blumbit.web.api.store.entity.Customer;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class InvoiceDto {

    private String invoiceId;
    private Customer customerId;
    private LocalDateTime invoiceDate;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingPostalCode;
    private BigDecimal total;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

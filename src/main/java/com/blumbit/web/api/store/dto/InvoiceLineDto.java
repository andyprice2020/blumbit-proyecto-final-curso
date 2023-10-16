package com.blumbit.web.api.store.dto;

import com.blumbit.web.api.store.entity.Invoice;
import com.blumbit.web.api.store.entity.Track;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class InvoiceLineDto {

    private String invoiceLineId;
    private Invoice invoiceId;
    private Track trackId;
    private BigDecimal unitPrice;
    private BigDecimal quantity;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

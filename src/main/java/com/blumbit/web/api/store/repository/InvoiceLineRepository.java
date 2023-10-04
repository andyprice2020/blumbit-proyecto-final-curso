package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, UUID> {
}

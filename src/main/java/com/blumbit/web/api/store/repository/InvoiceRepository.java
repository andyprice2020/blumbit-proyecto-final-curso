package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InvoiceRepository extends JpaRepository<Invoice, UUID> {
}

package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}

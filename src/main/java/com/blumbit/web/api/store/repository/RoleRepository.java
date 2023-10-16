package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.ERole;
import com.blumbit.web.api.store.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(ERole nombreRol);
}

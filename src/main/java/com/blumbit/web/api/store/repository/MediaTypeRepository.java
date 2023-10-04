package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MediaTypeRepository extends JpaRepository<MediaType, UUID> {
}

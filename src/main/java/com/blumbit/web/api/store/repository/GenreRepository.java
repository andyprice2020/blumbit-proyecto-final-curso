package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
}

package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, UUID> {
}

package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaylistRepository extends JpaRepository<Playlist, UUID> {
}

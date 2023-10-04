package com.blumbit.web.api.store.repository;

import com.blumbit.web.api.store.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackRepository extends JpaRepository<Track, UUID> {
}

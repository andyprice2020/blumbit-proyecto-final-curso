package com.blumbit.web.api.store.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.blumbit.web.api.store.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, UUID> {

    Optional<Artist> findByArtistId(UUID id);
    Page<Artist> findAll(Pageable pageable);
}

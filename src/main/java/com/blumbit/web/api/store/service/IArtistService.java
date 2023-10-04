package com.blumbit.web.api.store.service;

import com.blumbit.web.api.store.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IArtistService {

    List<Artist> findAll();
    Page<Artist> findAll(int initPage, int size, boolean enablePagination);
    Optional<Artist> findArtistByID(UUID id);
    Artist save(Artist newArtist);
    Artist update(UUID id, Artist updArtist);
    Artist delete(UUID id);
}

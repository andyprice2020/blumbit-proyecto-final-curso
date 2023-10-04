package com.blumbit.web.api.store.service.impl;

import com.blumbit.web.api.store.entity.Artist;
import com.blumbit.web.api.store.repository.ArtistRepository;
import com.blumbit.web.api.store.service.IArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements IArtistService {

    private final ArtistRepository artistRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Artist> findAll(int initPage, int size, boolean enablePagination) {
        return artistRepository.findAll(enablePagination ? PageRequest.of(initPage, size): Pageable.unpaged());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Artist> findArtistByID(UUID id) {
        return artistRepository.findByArtistId(id);
    }

    @Override
    @Transactional
    public Artist save(Artist newArtist) {
        return artistRepository.save(newArtist);
    }

    @Override
    @Transactional
    public Artist update(UUID id, Artist updArtist) {

        var updatedArtist = artistRepository.findByArtistId(id);

        if (updatedArtist.isPresent()) {
            updatedArtist.get().setName(updArtist.getName());
            updatedArtist.get().setEnabled(updArtist.isEnabled());
        }
        return artistRepository.save(updatedArtist.get());
    }
    @Override
    @Transactional
    public Artist delete(UUID id) {

        var deletedArtist = artistRepository.findByArtistId(id);
        deletedArtist.ifPresent(delArtist-> delArtist.setEnabled(false));
        return artistRepository.save(deletedArtist.get());
    }
}

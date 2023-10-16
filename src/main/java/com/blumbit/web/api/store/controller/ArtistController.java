package com.blumbit.web.api.store.controller;

import com.blumbit.web.api.store.dto.ArtistDto;
import com.blumbit.web.api.store.entity.Artist;
import com.blumbit.web.api.store.service.IArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class ArtistController {

    private final IArtistService artistService;
    private final ModelMapper modelMapper = new ModelMapper();
    @GetMapping("/artists")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ArtistDto>> getAllArtists() {

        try {
            log.debug("Listado completo de registros");
            return new ResponseEntity<>(artistService.findAll().stream().map(
                    allArtists->modelMapper.map(allArtists, ArtistDto.class))
                    .collect(Collectors.toList()), HttpStatus.OK);
        }
        catch (DataAccessException daex) {
            log.error("Error al obtener el listado " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/artists/pageable")
    public ResponseEntity<Page<Artist>> getPageableArtists(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                           @RequestParam(required = false, defaultValue = "10") Integer size,
                                                           @RequestParam(required = false, defaultValue = "name") String order,
                                                           @RequestParam(required = false, defaultValue = "true")Boolean asc) {
        try {
            log.debug("Paginación de registros");
            var artists = artistService.findAll(PageRequest.of(page, size, Sort.by(order)));
            // Si elegiumos el orden descendente...
            if (!asc) {
                artists = artistService.findAll(PageRequest.of(page, size, Sort.by(order).descending()));
            }
            return new ResponseEntity<>(artists, HttpStatus.OK);
        }
        catch (DataAccessException daex) {
            log.error("Error al obtener la paginación " + daex.getMostSpecificCause());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

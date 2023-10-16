package com.blumbit.web.api.store.dto;

import com.blumbit.web.api.store.entity.Album;
import com.blumbit.web.api.store.entity.Genre;
import com.blumbit.web.api.store.entity.MediaType;
import com.blumbit.web.api.store.entity.Playlist;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Data
public class TrackDto {

    private String trackId;
    private String name;
    private Album albumId;
    private MediaType mediaTypeId;
    private Genre genreId;
    private Set<Playlist> playlists = new HashSet<>();
    private String composer;
    private Integer milliseconds;
    private Integer bytes;
    private BigDecimal unitPrice;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

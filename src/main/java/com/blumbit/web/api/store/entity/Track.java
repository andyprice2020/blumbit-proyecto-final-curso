package com.blumbit.web.api.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Setter
@Table(name = "tracks", schema = "store")
public class Track {

    @Id
    @UuidGenerator
    @Column(name = "track_id", nullable = false, unique = true)
    private UUID trackId;

    @Column(nullable = false, length = 80)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album albumId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_type_id")
    private MediaType mediaTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genreId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "playlist_tracks", schema = "store",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private Set<Playlist> playlists = new HashSet<>();

    @Column(length = 80)
    private String composer;

    @Column(nullable = false)
    private Integer milliseconds;

    private Integer bytes;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    private boolean enabled;

    @CreatedBy
    @Column(name = "created_by_user", nullable = false, length = 50)
    private String createdByUser;

    @CreatedDate
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by_user", nullable = false, length = 50)
    private String lastModifiedByUser;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    private LocalDateTime lastModifiedDate;

    @Version
    @Column(name = "count_modified")
    private long countModified;
}

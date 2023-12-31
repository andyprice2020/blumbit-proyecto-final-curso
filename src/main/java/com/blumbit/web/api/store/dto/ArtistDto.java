package com.blumbit.web.api.store.dto;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class ArtistDto {

    private String artistId;
    private String name;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

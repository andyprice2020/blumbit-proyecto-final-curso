package com.blumbit.web.api.store.dto;

import com.blumbit.web.api.store.entity.Artist;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class AlbumDto {

    private Integer albumId;
    private Artist artistId;
    private String title;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

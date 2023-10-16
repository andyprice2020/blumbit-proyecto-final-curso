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

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Setter
@Table(name = "media_types", schema = "store")
public class MediaType {

    @Id
    @UuidGenerator
    @Column(name = "media_type_id", nullable = false, unique = true)
    private UUID mediaTypeId;

    @Column(length = 80)
    private String name;

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

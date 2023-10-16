package com.blumbit.web.api.store.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private Set<String> role;
    private boolean enabled;
    private String createdByUser;
    private LocalDateTime createdDate;
    private String lastModifiedByUser;
    private LocalDateTime lastModifiedDate;
    private long countModified;
}

package com.blumbit.web.api.store.payload.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private String password;
}

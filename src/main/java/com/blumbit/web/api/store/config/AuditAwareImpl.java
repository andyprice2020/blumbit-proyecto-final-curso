package com.blumbit.web.api.store.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("admin@blumbit.com");
    }
}

package com.pms.gateway;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//@EnableJpaAuditing
class AuditConfig {
//    @Bean
//    public AuditingEntityListener createAuditingListener() {
//        return new AuditingEntityListener();
//    }

}
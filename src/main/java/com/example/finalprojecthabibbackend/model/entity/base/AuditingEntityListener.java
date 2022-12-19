package com.example.finalprojecthabibbackend.model.entity.base;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.ZonedDateTime;


@Component
public class AuditingEntityListener {
    @PrePersist
    @PreUpdate
    public void setLastModifiedDate(AbstractEntity entity) {
        if (ObjectUtils.isEmpty(entity.getCreatedDate())) {
            entity.setCreatedDate(ZonedDateTime.now());
        }
        entity.setLastModifiedDate(ZonedDateTime.now());

        if (StringUtils.isEmpty(entity.getCreatedBy())) {
            entity.setCreatedBy("Owner-Habib");
        }

    }
}
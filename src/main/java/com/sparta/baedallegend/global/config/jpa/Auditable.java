package com.sparta.baedallegend.global.config.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private Long createdBy;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    private Long updatedBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private Long deletedBy;
    private LocalDateTime deletedAt;

    public void delete(Long currentUser) {
        deletedBy = currentUser;
        deletedAt = LocalDateTime.now();
    }
}

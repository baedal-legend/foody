package com.sparta.baedallegend.global.config.jpa.audit;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable extends CommonAuditFields {

	@CreatedBy
	@Column(nullable = false, updatable = false)
	protected Long createdBy;

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

}

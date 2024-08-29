package com.sparta.baedallegend.global.config.jpa;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class CommonAuditFields {

	public static final String DELETED_FALSE = "is_deleted = false";

	@LastModifiedBy
	private Long updatedBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	private boolean isDeleted = false;

	public void delete() {
		isDeleted = true;
	}

}

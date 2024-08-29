package com.sparta.baedallegend.global.config.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Embeddable
public abstract class CommonAuditFields {

	@LastModifiedBy
	private Long updatedBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@Column(updatable = false)
	private Long deletedBy;

	@Column(updatable = false)
	private LocalDateTime deletedAt;

	public void delete(Long currentUser) {
		deletedBy = currentUser;
		deletedAt = LocalDateTime.now();
	}

}

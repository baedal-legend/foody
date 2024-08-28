package com.sparta.baedallegend.user.domain.auditor;

import com.sparta.baedallegend.global.config.jpa.CommonAuditFields;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserAuditable {

	protected Long createdBy;
	protected LocalDateTime createdAt;

	protected CommonAuditFields auditableFields;

}

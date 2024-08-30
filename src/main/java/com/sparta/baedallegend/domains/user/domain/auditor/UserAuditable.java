package com.sparta.baedallegend.domains.user.domain.auditor;

import com.sparta.baedallegend.global.config.jpa.audit.CommonAuditFields;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class UserAuditable extends CommonAuditFields {

	protected Long createdBy;
	protected LocalDateTime createdAt;

}

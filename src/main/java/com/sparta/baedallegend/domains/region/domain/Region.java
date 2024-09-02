package com.sparta.baedallegend.domains.region.domain;

import static com.sparta.baedallegend.global.config.jpa.audit.CommonAuditFields.DEFAULT_CONDITION;

import com.sparta.baedallegend.global.config.jpa.audit.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
	name = "p_region",
	uniqueConstraints = {
		@UniqueConstraint(
			name = "UK_REGION_NAME",
			columnNames = "name")
	})
@SQLRestriction(DEFAULT_CONDITION)
public class Region extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;


	public static Region of(String name) {
		return new Region(name);
	}

	private Region(String name) {
		this.name = name;
	}

}

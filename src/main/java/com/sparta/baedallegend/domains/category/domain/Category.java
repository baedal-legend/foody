package com.sparta.baedallegend.domains.category.domain;

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
@Table(
	name = "p_category",
	uniqueConstraints = {
		@UniqueConstraint(
			name = "UK_CATEGORY_NAME",
			columnNames = "name"
		),
		@UniqueConstraint(
			name = "UK_CATEGORY_PRIORITY",
			columnNames = "priority"
		)
	}
)

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction(DEFAULT_CONDITION)
public class Category extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int priority;

	public static Category of(String name, int priority) {
		return new Category(name, priority);
	}

	private Category(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

}

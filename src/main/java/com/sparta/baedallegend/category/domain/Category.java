package com.sparta.baedallegend.category.domain;

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
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int priority;

	// TODO 연관관계 매핑 필요
}

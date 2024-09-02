package com.sparta.baedallegend.domains.order.entity;

import static com.sparta.baedallegend.global.config.jpa.generator.ShortenUUIDGenerator.SHORTEN_UUID_GENERATOR;

import com.sparta.baedallegend.global.config.jpa.generator.ShortenUUIDGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_order")
public class Order {

	@Id
	@GeneratedValue(generator = SHORTEN_UUID_GENERATOR)
	@GenericGenerator(name = SHORTEN_UUID_GENERATOR, type = ShortenUUIDGenerator.class)
	private String id;

	@Column(nullable = false)
	private BigDecimal totalAmount;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private OrderStatus status;

	public Order(BigDecimal totalAmount, OrderStatus status) {
		this.totalAmount = totalAmount;
		this.status = status;
	}

	// todo  : 다른 도메인과 fk 설정이 구현되지 않았음
	// todo :  Auditor 사용을 위한 메타데이터 컬럼들이 구현되지 않았음

}

package com.sparta.baedallegend.domains.order.repo;

import static com.sparta.baedallegend.global.config.jpa.generator.ShortenUUIDGenerator.SHORTEN_UUID_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.sparta.baedallegend.domains.order.entity.Order;
import com.sparta.baedallegend.domains.order.entity.OrderStatus;
import com.sparta.baedallegend.global.base.JpaTestBase;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Repo:Order")
class OrderRepoTest extends JpaTestBase {

	private final OrderRepo orderRepo;

	public OrderRepoTest(OrderRepo orderRepo) {
		this.orderRepo = orderRepo;
	}

	@Test
	@DisplayName("주문 저장")
	void save() {
		// Given
		Order given = new Order(BigDecimal.valueOf(10_000), OrderStatus.COOKING);

		// When
		Order actual = orderRepo.save(given);

		// Then
		assertAll(
			() -> assertThat(actual).isNotNull(),
			() -> assertThat(actual.getId()).hasSize(SHORTEN_UUID_LENGTH)
		);

	}

}

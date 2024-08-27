package com.sparta.baedallegend.shop.domain;

import com.sparta.baedallegend.category.domain.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "p_shop_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	private ShopCategory(Shop shop, Category category) {
		this.shop = shop;
		this.category = category;
	}

	public static ShopCategory of(Shop shop, Category category) {
		return new ShopCategory(shop, category);
	}

}

package com.sparta.baedallegend.domains.shop.domain;

import com.sparta.baedallegend.domains.category.domain.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "FK_SHOP_CATEGORY_TO_SHOP"))
	private Shop shop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "FK_SHOP_CATEGORY_TO_CATEGORY")
	)
	private Category category;

	private ShopCategory(Shop shop, Category category) {
		this.shop = shop;
		this.category = category;
	}

	public static ShopCategory of(Shop shop, Category category) {
		return new ShopCategory(shop, category);
	}

}

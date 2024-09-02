package com.sparta.baedallegend.domains.menu.domain;

import static com.sparta.baedallegend.global.config.jpa.audit.CommonAuditFields.DEFAULT_CONDITION;

import com.sparta.baedallegend.domains.shop.domain.Shop;
import com.sparta.baedallegend.global.config.jpa.audit.Auditable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_menu")
@SQLRestriction(DEFAULT_CONDITION)
public class Menu extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false)
	private int price;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(nullable = false)
	private boolean isPublic;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private MenuStatus menuStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "shop_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "FK_MENU_TO_SHOP")
	)
	private Shop shop;

	public static Menu of(String name, int price, String description, MenuStatus menuStatus,
		Shop shop) {
		return new Menu(name, price, description, menuStatus, shop);
	}

	private Menu(String name, int price, String description,
		MenuStatus menuStatus, Shop shop) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.isPublic = true;
		this.menuStatus = menuStatus;
		this.shop = shop;
	}


}

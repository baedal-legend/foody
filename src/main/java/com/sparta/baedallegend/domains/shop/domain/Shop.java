package com.sparta.baedallegend.domains.shop.domain;

import static com.sparta.baedallegend.global.config.jpa.audit.CommonAuditFields.DEFAULT_CONDITION;

import com.sparta.baedallegend.domains.menu.domain.Menu;
import com.sparta.baedallegend.domains.region.domain.Region;
import com.sparta.baedallegend.domains.user.domain.User;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction(DEFAULT_CONDITION)
@Table(name = "p_shop")
public class Shop extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, name = "phone_number")
	private String phoneNumber;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ShopStatus status;

	@Column(nullable = false)
	private String address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "FK_SHOP_TO_USER")
	)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(
		name = "region_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "FK_SHOP_TO_REGION")
	)
	private Region region;

	@OneToMany(mappedBy = "shop")
	private List<Menu> menus = new ArrayList<>();

	public static Shop of(String name, String phoneNumber, String description, String address,
		User user, Region region) {
		return new Shop(name, phoneNumber, description, address, user, region);
	}

	private Shop(String name, String phoneNumber, String description, String address, User user,
		Region region) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.status = ShopStatus.CLOSED;
		this.address = address;
		this.user = user;
		this.region = region;
	}

	public void addMenu(Menu menu) {
		menus.add(menu);
	}

}

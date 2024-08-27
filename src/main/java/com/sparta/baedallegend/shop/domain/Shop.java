package com.sparta.baedallegend.shop.domain;

import com.sparta.baedallegend.region.domain.Region;
import com.sparta.baedallegend.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "p_shop")
public class Shop {

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

	@Column(nullable = false)
	private boolean isPublic;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;

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
		this.isPublic = true;
		this.user = user;
		this.region = region;
	}

}

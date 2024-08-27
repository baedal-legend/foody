package com.sparta.baedallegend.user.domain;

import com.sparta.baedallegend.auth.controller.model.SignUpType;
import com.sparta.baedallegend.user.domain.wrap.Password;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(
	name = "p_user",
	uniqueConstraints = {
		@UniqueConstraint(name = "UK_USER_EMAIL", columnNames = "email"),
		@UniqueConstraint(name = "UK_USER_NICKNAME", columnNames = "nickname")
	}
)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(nullable = false, length = 45)
	private String nickname;

	@AttributeOverride(name = "value", column = @Column(name = "password"))
	private Password password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 45)
	private Role role;

	public User(String email, String name, String nickname, Password password, Role role) {
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.password = password;
		this.role = role;
	}

	public static User of(
		String email,
		Password encodedPassword,
		String name,
		String nickname,
		SignUpType signUpType
	) {
		return new User(email, name, nickname, encodedPassword, Role.valueOf(signUpType.name()));
	}

	// TODO : Auditor 사용을 위한 메타데이터 컬럼들이 구현되지 않았음
}

package com.sparta.baedallegend.domains.user.domain;

import static com.sparta.baedallegend.global.config.jpa.audit.CommonAuditFields.DELETED_FALSE;

import com.sparta.baedallegend.domains.user.domain.wrap.Password;
import com.sparta.baedallegend.domains.user.domain.auditor.UserAuditable;
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
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

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
@SQLRestriction(DELETED_FALSE)
public class User extends UserAuditable {

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
		Role signUpType
	) {
		return new User(email, name, nickname, encodedPassword, signUpType);
	}

	public void applyUserCreated(Long id) {
		createdBy = id;
		createdAt = LocalDateTime.now();
	}

	public String getPassword() {
		return password.getValue();
	}

	public String getRoleDetails() {
		return role.getDescription();
	}

}

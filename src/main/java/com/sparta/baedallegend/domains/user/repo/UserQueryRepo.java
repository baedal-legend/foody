package com.sparta.baedallegend.domains.user.repo;

import static com.sparta.baedallegend.domains.user.domain.QUser.user;

import com.querydsl.jpa.JPQLQueryFactory;
import com.sparta.baedallegend.domains.user.controller.model.QUserResponse;
import com.sparta.baedallegend.domains.user.controller.model.UserResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserQueryRepo {

	private final JPQLQueryFactory queryFactory;

	public Optional<UserResponse> findUserById(Long id) {
		return Optional.ofNullable(queryFactory.select(
				new QUserResponse(
					user.id,
					user.email,
					user.nickname,
					user.role.stringValue()
				))
			.from(user)
			.where(user.id.eq(id))
			.fetchOne());
	}

}

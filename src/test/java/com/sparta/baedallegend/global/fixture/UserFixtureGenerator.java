package com.sparta.baedallegend.global.fixture;

import com.sparta.baedallegend.domains.user.domain.Role;
import com.sparta.baedallegend.domains.user.domain.User;
import com.sparta.baedallegend.domains.user.domain.wrap.Password;

public class UserFixtureGenerator {

	public static User generateUserFixture() {
		return User.of("customer@foody.io",
			Password.from("password"),
			"홍길동",
			"RED홍",
			Role.CUSTOMER
		);
	}

}

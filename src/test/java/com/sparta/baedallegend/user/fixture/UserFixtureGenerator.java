package com.sparta.baedallegend.user.fixture;

import com.sparta.baedallegend.user.domain.Role;
import com.sparta.baedallegend.user.domain.User;
import com.sparta.baedallegend.user.domain.wrap.Password;

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

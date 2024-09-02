package com.sparta.baedallegend.domains.user.repo;

import static com.sparta.baedallegend.global.fixture.UserFixtureGenerator.generateUserFixture;
import static org.assertj.core.api.Assertions.assertThat;

import com.sparta.baedallegend.global.base.JpaTestBase;
import com.sparta.baedallegend.global.config.QueryDslTestConfig;
import com.sparta.baedallegend.domains.user.controller.model.UserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

@DisplayName("Query:Repo:User")
@Import(QueryDslTestConfig.class)
class UserQueryRepoTest extends JpaTestBase {

	private final UserQueryRepo userQueryRepo;

	public UserQueryRepoTest(UserQueryRepo userQueryRepo) {
		this.userQueryRepo = userQueryRepo;
	}

	@BeforeEach
	void setUp() {
		entityManager.persist(generateUserFixture());
		entityManager.flush();
	}

	@Test
	@DisplayName("회원 조회")
	void findMemberById() {
		// When
		UserResponse actual = Assertions.assertDoesNotThrow(
			() -> userQueryRepo.findUserById(1L).orElseThrow()
		);

		// Then
		assertThat(actual).isNotNull();
	}

}

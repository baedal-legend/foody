package com.sparta.baedallegend.global.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sparta.baedallegend.domains.user.repo.UserQueryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class QueryDslTestConfig {

	@PersistenceContext
	private EntityManager entityManager;

	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(entityManager);
	}

	@Bean
	public UserQueryRepo userQueryRepo() {
		return new UserQueryRepo(jpaQueryFactory());
	}

}

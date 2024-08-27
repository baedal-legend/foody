package com.sparta.baedallegend.base;

import com.github.gavlyukovskiy.boot.jdbc.decorator.DataSourceDecoratorAutoConfiguration;
import com.sparta.baedallegend.config.P6spySqlFormatConfig;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@DataJpaTest(showSql = false)
@Import(P6spySqlFormatConfig.class)
@ImportAutoConfiguration(DataSourceDecoratorAutoConfiguration.class)
public abstract class JpaTestBase extends TestBase {

	public static final String POSTGRES_IMAGE = "postgres:16.4";

	@Resource
	private EntityManager entityManager;

	protected void flushAndClear() {
		entityManager.flush();
		entityManager.clear();
	}

	@Container
	static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(POSTGRES_IMAGE)
		.withDatabaseName("test_foody")
		.withUsername("test_foody")
		.withPassword("test_foody_pass");

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
	}

}

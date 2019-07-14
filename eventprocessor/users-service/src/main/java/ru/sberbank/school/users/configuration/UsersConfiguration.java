package ru.sberbank.school.users.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EntityScan("ru.sberbank.school.users.entity")
@EnableJpaRepositories("ru.sberbank.school.users.repository")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class UsersConfiguration {

    private static final String DB_DRIVER = "db.driver";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final String LIQUIBASE_CHANGELOG = "liquibase.changelog";

    @Resource
    Environment env;

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(env.getRequiredProperty(DB_DRIVER));
        hikariConfig.setJdbcUrl(env.getRequiredProperty(DB_URL));
        hikariConfig.setUsername(env.getRequiredProperty(DB_USERNAME));
        hikariConfig.setPassword(env.getRequiredProperty(DB_PASSWORD));
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(env.getRequiredProperty(LIQUIBASE_CHANGELOG));
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}

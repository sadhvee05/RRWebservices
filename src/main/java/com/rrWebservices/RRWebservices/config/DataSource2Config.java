package com.rrWebservices.RRWebservices.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableJpaRepositories(
    basePackages = "com.rrWebservices.RRWebservices.RepoDB2",
    entityManagerFactoryRef = "entityManagerFactory2",
    transactionManagerRef = "transactionManager2"
)
public class DataSource2Config {

    @Bean
    @ConfigurationProperties("spring.datasource2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory2(
        EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(dataSource2())
            .packages("com.rrWebservices.RRWebservices.EntitySldb")
            .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager2(
        @Qualifier("entityManagerFactory2") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

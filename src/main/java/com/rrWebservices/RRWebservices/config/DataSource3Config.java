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
    basePackages = "com.rrWebservices.RRWebservices.Repository",
    entityManagerFactoryRef = "entityManagerFactory3",
    transactionManagerRef = "transactionManager3")
public class DataSource3Config {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource3() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory3(
        EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(dataSource3())
            .packages("com.rrWebservices.RRWebservices.Entity")
            .build();
    }

    @Bean
    public PlatformTransactionManager transactionManager3(
        @Qualifier("entityManagerFactory3") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

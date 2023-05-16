package com.rrWebservices.RRWebservices.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.rrWebservices.RRWebservices.RepoDB",
    entityManagerFactoryRef = "entityManagerFactory1",
    transactionManagerRef = "transactionManager1"
)
public class DataSource1Config {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource1")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory1(
        EntityManagerFactoryBuilder builder) {
        return builder
            .dataSource(dataSource1())
            .packages("com.rrWebservices.RRWebservices.EntitySfsmdb")
            .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager1(
        @Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}

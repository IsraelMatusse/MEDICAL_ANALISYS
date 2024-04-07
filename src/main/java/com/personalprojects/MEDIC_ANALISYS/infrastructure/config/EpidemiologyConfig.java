package com.personalprojects.MEDIC_ANALISYS.infrastructure.config;

import com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.repositories.OutBreakRepo;
import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = OutBreakRepo.class,
        entityManagerFactoryRef = "epidemiologyEntityManager",
        transactionManagerRef = "epidemiologyTransactionManager")
public class EpidemiologyConfig {

    @Bean
    @ConfigurationProperties(prefix = "epidemiology.datasource")
    public DataSource epidemiologyDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean epidemiologyEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("epidemiologyDataSource") DataSource epdiemiologyDataSource
    ) {
        return builder
                .dataSource(epdiemiologyDataSource)
                .packages("com.personalprojects.MEDIC_ANALISYS.domains.epidemiology.models")
                .build();
    }
    @Bean
    public PlatformTransactionManager epidemiologyTransactionManager(
            @Qualifier("epidemiologyEntityManager") EntityManagerFactory epidemiologyEntityManager) {
        return new JpaTransactionManager(epidemiologyEntityManager);
    }

    @Bean
    public Flyway flywayUserMigration(@Qualifier("epidemiologyDataSource") DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migrations/epidemiology")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
        return flyway;
    }


}

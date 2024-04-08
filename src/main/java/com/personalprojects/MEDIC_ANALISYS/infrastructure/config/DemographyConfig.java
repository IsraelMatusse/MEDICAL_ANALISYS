package com.personalprojects.MEDIC_ANALISYS.infrastructure.config;

import com.personalprojects.MEDIC_ANALISYS.domains.demography.repositories.ProvinceRepo;
import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
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
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = ProvinceRepo.class,
        entityManagerFactoryRef = "demographyEntityManager",
        transactionManagerRef = "demographyTransactionManager"
)
public class DemographyConfig {


    @Bean
    @ConfigurationProperties(prefix = "demography.datasource")
    public DataSource demographyDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean demographyEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("demographyDataSource") DataSource demographyDataSource
    ) {
        return builder
                .dataSource(demographyDataSource)
                .packages("com.personalprojects.MEDIC_ANALISYS.domains.demography.models")
                .build();
    }

    @Bean
    public PlatformTransactionManager demographyTransactionManager(
            @Qualifier("demographyEntityManager") EntityManagerFactory demographyEntityManager
    ) {
        return new JpaTransactionManager(demographyEntityManager);
    }

    @Bean
    public Flyway flywayDemography(@Qualifier("demographyDataSource") DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migrations/demography")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
        return flyway;
    }
}

package com.personalprojects.MEDIC_ANALISYS.infrastructure.config;

import com.personalprojects.MEDIC_ANALISYS.domains.medical_records.repositories.PatientRepo;
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
        basePackageClasses = PatientRepo.class,
        entityManagerFactoryRef = "medicalRecordsEntityManager",
        transactionManagerRef = "medicalRecordsTransactionManager"
)
public class MedicalRecordsConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "medical-records.datasource")
    public DataSource medicalRecordsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean medicalRecordsEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("medicalRecordsDataSource") DataSource medicalRecordsDataSource
    ) {
        return builder
                .dataSource(medicalRecordsDataSource)
                .packages("com.personalprojects.MEDIC_ANALISYS.domains.medical_records.models")
                .build();
    }

    @Bean
    public PlatformTransactionManager medicalRecordsTransactionManager(
            @Qualifier("medicalRecordsEntityManager") EntityManagerFactory medicalRecordsEntityManager
    ) {
        return new JpaTransactionManager(medicalRecordsEntityManager);
    }

    @Bean
    public Flyway flyAwayMedicalRecords(@Qualifier("medicalRecordsDataSource") DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migrations/medical_records")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
        return flyway;
    }
}

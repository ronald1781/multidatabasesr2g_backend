package com.r2g;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "producEntityManagerFactory", transactionManagerRef = "producTransactionManager", basePackages = {
        "com.r2g.repo.bdpg"})
public class PostgreSQLConfig {
    @Autowired
    private Environment env;

    @Bean(name = "producDataSource")
    public DataSource producDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("bdpg.datasource.url"));
        dataSource.setUsername(env.getProperty("bdpg.datasource.username"));
        dataSource.setPassword(env.getProperty("bdpg.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("bdpg.datasource.driverClassName"));
        return dataSource;
    }

    @Primary
    @Bean(name = "producEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(producDatasource());
        em.setPackagesToScan("com.r2g.model.bdpg");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("bdpg.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("bdpg.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("bdpg.jpa.database-platform"));

        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean(name = "producTransactionManager")
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}

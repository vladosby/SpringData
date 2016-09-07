package com.spring.data.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by vlados on 9/7/2016.
 */

@EnableJpaRepositories(basePackages={"com.spring.data.repositories"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:/com/spring/data/conf/database.properties"})
public class PostgreJavaConfig {
    @Autowired
    Environment env;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("postgre.driver"));
        dataSource.setUrl(env.getProperty("postgre.url"));
        dataSource.setUsername(env.getProperty("postgre.user"));
        dataSource.setPassword(env.getProperty("postgre.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
        emFactory.setDataSource(dataSource());
        emFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", env.getProperty("postgre.hibernate.dialect"));
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("postgre.hibernate.hbm2ddl.auto"));
        emFactory.setJpaProperties(jpaProperties);
        emFactory.setPackagesToScan("com.spring.data.entities");
        return emFactory;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
}

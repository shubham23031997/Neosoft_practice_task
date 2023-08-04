package com.example.twodbconnection.postgres.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerFactoryBean",
        basePackages = {"com.example.twodbconnection.postgres.repo"},
        transactionManagerRef = "secondTransactionManager"
)

//here we need 3 beans
public class PostgresDbConfig {

    @Autowired
    private Environment environment;
    //here we can read the properties file with the help of this variable
    //datasource

    @Bean(name = "secondDataSource")
    @Primary
    public DataSource secondDataSource() {
        DriverManagerDataSource secondDataSource = new DriverManagerDataSource();
        secondDataSource.setUrl(environment.getProperty("second.datasource.url"));
        secondDataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
        secondDataSource.setUsername(environment.getProperty("second.datasource.username"));
        secondDataSource.setPassword(environment.getProperty("second.datasource.password"));
        return secondDataSource;
    }

    //entity manager factory
    @Bean(name = "secondEntityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactoryBean() {
//       LocalContainerEntityManagerFactoryBean is used for to set entity manager factory
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(secondDataSource());
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        //to put specific behavior of vender  in spring entity manager factory
        bean.setJpaVendorAdapter(adapter);
        HashMap<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show-sql", "true");
        properties.put("hibernate.ddl-auto", "update");
        bean.setJpaPropertyMap(properties);
        bean.setPackagesToScan("com.example.twodbconnection.postgres.entity");

        return bean;
    }

    //platform transaction manager factory
    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager secondTransactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(secondEntityManagerFactoryBean().getObject());
        return manager;
    }
}
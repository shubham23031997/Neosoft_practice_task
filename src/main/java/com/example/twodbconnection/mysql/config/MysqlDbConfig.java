package com.example.twodbconnection.mysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef = "mysqlEntityManagerFactoryBean",
        basePackages = {"com.example.twodbconnection.mysql.repo"},
        transactionManagerRef = "mysqlTransactionManager"
)
//here we need 3 beans
public class MysqlDbConfig {
    @Autowired
    private Environment environment;

    //here we can read the properties file with the help of this variable
    //datasource
    @Bean

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        return dataSource;
    }

    //entity manager factory
    @Bean(name = "mysqlEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactoryBean() {
//       LocalContainerEntityManagerFactoryBean is used for to set entity manager factory
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource());
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        //to put specific behavior of vendor  in spring entity manager factory
        bean.setJpaVendorAdapter(adapter);

        HashMap<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show-sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        bean.setJpaPropertyMap(properties);
        bean.setPackagesToScan("com.example.twodbconnection.mysql.entity");

        return bean;
    }

    //platform transaction manager factory
    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(mysqlEntityManagerFactoryBean().getObject());
        return manager;
    }
}
/*
here we need 3 beans datasource, entity managerfactory, transaction manager factory,*/

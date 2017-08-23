package net.giri.onlineshoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value="classpath:net/giri/onlineshoppingbackend/config/application.properties")
public class HibernateConfig {

    @Autowired
    private Environment env;
    private final static String DATABASE_URL = "database_url";
    private final static String DATABASE_DRIVER = "database_driver";
    private final static String DATABASE_DIALECT = "database_dialect";
    private final static String DATABASE_USERNAME = "database_username";
    private final static String DATABASE_PASSWORD = "database_password";

    @Bean
    public DataSource getDataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(env.getProperty(DATABASE_DRIVER));
	dataSource.setUrl(env.getProperty(DATABASE_URL));
	dataSource.setUsername(env.getProperty((DATABASE_USERNAME)));
	dataSource.setPassword(env.getProperty(DATABASE_PASSWORD));
	return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	sessionFactory.setDataSource(getDataSource());
	sessionFactory.setPackagesToScan(new String[] { "net.giri.onlineshoppingbackend.dto" });
	sessionFactory.setHibernateProperties(hibernateProperties());
	return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
	HibernateTransactionManager txManager = new HibernateTransactionManager();
	txManager.setSessionFactory(s);
	return txManager;
    }

    /**
     * Method used to configure all hibernate properties
     * 
     * @return
     */
    private Properties hibernateProperties() {
	Properties properties = new Properties();
	properties.put("hibernate.dialect", env.getProperty(DATABASE_DIALECT));
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.format_sql", "true");
	return properties;
    }
}

package net.giri.onlineshoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 

@Configuration
@EnableTransactionManagement

public class HibernateConfig {

    private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
    private final static String DATABASE_DRIVER = "org.h2.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private final static String DATABASE_USERNAME = "sa";
    private final static String DATABASE_PASSWORD = "";

    @Bean
    public DataSource getDataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setDriverClassName(DATABASE_DRIVER);
	dataSource.setUrl(DATABASE_URL);
	dataSource.setUsername(DATABASE_USERNAME);
	dataSource.setPassword(DATABASE_PASSWORD);
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
	properties.put("hibernate.dialect", DATABASE_DIALECT);
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.format_sql", "true");
	return properties;
    }
}

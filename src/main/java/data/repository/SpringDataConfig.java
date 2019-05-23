package data.repository;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("data.repository")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class SpringDataConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource localDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		bds.setUrl(env.getProperty("jdbc.url"));
		bds.setUsername(env.getProperty("jdbc.username"));
		bds.setPassword(env.getProperty("jdbc.password"));
		return bds;
	}
	
	@Bean
	public LocalSessionFactoryBean mySessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(localDataSource());
		sf.setPackagesToScan(new String[] {"data.domain"});
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		prop.setProperty("hibernate.temp.use_jdbc_metadata_defaults", env.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
		sf.setHibernateProperties(prop);
		return sf;
	}
	
	@Bean
	public HibernateTransactionManager myTransactionManager(SessionFactory sf) {
		HibernateTransactionManager htm = new HibernateTransactionManager(sf); 
		return htm;
	}
	
	@Bean(name="artistRepository")
	public ArtistRepository myArtistRepository(SessionFactory sf) {
		ArtistRepository ar = new ArtistRepository();
		ar.setSessionFactory(sf);
		return ar;
	}
}

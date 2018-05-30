package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:app.properties")
public class DataSourceMySQLConfig {

	@Bean
	public DataSource dataSource(@Value("${jdbc.driver}") String driver, @Value("${jdbc.url}") String url,
			@Value("${jdbc.user}") String user, @Value("${jdbc.password}") String mdp) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(mdp);
		return dataSource;
	}

}
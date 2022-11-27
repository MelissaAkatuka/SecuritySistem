package com.tcc.safehome;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource;
		dataSource = new DriverManagerDataSource();
		try {
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://162.241.3.30:3306/mktstu21_breno");
			dataSource.setUsername("mktstu21_breno");
			dataSource.setPassword("Y4J[OB,znVZ]");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro na conexão com o banco de dados");
		}
		
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		
		return adapter;
	}
}

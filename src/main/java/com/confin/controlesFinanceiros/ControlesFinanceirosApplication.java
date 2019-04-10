package com.confin.controlesFinanceiros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaRepositories("com.confin.controlesFinanceiros.repository")
//@EntityScan("com.confin.controlesFinanceiros.domain")
@SpringBootApplication
public class ControlesFinanceirosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlesFinanceirosApplication.class, args);
		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("DadosProjetos");
		// factory.close();
	}

//	 @Bean
//	    public DataSource dataSource() {
//	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	        dataSource.setUrl("jdbc:mysql://localhost:3306/controlefin");
//	        dataSource.setUsername("root");
//	        dataSource.setPassword("");
//	        return dataSource;
//	    }

}

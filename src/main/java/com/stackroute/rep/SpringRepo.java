package com.stackroute.rep;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@EnableJpaRepositories("com.stackroute.repo.model.RepoRepository")
////(scanBasePackages= {"com.stackroute.repo.model	"})
public class SpringRepo {

	public static void main(String[] args) {
		SpringApplication.run(SpringRepo.class,args);

	}

}

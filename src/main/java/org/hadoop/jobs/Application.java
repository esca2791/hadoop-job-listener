package org.hadoop.jobs;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
@EnableJpaAuditing
@PropertySource("classpath:application.properties")
public class Application {

	private static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) {
		logger.info("Starting...");
		SpringApplication.run(Application.class, args);
	}
}
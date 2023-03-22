package com.trading.app.demo;

import com.trading.app.demo.db.DataLoader;
import com.trading.app.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static ch.qos.logback.core.util.OptionHelper.getEnv;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		// Get the dataLoader
		DataLoader dataLoader = context.getBean(DataLoader.class);

//		// run the seed if env var SEED != true:
//		if("true".equals(getEnv("SEED"))){
//			dataLoader.seedDb();
//		}
		dataLoader.seedDb();

	}


}

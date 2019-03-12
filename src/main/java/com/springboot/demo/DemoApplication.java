package com.springboot.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;


@RestController
@SpringBootApplication(scanBasePackages = "com.springboot.demo")
@EnableAutoConfiguration
@EnableSwagger2
public class DemoApplication {




	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		// 目的是
		return args -> {
			System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			Arrays.stream(beanNames).forEach(System.out::println);
		};
	}

}

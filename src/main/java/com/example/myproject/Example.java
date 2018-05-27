package com.example.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Example /*implements EmbeddedServletContainerCustomizer*/{
	
	@RequestMapping("/")
	String home(){
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
	}

	/*@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(9000);
	}*/
	
	
	/*@Bean
	public EmbeddedServletContainerFactory servletContainer2222(){
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(9000);
		factory.setSessionTimeout(10, TimeUnit.MINUTES);
		return factory;
	}*/
}

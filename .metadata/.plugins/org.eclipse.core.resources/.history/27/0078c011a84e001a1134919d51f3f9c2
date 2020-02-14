package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyFirstSpringApplication {

	public static void main(String[] args) {
		
		//Initialize Spring Container in JVM
		ConfigurableApplicationContext context = SpringApplication.run(MyFirstSpringApplication.class, args);
		
		//Get the class
		Person person = context.getBean(Person.class);
		person.showName();
		person.callPhone();
		
		/*Even though printed twice, object is created twice
		Person person1 = context.getBean(Person.class);
		person1.showName();
		*/
	}

}

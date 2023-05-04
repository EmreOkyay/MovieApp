package org.cansu.app.service.studio.director;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.cansu", "com.elif"})
public class DirectorGetServiceApp {
	public static void main(String[] args)
	{
		SpringApplication.run(DirectorGetServiceApp.class, args);
	}
}

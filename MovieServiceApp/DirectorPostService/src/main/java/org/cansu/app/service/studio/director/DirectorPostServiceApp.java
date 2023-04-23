package org.cansu.app.service.studio.director;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.cansu", "com.elif"})
public class DirectorPostServiceApp {
	public static void main(String[] args)
	{
		SpringApplication.run(DirectorPostServiceApp.class, args);
	}
}

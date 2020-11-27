package net.guides.springboot.todomanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.guides.springboot.todomanagement.model.LombokModel;
@SpringBootApplication
public class TodoManagementSpringBoot2Application {

	public static void main(String[] args) {
		LombokModel lm = new LombokModel();
		SpringApplication.run(TodoManagementSpringBoot2Application.class, args);
	}
}
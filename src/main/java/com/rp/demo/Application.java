package com.rp.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rp.demo.service.CategoryRepository;
import com.rp.demo.service.TagRepository;
import com.rp.demo.model.Category;
import com.rp.demo.model.Tag;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Category("Dog"));
			repository.save(new Category("Cat"));
			repository.save(new Category("German Shepard"));
			repository.save(new Category("Hybrid"));
			repository.save(new Category("Fish"));
			
			
		};
	}
	
	@Bean
	public CommandLineRunner demo1(TagRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Tag("Animal"));
			repository.save(new Tag("Bird"));
			repository.save(new Tag("New-breed"));
			repository.save(new Tag("Mix-breed"));
			repository.save(new Tag("Sea"));
			
			
		};
	}
}

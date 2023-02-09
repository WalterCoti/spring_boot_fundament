package com.practicaSpringBoot.demo;

import com.practicaSpringBoot.demo.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {

	private ComponentDependency componentDependency;
	@Autowired
	public DemoApplication  (ComponentDependency componentDependency_){
		this.componentDependency = componentDependency_;
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args){
		componentDependency.saludar();
	}

}

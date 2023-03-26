package com.practicaSpringBoot.demo;

import com.practicaSpringBoot.demo.bean.MyBeanwithProperties;
import com.practicaSpringBoot.demo.bean.MybeanDependency;
import com.practicaSpringBoot.demo.bean.MybeanPropertiesImplement;
import com.practicaSpringBoot.demo.bean.newbean;
import com.practicaSpringBoot.demo.component.ComponentDependency;
import com.practicaSpringBoot.demo.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DemoApplication  implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(DemoApplication.class);

	private ComponentDependency componentDependency;
	private newbean mybean;
	private MybeanDependency mybeanwithDependency;
	private MyBeanwithProperties myBeanwithProperties;
	private UserPojo userPojo;



	public DemoApplication(ComponentDependency componentDependency_, newbean mybean_, MybeanDependency mybeanDependency_, MyBeanwithProperties myBeanwithProperties, UserPojo userPojo_){
		this.mybeanwithDependency = mybeanDependency_;
		this.componentDependency = componentDependency_;
		this.mybean = mybean_;
		this.myBeanwithProperties = myBeanwithProperties;
		this.userPojo = userPojo_;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	 componentDependency.saludar();
	 mybean.print();
	 mybeanwithDependency.printmyDependency();
		System.out.println(myBeanwithProperties.function());
		System.out.println(userPojo.toString());
		try{
			int value = 10/0;
			LOGGER.debug("Mi valor : " + value);
		}catch (Exception e){

		LOGGER.error("esto es un error del aplicativo " + e.getMessage());
		}
	}
}

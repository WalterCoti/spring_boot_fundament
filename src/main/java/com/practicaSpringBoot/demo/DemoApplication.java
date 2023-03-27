package com.practicaSpringBoot.demo;

import com.practicaSpringBoot.demo.bean.MyBeanwithProperties;
import com.practicaSpringBoot.demo.bean.MybeanDependency;
import com.practicaSpringBoot.demo.bean.MybeanPropertiesImplement;
import com.practicaSpringBoot.demo.bean.newbean;
import com.practicaSpringBoot.demo.component.ComponentDependency;
import com.practicaSpringBoot.demo.entity.User;
import com.practicaSpringBoot.demo.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

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
		ejemplosanteriores();

	}

	private void savUserInDataBase(){
		User user1 = new User("Jonh","holamundo@gmail.com", LocalDate.of(2023,03,27));
		User user2 = new User("Antuan","Antuan@gmail.com", LocalDate.of(2023,04,27));
		User user3 = new User("Miguel","Miguel@gmail.com", LocalDate.of(2023,04,27));
		User user4 = new User("Jose","Jose@gmail.com", LocalDate.of(2023,04,27));
		User user5 = new User("Mary","Mary@gmail.com", LocalDate.of(2023,04,27));
		User user6 = new User("Letycia","Letycia@gmail.com", LocalDate.of(2023,04,27));
		User user7 = new User("Romio","Romio@gmail.com", LocalDate.of(2023,04,27));
		User user8 = new User("Manuela","Manuela@gmail.com", LocalDate.of(2023,04,27));
		User user9 = new User("Fernanda","Fernanda@gmail.com", LocalDate.of(2023,04,27));
		User user10 = new User("Estefany","Estefany@gmail.com", LocalDate.of(2023,04,27));


	}

	public void ejemplosanteriores(){
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

package com.practicaSpringBoot.demo;

import com.practicaSpringBoot.demo.bean.MyBeanwithProperties;
import com.practicaSpringBoot.demo.bean.MybeanDependency;
import com.practicaSpringBoot.demo.bean.MybeanPropertiesImplement;
import com.practicaSpringBoot.demo.bean.newbean;
import com.practicaSpringBoot.demo.component.ComponentDependency;
import com.practicaSpringBoot.demo.entity.User;
import com.practicaSpringBoot.demo.pojo.UserPojo;
import com.practicaSpringBoot.demo.repository.UserRepository;
import com.practicaSpringBoot.demo.service.UseService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication

public class DemoApplication  implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(DemoApplication.class);

	private ComponentDependency componentDependency;
	private newbean mybean;
	private MybeanDependency mybeanwithDependency;
	private MyBeanwithProperties myBeanwithProperties;
	private UserPojo userPojo;
	private UserRepository	userRepository;
	private UseService useService;

	public DemoApplication(ComponentDependency componentDependency_, newbean mybean_, MybeanDependency mybeanDependency_, MyBeanwithProperties myBeanwithProperties, UserPojo userPojo_, UserRepository userRepository_, UseService useService_){
		this.mybeanwithDependency = mybeanDependency_;
		this.componentDependency = componentDependency_;
		this.mybean = mybean_;
		this.myBeanwithProperties = myBeanwithProperties;
		this.userPojo = userPojo_;
		this.userRepository = userRepository_;
		this.useService = useService_;
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//ejemplosanteriores();
		savUserInDataBase();
		getInformationJpqlFromUser();
		saveWithErrorTransactional();
	}


	private void saveWithErrorTransactional() {
		User user1 = new User("Test1", "Test1email", LocalDate.now());
		User user2 = new User("Test2", "Test2email", LocalDate.now());
		User user3 = new User("Test3", "Test3email", LocalDate.now());
		User user4 = new User("Test4", "Test4email", LocalDate.now());
		List<User> users = Arrays.asList(user1, user2, user3, user4);
		useService.saveTransactional(users);
		useService.getAllUsers().stream().forEach(user -> LOGGER.info("Este es el usuario dentro del metodo transaccional: " + user));
	}
	private void getInformationJpqlFromUser() {
		User user = userRepository.findUseremail("Letycia@gmail.com")
				.orElseThrow(()-> new RuntimeException("No existe el usuario con el email indicado" ));
		LOGGER.info("Usuario con el metodo findUseremail: " + user);
		userRepository.findAndSort("J", Sort.by("id").descending())
				.stream()
				.forEach(usr -> LOGGER.info("Usuario con el metodo findAndSort: " + usr));
		userRepository.findByName("Antuan")
				.stream()
				.forEach(usr -> LOGGER.info("Usuario con el metodo findByName: " + usr));
		LOGGER.info("Usuario con query method findByEmailName" + userRepository.findByEmailAndName("Manuela@gmail.com","Manuela")
				.orElseThrow(() -> new RuntimeException("No existe el usuario con el email y nombre indicado")));
		//
		userRepository.findByNameLike("%o%").stream().forEach(usr -> LOGGER.info("Usuario con el metodo findByNameLike: " + usr));
		// OR
		userRepository.findByNameOrEmail("Antuan","Estefany@gmail.com").stream().forEach(usr -> LOGGER.info("Usuario con el metodo findByNameOrEmail: " + usr));

		userRepository.findByBirthdayBetween(LocalDate.of(2023,04,25),LocalDate.of(2023,04,27))
				.stream().forEach(usr -> LOGGER.info("Usuario con el metodo findByBirthdayBetween: " + usr));
		userRepository.findByNameLikeOrderByIdDesc("%l%").stream().forEach(usr -> LOGGER.info("Usuario con el metodo findByNameLikeOrderByIdDesc: " + usr));
		userRepository.findByNameContaining("y").stream().forEach(usr -> LOGGER.info("Usuario con el metodo findByNameContainingOrderByIdDesc: " + usr));
		LOGGER.info( "El usuario a partir del named parameter es " + userRepository.getAllByBirthdayAAndEmail(LocalDate.of(2023,04,9),"Jose@gmail.com")
				.orElseThrow(()-> new RuntimeException("No existe el usuario con el email y nombre indicado")));
	}


	private void savUserInDataBase(){
		User user1 = new User("Jonh","Jonh@gmail.com", LocalDate.of(2023,03,27));
		User user2 = new User("Antuan","Antuan@gmail.com", LocalDate.of(2023,04,11));
		User user3 = new User("Miguel","Miguel@gmail.com", LocalDate.of(2023,04,22));
		User user4 = new User("Jose","Jose@gmail.com", LocalDate.of(2023,04,9));
		User user5 = new User("Mary","Mary@gmail.com", LocalDate.of(2023,04,27));
		User user6 = new User("Letycia","Letycia@gmail.com", LocalDate.of(2023,04,25));
		User user7 = new User("Romio","Romio@gmail.com", LocalDate.of(2023,04,07));
		User user8 = new User("Manuela","Manuela@gmail.com", LocalDate.of(2023,04,27));
		User user9 = new User("Fernanda","Fernanda@gmail.com", LocalDate.of(2023,04,6));
		User user10 = new User("Estefany","Estefany@gmail.com", LocalDate.of(2023,04,9));
		User user11 = new User("Luis","luis@gmail.com", LocalDate.of(2023,04,8));
		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11);
		list.stream().forEach(userRepository::save);
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

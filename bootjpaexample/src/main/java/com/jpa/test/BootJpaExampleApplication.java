package com.jpa.test;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootJpaExampleApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		User user = new User();
		user.setName("Monir Ahmed");
		user.setCity("Dhaka");
		user.setStatus("I am a java programmer");

//		 Save single object
		User user1 = userRepository.save(user);

		System.out.println(user1);

		User user2 = new User();
		user2.setName("Abu Bokor");
		user2.setCity("Dhaka");
		user2.setStatus("PHP Programmer");

		User user3 = new User();
		user3.setName("Jannatun Kumu");
		user3.setCity("Dhaka");
		user3.setStatus("Govt. Officer");

		// Saving multiple objects
		List<User> users = List.of(user2, user3);
		Iterable<User> result = userRepository.saveAll(users);

		result.forEach(System.out::println);

//		 Update data
		Optional<User> optional = userRepository.findById(3);
		User userUpdateInstance = optional.get();
		System.out.println(userUpdateInstance);

		userUpdateInstance.setName("Kumu Jannatun");
		userRepository.save(userUpdateInstance);

		// How to get data
		Iterable<User> itr = userRepository.findAll();
		itr.forEach(System.out::println);

//		 Deleting Data
		userRepository.deleteById(3);
		System.out.println("kumu deleted");

		Iterable<User> allUsers = userRepository.findAll();
		userRepository.deleteAll(allUsers);
		System.out.println("All user deleted");

		List<User> usersByName = userRepository.findByName("Monir");
		usersByName.forEach(userByName -> System.out.println(userByName));

		List<User> users2 = userRepository.findByAgeGreaterThan(29);
		users2.forEach(System.out::println);

		List<User> userAll = userRepository.getAllUser();
		userAll.forEach(System.out::println);

		List<User> userByNameAll = userRepository.getUserByName("Abu Bokor", "Dhaka");
		userByNameAll.forEach(System.out::println);

		System.out.println("_________________________________________");

		List<User> usersByNativeQuery = userRepository.getUsers();
		usersByNativeQuery.forEach(System.out::println);
	}
}

package com.ecommerce.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

//	@Autowired
//	UserRepository userRepository;

	public void run(String... args) throws Exception {
//		userRepository.save(new User("123@sdsaf.com","123"));
	}

}

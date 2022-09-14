package com.example.JBDL33eighteensecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class Jbdl33EighteenSecurityApplication implements CommandLineRunner {

	@Autowired
	MyUserRepository myUserRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Jbdl33EighteenSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Runs immediately after application has started
		//create some users
		MyUser user1 = MyUser.builder()
				.name("Sai")
				.email("sai@gmail.com")
				.password(passwordEncoder.encode("sai123"))
				.authority("dev")
				.build();

		MyUser user2 = MyUser.builder()
				.name("Rahul")
				.email("rahul@gmail.com")
				.password(passwordEncoder.encode("rahul123"))
				.authority("qa")
				.build();

		MyUser user3 = MyUser.builder()
				.name("Rahul")
				.email("rahul@yahoo.co.in")
				.password(passwordEncoder.encode("rahul123"))
				.authority("dev")
				.build();

		MyUser user4 = MyUser.builder()
				.name("Kanika")
				.email("kanika@gmail.com")
				.password(passwordEncoder.encode("kanika123"))
				.authority("dev")
				.build();

		MyUser user5 = MyUser.builder()
				.name("Pinak")
				.email("pinak@gmail.com")
				.password(passwordEncoder.encode("pinak123"))
				.authority("dev")
				.build();

		MyUser user6 = MyUser.builder()
				.name("Carolina")
				.email("carolina@gmail.com")
				.password(passwordEncoder.encode("carolina123"))
				.authority("dev")
				.build();


//		myUserRepository.saveAll(Arrays.asList(user1, user2, user3));

		try {
			//save one by one example below
//			myUserRepository.save(user1);
//			myUserRepository.save(user2);
//			myUserRepository.save(user3);

			myUserRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5, user6));

		}catch (Exception e){
			e.printStackTrace();
		}

	}
}

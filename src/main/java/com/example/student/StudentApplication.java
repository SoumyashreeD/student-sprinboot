package com.example.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	@Bean
    public CommandLineRunner init(StudentDao studentDao){
        return args -> {
            Student user1 = new Student ();
            user1.setFirstName("Soumyashree");
            user1.setLastName("Dhabade");
            user1.setPercentage(90);
            user1.setAge(21);
	    user1.setGender("Female");
            user1.setUsername("soumya");
            user1.setPassword("1234");
            studentDao.save(user1);
        };

}
}

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
            user1.setFirstName("Devglan");
            user1.setLastName("Devglan");
            user1.setPercentage(90);
            user1.setAge(23);
            user1.setUsername("devglan");
            user1.setPassword("devglan");
            studentDao.save(user1);
        };

}
}

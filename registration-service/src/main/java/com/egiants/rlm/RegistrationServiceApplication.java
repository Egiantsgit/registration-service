package com.egiants.rlm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.egiants.rlm"})
public class RegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceApplication.class, args);
		
	}
	
	/*@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		
		return args -> {
	    	userRepository.save(
	    			
	    	 Arrays.asList(
	    			
		             new User("dummy1", "dummy1", "dummy1@gmail.com", "developer", "dummy1", "dummy1", UUID.randomUUID() , ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString() , ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString()),
		             new User("dummy2", "dummy2", "dummy2@gmail.com", "developer", "dummy2", "dummy2", UUID.randomUUID() , ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString(), ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString()),
		             new User("dummy3", "dummy3", "dummy3@gmail.com", "developer", "dummy3", "dummy3", UUID.randomUUID() , ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString(), ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString()),
		             new User("dummy4", "dummy4", "dummy4@gmail.com", "developer", "dummy4", "dummy4", UUID.randomUUID() , ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString(), ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString()),
		             new User("dummy5", "dummy5", "dummy5@gmail.com", "developer", "dummy5", "dummy5", UUID.randomUUID() , ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString(), ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString()),
		             new User("dummy6", "dummy6", "dummy6@gmail.com", "developer", "dummy6", "dummy6", UUID.randomUUID() , ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString(), ZonedDateTime.now(ZoneId.of("UTC-05:00")).toString())
		             

		     ) ); }; 
		     
	}*/

	
}
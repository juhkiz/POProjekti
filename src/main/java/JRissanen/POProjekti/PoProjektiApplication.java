package JRissanen.POProjekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import JRissanen.POProjekti.domain.User;
import JRissanen.POProjekti.domain.Food;
import JRissanen.POProjekti.domain.FoodRepository;
import JRissanen.POProjekti.domain.Sport;
import JRissanen.POProjekti.domain.SportRepository;
import JRissanen.POProjekti.domain.UserRepository;

@SpringBootApplication
public class PoProjektiApplication {

	private static final Logger log = LoggerFactory.getLogger(PoProjektiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PoProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner SportDataDemo(FoodRepository foodRepo, SportRepository sportRepo, UserRepository userRepo)
	{
		return (args) -> {
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepo.save(user1);
			userRepo.save(user2);
			
			sportRepo.save(new Sport("Boxing", 100));
			sportRepo.save(new Sport("Running", 200));
			sportRepo.save(new Sport("Walking", 500));
			foodRepo.save(new Food("Lunch", 500));
			
			log.info("fetch all sports");
			for (Sport sport : sportRepo.findAll())
			{
				log.info(sport.toString());
			}
		};
	}
}

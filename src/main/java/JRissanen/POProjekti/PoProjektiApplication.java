package JRissanen.POProjekti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import JRissanen.POProjekti.domain.FoodRepository;
import JRissanen.POProjekti.domain.Sport;
import JRissanen.POProjekti.domain.SportRepository;
import JRissanen.POProjekti.domain.TrainingSessionRepository;
import JRissanen.POProjekti.domain.UserRepository;

@SpringBootApplication
public class PoProjektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner SportDataDemo(FoodRepository foodRepo, SportRepository sportRepo, TrainingSessionRepository tsRepo, UserRepository userRepo)
	{
		return (args) -> {
			sportRepo.save(new Sport("Boxing", 100));
			sportRepo.save(new Sport("Running", 200));
			sportRepo.save(new Sport("Walking", 500));
		};
	}
}

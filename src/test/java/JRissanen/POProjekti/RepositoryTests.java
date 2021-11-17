package JRissanen.POProjekti;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import JRissanen.POProjekti.domain.Food;
import JRissanen.POProjekti.domain.FoodRepository;
import JRissanen.POProjekti.domain.Sport;
import JRissanen.POProjekti.domain.SportData;
import JRissanen.POProjekti.domain.SportDataRepository;
import JRissanen.POProjekti.domain.SportRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {
		
	@Autowired
	private SportRepository sportRepo;
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private SportDataRepository dataRepo;
	
	@Test
	public void addNewFood(){
		Food foodTest = new Food("Breakfast", 100);
		foodRepo.save(foodTest);
		assertThat(foodTest.getId()).isNotNull();
	}
	
	@Test
	public void addNewSport(){
		SportData dataTest = new SportData("Sportdatatest", 500);
		dataRepo.save(dataTest);
		assertThat(dataTest.getSportDataId()).isNotNull();
		Sport sportTest = new Sport(dataTest, 2);
		sportRepo.save(sportTest);
		assertThat(sportTest.getId()).isNotNull();
	}
	
	@Test
	public void findSportByDate() {
		List<Sport> sports = sportRepo.findByDate(LocalDate.now());
		assertThat(sports).hasSize(3); // Commandlinerunnerilla lisätään aluksi 3 urheilusuoritusta siksi hassize3
	}
	
	@Test
	public void deleteSport() {
		Sport sportTest = new Sport(new SportData("testilaji", 100),2);
		sportRepo.save(sportTest);
		long testId = sportTest.getId();
		assertThat(sportTest.getId()).isNotNull();
		sportRepo.deleteById(sportTest.getId());
		assertThat(sportRepo.findById(testId).equals(null));
	}
}
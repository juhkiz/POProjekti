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
import JRissanen.POProjekti.domain.SportRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTests {
		
	@Autowired
	private SportRepository sportRepo;
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Test
	public void addNewFood(){
		Food foodTest = new Food("Breakfast", 100);
		foodRepo.save(foodTest);
		assertThat(foodTest.getId()).isNotNull();
	}
	
	@Test
	public void addNewSport(){
		Sport sportTest = new Sport("Boxing", 200);
		sportRepo.save(sportTest);
		assertThat(sportTest.getId()).isNotNull();		
	}
	
	@Test
	public void findSportByDate() {
		List<Sport> sports = sportRepo.findByDate(LocalDate.now());
		assertThat(sports).hasSize(3);
	}
	
	/*@Test
	public void deleteBook() {
		Book bookTest = new Book("Test1", "Testaaja", 2001, "TESTI123", 12.43, new Category("Testi"));
		bRepository.save(bookTest);
		long testId = bookTest.getId();
		assertThat(bookTest.getId()).isNotNull();
		bRepository.deleteById(bookTest.getId());
		assertThat(bRepository.findById(testId).equals(null)); // lisätään ensin kirja, ja tallennetaan sille id arvo. Tämän jälkeen testataan että kyseiselle kirjalle on syntynyt id arvo (1. assertti).
																// Sitten kirja poistetaan kyseistä id:tä käyttämällä ja testataan vielä, että palauttaako kyseinen id null arvon -> kirja poistunut
	}*/
	
	/*@Test
	public void deleteCategory() {
		Category categTest = new Category("CategTesti");
		cRepository.save(categTest);
		long testId = categTest.getCategoryid();
		assertThat(categTest.getCategoryid()).isNotNull();
		cRepository.deleteById(categTest.getCategoryid());
		assertThat(cRepository.findById(testId).equals(null)); 
	}*/
}
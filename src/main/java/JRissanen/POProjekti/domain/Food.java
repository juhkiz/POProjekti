package JRissanen.POProjekti.domain;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private LocalDate date = LocalDate.now();
	@Size(min=5,max=10, message = "Meal name should be between 5 and 10 letters")
	private String mealName;
	@Min(value = 1, message = "Calories must be more than 0!")
	private int calories;

	
	public Food(){}
	
	public Food(String mealName, int calories) {
		super();
		this.mealName = mealName;
		this.calories = calories;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Food [id=" + id + ", mealName=" + mealName + ", calories=" + calories + "]";
	}
	
	
	
	
}

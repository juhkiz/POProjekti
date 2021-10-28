package JRissanen.POProjekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String mealName;
	private int calories;
	
	public Food(){}
	
	public Food(Long id, String mealName, int calories) {
		super();
		this.id = id;
		this.mealName = mealName;
		this.calories = calories;
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

package JRissanen.POProjekti.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Sport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotEmpty(message = "Sport name cannot be empty!")
	private String sportName;
	@Min(value = 1, message = "Consumption must be more than 0!")
	private int duration;
	private LocalDate date = LocalDate.now();
	
	@ManyToOne
	@JsonIgnoreProperties("sports")
	@JoinColumn(name = "sportDataId")
	private SportData sportData;
	
	public Sport(){}
	
	public Sport(String sportName, int consumption) {
		super();
		this.sportName = sportName;
		this.duration = consumption;
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
	public String getSportName() {
		return sportName;
	}
	public int getConsumption() {
		return duration;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public void setConsumption(int consumption) {
		this.duration = consumption;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", sportName=" + sportName + ", consumption=" + duration + "]";
	}
	
	
}

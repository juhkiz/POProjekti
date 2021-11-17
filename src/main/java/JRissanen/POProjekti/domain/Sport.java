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
	@Min(value = 1, message = "Duration must be more than 0!")
	private int duration;
	private LocalDate date = LocalDate.now();
	
	@ManyToOne
	@JsonIgnoreProperties("sports")
	@JoinColumn(name = "sportDataId")
	private SportData sportData;
	
	public Sport(){}
	
	public Sport(SportData sportData, int duration) {
		super();
		this.sportData = sportData;
		this.duration = duration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SportData getSportData() {
		return sportData;
	}

	public void setSportData(SportData sportData) {
		this.sportData = sportData;
	}

	@Override
	public String toString() {
		if(this.sportData != null)
			return 
				"Sport [id=" + id + ", duration=" + duration + ", date=" + date + ", sportData=" + sportData + "]";
		else
			return 
				"Sport [id=" + id + ", duration=" + duration + ", date=" + date+"]";
	}
	
	
	
	
}

package JRissanen.POProjekti.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SportData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long sportDataId;
	@NotEmpty(message = "Sport name cannot be empty!")
	private String sportName;
	@Min(value = 1, message = "Consumption must be more than 0!")
	private int consumption;
	
	@OneToMany
	@JsonIgnoreProperties("sport")
	private List<Sport> sports;
	
	
	public SportData(){}
	
	public SportData(String sportName, int consumption) {
		super();
		this.sportName = sportName;
		this.consumption = consumption;
	}
	public Long getId() {
		return sportDataId;
	}
	public void setId(Long id) {
		this.sportDataId = id;
	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public int getConsumption() {
		return consumption;
	}
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}
	
	
}

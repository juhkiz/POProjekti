package JRissanen.POProjekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Sport {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String sportName;
	private int consumption;
	
	public Sport(){}
	
	public Sport(String sportName, int consumption) {
		super();
		this.sportName = sportName;
		this.consumption = consumption;
	}
	public Long getId() {
		return id;
	}
	public String getSportName() {
		return sportName;
	}
	public int getConsumption() {
		return consumption;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public void setConsumption(int consumption) {
		this.consumption = consumption;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", sportName=" + sportName + ", consumption=" + consumption + "]";
	}
	
	
}
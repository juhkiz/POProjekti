package JRissanen.POProjekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TrainingSession {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private double duration;
	
	public TrainingSession(Long id, double duration) {
		super();
		this.id = id;
		this.duration = duration;
	}
	
	public TrainingSession(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "TrainingSession [id=" + id + ", duration=" + duration + "]";
	}
}

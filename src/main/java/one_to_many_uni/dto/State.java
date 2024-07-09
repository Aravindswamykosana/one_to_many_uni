package one_to_many_uni.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cm;
	private int districts;
	private String language;
	public State(String name, String cm, int districts, String language) {
		super();
		this.name = name;
		this.cm = cm;
		this.districts = districts;
		this.language = language;
	}
	public State() {
		super();
	}
	@Override
	public String toString() {
		return "\nState [id=" + id + ", name=" + name + ", cm=" + cm + ", districts=" + districts + ", language="
				+ language + "]";
	}
	
}

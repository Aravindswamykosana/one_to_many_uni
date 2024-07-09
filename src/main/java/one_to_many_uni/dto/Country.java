package one_to_many_uni.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.mysql.cj.conf.BooleanPropertyDefinition.AllowableValues;

import lombok.Data;

@Entity
@Data
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long population;
	private String nationalBird;
	private String nationalAnimal;
	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
	List<State> states;
	public Country(String name, long population, String nationalBird, String nationalAnimal, List<State> states) {
		super();
		this.name = name;
		this.population = population;
		this.nationalBird = nationalBird;
		this.nationalAnimal = nationalAnimal;
		this.states = states;
	}
	public Country(String name, long population, String nationalBird, String nationalAnimal) {
		super();
		this.name = name;
		this.population = population;
		this.nationalBird = nationalBird;
		this.nationalAnimal = nationalAnimal;
	}
	public Country() {
		super();
	}
	@Override
	public String toString() {
		return "\nCountry [id=" + id + ", name=" + name + ", population=" + population + ", nationalBird=" + nationalBird
				+ ", nationalAnimal=" + nationalAnimal + ", states=" + states + "]";
	}
	
}

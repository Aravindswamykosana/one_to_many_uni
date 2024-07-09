package one_to_many_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Persistence;

import one_to_many_uni.dao.CountryCrud;
import one_to_many_uni.dao.StateCrud;
import one_to_many_uni.dto.Country;
import one_to_many_uni.dto.State;

public class Main {
	public static void main(String[] args) {
		CountryCrud crud=new CountryCrud();
		StateCrud s=new StateCrud();	
		
		List<State> list=new ArrayList<State>();
		list.add(new State("AP", "jagan", 13, "telugu"));
		list.add(new State("TS", "reddy", 33, "telugu"));
		list.add(new State("karnataka", "siddhu", 42, "kannada"));
		
		
//		s.saveState(3,new State("karnataka", "siddhu", 42, "kannada"));
//		s.fetch(4);
//		s.fetchAll();
//		State s1=new State();
//		s1.setCm("arvind");
//		s1.setName("rai");
//		s1.setDistricts(143);
//		s1.setLanguage("hindi");
//		s1.setId(7);
//		s.updateState(s1);
		s.deleteState(6);
		
//		Country c=new Country("INDIA", 1235420l, "peacock", "bengaltiger", list);
//		crud.saveCountry(c);
		
//		Country c1=new Country();
//		c1.setName("INDIA");
//		c1.setNationalAnimal("BENGAL TIGER");
//		c1.setNationalBird("PEACOCK");
//		c1.setPopulation(1000000);
//		c1.setId(2);
//		crud.updateCountry(c1);
		
//		crud.fetchAll();
//		crud.fetch(2);
//		crud.deleteCountry(2);
		
		
		
	}
}

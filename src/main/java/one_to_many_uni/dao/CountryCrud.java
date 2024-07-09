package one_to_many_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_uni.dto.Country;
import one_to_many_uni.dto.State;

public class CountryCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("arvind");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveCountry(Country country) {
		et.begin();
		em.persist(country);
		et.commit();
	}
	public void fetch(int id){
		Country db = em.find(Country.class, id);
		if(db!=null) {
			System.out.println(db);
		}
		else {
			System.out.println("details not found...!");
		}
	}
	public void deleteCountry(int id) {
		Country db = em.find(Country.class , id);
		if(db!=null) {
			et.begin();
			em.remove(db);
			et.commit();
		}
		else {
			System.out.println("id not found for deleting...!");
		}
	}
	public void fetchAll(){
		Query query = em.createQuery("select a from Country a");
		List<Country> li = query.getResultList();
		System.out.println(li);
	}
	public void updateCountry(Country country) {
		Country db = em.find(Country.class,country.getId());
		if(db!=null) {
			if(country.getName()!=null) {
				db.setName(country.getName());
			}
			if(country.getNationalAnimal()!=null) {
				db.setNationalAnimal(country.getNationalAnimal());
			}
			if(country.getNationalBird()!=null) {
				db.setNationalBird(country.getNationalBird());
			}
			if(country.getPopulation()!=0) {
				db.setPopulation(country.getPopulation());
			}
			et.begin();
			em.merge(db);
			et.commit();
		}
		else {
			System.out.println("id not found");
		}
	}
}

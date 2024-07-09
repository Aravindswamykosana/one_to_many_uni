package one_to_many_uni.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import one_to_many_uni.dto.Country;
import one_to_many_uni.dto.State;

public class StateCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("arvind");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void saveState(int id,State state){
		Country db = em.find(Country.class, id);
		if(db!=null) {
			et.begin();
			List<State> dbm = new ArrayList<State>();
			State st = em.merge(state);
			dbm.add(st);
			db.setStates(dbm);
			et.commit();
		}
		else {
			System.out.println("not found...!");
		}
	}
	public void fetch(int id){
		State db = em.find(State.class, id);
		if(db!=null){
			System.out.println(db);
		}
		else {
			System.out.println("id not found..!");
		}
	}
	public void deleteState(int id) {
		State db = em.find(State.class , id);
		if(db!=null) {
			et.begin();
			em.remove(db);
			et.commit();
		}
		else {
			System.out.println("id not found for deleting...!");
		}
	}
	public void updateState(State state) {
		State db = em.find(State.class,state.getId());
		if(db!=null) {
			if(state.getName()!=null) {
				db.setName(state.getName());
			}
			if(state.getCm()!=null) {
				db.setCm(state.getCm());
			}
			if(state.getDistricts()!=0) {
				db.setDistricts(state.getDistricts());
			}
			if(state.getLanguage()!=null) {
				db.setLanguage(state.getLanguage());
			}
			et.begin();
			em.merge(db);
			et.commit();
		}
		else {
			System.out.println("id not found");
		}
	}
	public void fetchAll(){
		Query query = em.createQuery("select a from State a");
		List<Country> li = query.getResultList();
		System.out.println(li);
	}
}

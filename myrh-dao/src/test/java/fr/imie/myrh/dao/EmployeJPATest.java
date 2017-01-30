package fr.imie.myrh.dao;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.model.Employe;

public class EmployeJPATest {

	public static void main(String[] args) {
		// Utilisation date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// mise en place de l'entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();

		// Test 1 : Insertion d'un employé
		System.out.println("REQUEST 1 : CREATION D'UN EMPLOYE");
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		
		//creation de l'employé
		
		Employe employe = new Employe();
		employe.setName("Laura");
		employe.setSurname("Souchu");
		try {
			employe.setBirthdate(sdf.parse("28/11/1996"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employe.setNss("296117290918124");
		employe.setSalary(Double.parseDouble("12000"));
		try {
			employe.setArrival_date(sdf.parse("19/09/2016"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			employe.setDeparture_date(sdf.parse("02/02/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.persist(employe);
		trx.commit();
		
		
		// Test 2

	}
}

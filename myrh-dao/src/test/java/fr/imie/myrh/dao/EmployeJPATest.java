package fr.imie.myrh.dao;

import java.util.Date;
import java.util.List;
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

		// creation de l'employé

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
		Employe employeFind = (Employe) em.createNamedQuery("Employe.findById")
				.setParameter("idVar", Long.parseLong("1")).getSingleResult();
		System.out.println("REQUEST 2 : RECHERCHE EMPLOYE AVEC ID=1 \n");
		System.out.println(employeFind.getName());

		// Test 3
		List<Employe> list = em.createNamedQuery("Employe.findAll", Employe.class).getResultList();
		System.out.println("REQUEST 3 : LISTE DES EMPLOYES \n");
		System.out.println(list.toString());

		// Test 4
		List<Employe> employeName = em.createNamedQuery("Employe.findByName", Employe.class).setParameter("val", "laura").getResultList();
		System.out.println("REQUEST 4 : RECHERCHE EMPLOYE PAR NOM \n");
		if (employeName != null) {
			System.out.println(employeName.get(0).getName());
		}
		
		//Test 5
		List<Employe> employeBySalary = em.createNamedQuery("Employe.findByOverSalary", Employe.class).setParameter("salary", Double.parseDouble("10000")).getResultList();
		System.out.println("REQUEST 5 : RECHERCHE EMPLOYE PAR SALAIRE \n");
		if (employeName != null) {
			System.out.println(employeName.toString());
		}
		
		//Test 6
		trx.begin();
		
		Employe employeUpdate = (Employe) em.createNamedQuery("Employe.findById")
				.setParameter("idVar", Long.parseLong("1")).getSingleResult();
		try {
			employeUpdate.setDeparture_date(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.persist(employeUpdate);
		trx.commit();
		
		System.out.println("REQUEST 6 : UPDATE EMPLOYE \n");
		System.out.println(employeUpdate.getDeparture_date());
		
		//Test 7
		System.out.println("REQUEST 7 : DELETE EMPLOYE 3 \n");
		Employe employeDelete = (Employe) em.createNamedQuery("Employe.findById")
				.setParameter("idVar", Long.parseLong("3")).getSingleResult();
		
		trx.begin();
		
		em.remove(employeDelete);
		trx.commit();
	}
}

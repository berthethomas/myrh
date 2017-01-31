package fr.imie.myrh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.dao.model.Employe;

public class DepartementJPATest {
	public static void main(String[] args) {
		// mise en place de l'entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		EntityManager em = emf.createEntityManager();

		// Test 1 : Insertion d'un département
		System.out.println("REQUEST 1 : CREATION D'UN DEPARTEMENT");
		EntityTransaction trx = em.getTransaction();
		trx.begin();

		// creation du département

		Departement departement = new Departement();
		departement.setName("Comptabilité");
		departement.setCode("CO");
		departement.setDescription("Département de la comptabilité");

		em.persist(departement);
		trx.commit();

		// Test 2 : Liste des employé du département compta
		List<Employe> list = em.createNamedQuery("Employe.findByDepartment", Employe.class).setParameter("code", "CO")
				.getResultList();
		System.out.println("REQUEST 2 : LISTE DES EMPLOYES DU CO \n");
		System.out.println(list.toString());

		// Test 3 : Employé le plus ancien du département finance FI
		List<Employe> listEmployeOld = em.createNamedQuery("Employe.findByDepartmentOlder", Employe.class)
				.setParameter("code", "FI").getResultList();

		System.out.println("REQUEST 3 : EMPLOYE DU FI LE PLUS ANCIEN \n");
		if (listEmployeOld.get(0) != null) {
			System.out.println(listEmployeOld.get(0).getName());
		}
	}
}

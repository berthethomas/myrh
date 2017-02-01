package fr.imie.myrh.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.ifc.IEmployeDAO;
import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.dao.model.Employe;

public class EmployeDAOImpl implements IEmployeDAO {

	EntityManager em;
	EntityTransaction trx;
	
	public EmployeDAOImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
		trx = em.getTransaction();
	}

	public List<Employe> findAll() {
		List<Employe> list = em.createNamedQuery("Employe.findAll", Employe.class).getResultList();
		return list;
	}

	public Employe findById(Long id) {
		Employe employeFind = (Employe) em.createNamedQuery("Employe.findById")
				.setParameter("idVar", id).getSingleResult();
		return employeFind;

	}

	public List<Employe> findByName(String name) {
		List<Employe> listEmployeName = em.createNamedQuery("Employe.findByName", Employe.class).setParameter("val", name).getResultList();
		return listEmployeName;
	}

	public List<Employe> findBySurname(String surname) {
		List<Employe> listEmployeSurname = em.createNamedQuery("Employe.findBySurname", Employe.class).setParameter("surname", surname).getResultList();
		return listEmployeSurname;
	}

	public List<Employe> findByBirthdate(Date birthdate) {
		List<Employe> listEmployeBirthdate = em.createNamedQuery("Employe.findByBirthdate", Employe.class).setParameter("birthdate", birthdate).getResultList();
		return listEmployeBirthdate;
	}

	public Employe findByNss(String nss) {
		Employe employeNss = em.createNamedQuery("Employe.findByNss", Employe.class).setParameter("nss", nss).getSingleResult();
		return employeNss;
	}

	public List<Employe> findByLessSalary(Double salary) {
		List<Employe> listEmployeLessSalary = em.createNamedQuery("Employe.findByLessSalary", Employe.class).setParameter("salary", salary).getResultList();
		return listEmployeLessSalary;
	}

	public List<Employe> findByUpperSalary(Double salary) {
		List<Employe> listEmployeUpperSalary = em.createNamedQuery("Employe.findByUpperSalary", Employe.class).setParameter("salary", salary).getResultList();
		return listEmployeUpperSalary;
	}

	public List<Employe> findByArrivalDate(Date arrival_date) {
		List<Employe> listEmployeArrivalDate = em.createNamedQuery("Employe.findByArrivalDate", Employe.class).setParameter("arrival_date", arrival_date).getResultList();
		return listEmployeArrivalDate;
	}

	public List<Employe> findByDepartureDate(Date departure_date) {
		List<Employe> listEmployeDepartureDate = em.createNamedQuery("Employe.findByDepartureDate", Employe.class).setParameter("departure_date", departure_date).getResultList();
		return listEmployeDepartureDate;
	}

	public List<Employe> findByDepartment(Departement departement) {
		List<Employe> listEmployeDepartment = em.createNamedQuery("Employe.findByDepartment", Employe.class).setParameter("departement", departement.getCode()).getResultList();
		return listEmployeDepartment;
	}

	public Employe createEmploye(Employe employe) {
		trx.begin();
		em.persist(employe);
		trx.commit();
		return employe;
	}

	public Employe updateEmploye(Employe employe) {
		trx.begin();
		em.persist(employe);
		trx.commit();
		return employe;
	}

	public void deleteEmploye(Employe employe) {
		trx.begin();
		em.remove(employe);
		trx.commit();
		
		
	}

}

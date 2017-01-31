package fr.imie.myrh.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.ifc.IDepartementDAO;
import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.dao.model.Employe;

public class DepartementDAOImpl implements IDepartementDAO{

	EntityManager em;
	EntityTransaction trx;
	
	public DepartementDAOImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
		trx = em.getTransaction();
	}
	
	public List<Departement> findAll() {
		List<Departement> list = em.createNamedQuery("Departement.findAll", Departement.class).getResultList();
		return list;
	}

	public Departement findById(Long id) {
		Departement departementFind = (Departement) em.createNamedQuery("Departement.findById").setParameter("idVar", id).getSingleResult();
		return departementFind;
	}

	public List<Departement> findByName(String name) {
		List<Departement> listDepartementName = em.createNamedQuery("Departement.findByName", Departement.class).setParameter("name", name).getResultList();
		return listDepartementName;
	}

	public List<Departement> findByCode(String code) {
		List<Departement> listDepartementCode = em.createNamedQuery("Departement.findByCode", Departement.class).setParameter("code", code).getResultList();
		return listDepartementCode;
	}

	public Departement createDepartment(Departement departement) {
		trx.begin();
		em.persist(departement);
		trx.commit();
		return departement;
	}

	public Departement updateDepartment(Departement departement) {
		trx.begin();
		em.persist(departement);
		trx.commit();
		return departement;
	}

	public void deleteDepartment(Departement departement) {
		trx.begin();
		em.remove(departement);
		trx.commit();
		
	}

}

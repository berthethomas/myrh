package fr.imie.myrh.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.ifc.IJourneeDAO;
import fr.imie.myrh.dao.model.Journee;
import fr.imie.myrh.dao.model.Projet;

public class JourneeDAOImpl implements IJourneeDAO{

	EntityManager em;
	EntityTransaction trx;
	
	public JourneeDAOImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
		trx = em.getTransaction();
	}

	public List<Journee> findAll() {
		List<Journee> list = em.createNamedQuery("Journee.findAll", Journee.class).getResultList();
		return list;
	}

	public Journee findById(Long id) {
		Journee journeeFind = (Journee) em.createNamedQuery("Journee.findById").setParameter("idVar", id).getSingleResult();
		return journeeFind;
	}

	public List<Journee> findByDate(Date date) {
		List<Journee> findByDate = em.createNamedQuery("Journee.findByDate", Journee.class).setParameter("date", date).getResultList();
		return findByDate;
	}

	public List<Journee> findByDuree(Double duree) {
		List<Journee> findByDuree = em.createNamedQuery("Journee.findByDuree", Journee.class).setParameter("duree", duree).getResultList();
		return findByDuree;
	}

	public Journee createJournée(Journee journee) {
		trx.begin();
		em.persist(journee);
		trx.commit();
		return journee;
	}

	public Journee updateJournee(Journee journee) {
		trx.begin();
		em.persist(journee);
		trx.commit();
		return journee;
	}

	public void deleteJournee(Journee journee) {
		trx.begin();
		em.remove(journee);
		trx.commit();
	}
	
}

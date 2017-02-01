package fr.imie.myrh.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.ifc.IProjetDAO;
import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.dao.model.Projet;

public class ProjetDAOImpl implements IProjetDAO{
	
	EntityManager em;
	EntityTransaction trx;
	
	public ProjetDAOImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
		trx = em.getTransaction();
	}

	public List<Projet> findAll() {
		List<Projet> list = em.createNamedQuery("Projet.findAll", Projet.class).getResultList();
		return list;
	}

	public Projet findById(Long id) {
		Projet projetFind = (Projet) em.createNamedQuery("Projet.findById").setParameter("idVar", id).getSingleResult();
		return projetFind;
	}

	public Projet findByCode(String code) {
		Projet findByCode = (Projet) em.createNamedQuery("Projet.findByCode").setParameter("code", code).getSingleResult();
		return findByCode;
	}

	public List<Projet> findByDateDebut(Date date_debut) {
		List<Projet> findByDateDebut = em.createNamedQuery("Projet.findByDateDebut", Projet.class).setParameter("date_debut", date_debut).getResultList();
		return findByDateDebut;
	}

	public List<Projet> findByDateFin(Date date_fin) {
		List<Projet> findByDateFin = em.createNamedQuery("Projet.findByDateFin", Projet.class).setParameter("date_fin", date_fin).getResultList();
		return findByDateFin;
	}

	public Projet createProjet(Projet projet) {
		trx.begin();
		em.persist(projet);
		trx.commit();
		return projet;
	}

	public Projet updateProjet(Projet projet) {
		trx.begin();
		em.persist(projet);
		trx.commit();
		return projet;
	}

	public void deleteProjet(Projet projet) {
		trx.begin();
		em.remove(projet);
		trx.commit();
	}
	

}

package fr.imie.myrh.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.ifc.IHistoriqueDemandeDAO;
import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.dao.model.HistoriqueDemande;

public class HistoriqueDemandeDAOImpl implements IHistoriqueDemandeDAO {

	EntityManager em;
	EntityTransaction trx;

	public HistoriqueDemandeDAOImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
		trx = em.getTransaction();
	}

	public List<HistoriqueDemande> findAll() {
		List<HistoriqueDemande> list = em.createNamedQuery("HistoriqueDemande.findAll", HistoriqueDemande.class)
				.getResultList();
		return list;
	}

	public HistoriqueDemande findById(Long id) {
		HistoriqueDemande historiqueDemande = (HistoriqueDemande) em.createNamedQuery("HistoriqueDemande.findById")
				.setParameter("idVar", id).getSingleResult();
		return historiqueDemande;
	}

	public List<HistoriqueDemande> findByDate(Date date) {
		List<HistoriqueDemande> list = em.createNamedQuery("HistoriqueDemande.findByDate", HistoriqueDemande.class)
				.setParameter("val", date).getResultList();
		return list;
	}

	public HistoriqueDemande createHistoriqueDemande(HistoriqueDemande historique_demande) {
		trx.begin();
		em.persist(historique_demande);
		trx.commit();
		return historique_demande;
	}

	public HistoriqueDemande updateHistoriqueDemande(HistoriqueDemande historique_demande) {
		trx.begin();
		em.persist(historique_demande);
		trx.commit();
		return historique_demande;
	}

	public void deleteHistoriqueDemande(HistoriqueDemande historique_demande) {
		trx.begin();
		em.remove(historique_demande);
		trx.commit();
	}

}

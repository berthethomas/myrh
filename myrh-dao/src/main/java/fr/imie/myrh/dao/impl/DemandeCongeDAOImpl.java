package fr.imie.myrh.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.imie.myrh.dao.ifc.IDemandeCongeDAO;
import fr.imie.myrh.dao.model.DemandeConge;

public class DemandeCongeDAOImpl implements IDemandeCongeDAO {

	EntityManager em;
	EntityTransaction trx;

	public DemandeCongeDAOImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myRhPersistenceUnit");
		em = emf.createEntityManager();
		trx = em.getTransaction();
	}

	public List<DemandeConge> findAll() {
		List<DemandeConge> list = em.createNamedQuery("DemandeConge.findAll", DemandeConge.class).getResultList();
		return list;
	}

	public DemandeConge findById(Long id) {
		DemandeConge demandeConge = (DemandeConge) em.createNamedQuery("DemandeConge.findById")
				.setParameter("idVar", id).getSingleResult();
		return demandeConge;
	}

	public List<DemandeConge> findByDateDemande(Date date_demande) {
		List<DemandeConge> list = em.createNamedQuery("DemandeConge.findByDateDemande", DemandeConge.class)
				.setParameter("val", date_demande).getResultList();
		return list;
	}

	public List<DemandeConge> findByDateDebut(Date date_debut) {
		List<DemandeConge> list = em.createNamedQuery("DemandeConge.findByDateDebut", DemandeConge.class)
				.setParameter("val", date_debut).getResultList();
		return list;
	}

	public List<DemandeConge> findByDateFin(Date date_fin) {
		List<DemandeConge> list = em.createNamedQuery("DemandeConge.findByDateFin", DemandeConge.class)
				.setParameter("val", date_fin).getResultList();
		return list;
	}

	public List<DemandeConge> findByMotif(String motif) {
		List<DemandeConge> list = em.createNamedQuery("DemandeConge.findByMotif", DemandeConge.class)
				.setParameter("val", motif).getResultList();
		return list;
	}

	public List<DemandeConge> findByStatut(String statut) {
		List<DemandeConge> list = em.createNamedQuery("DemandeConge.findByStatut", DemandeConge.class)
				.setParameter("val", statut).getResultList();
		return list;
	}

	public List<DemandeConge> findByNbJours(Double nb_jours) {
		List<DemandeConge> list = em.createNamedQuery("DemandeConge.findByNbJours", DemandeConge.class)
				.setParameter("val", nb_jours).getResultList();
		return list;
	}

	public DemandeConge createDemandeConge(DemandeConge demande_conge) {
		trx.begin();
		em.persist(demande_conge);
		trx.commit();
		return demande_conge;
	}

	public DemandeConge updateDemandeConge(DemandeConge demande_conge) {
		trx.begin();
		em.persist(demande_conge);
		trx.commit();
		return demande_conge;
	}

	public void deleteDemandeConge(DemandeConge demande_conge) {
		trx.begin();
		em.remove(demande_conge);
		trx.commit();
	}

}

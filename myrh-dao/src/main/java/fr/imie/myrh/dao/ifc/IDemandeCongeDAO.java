package fr.imie.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.myrh.dao.model.DemandeConge;

public interface IDemandeCongeDAO {
	/*
	 * Récupérer tout les congés de demandes
	 */
	public List<DemandeConge> findAll();

	/*
	 * Récupérer un congé par son id
	 */
	public DemandeConge findById(Long id);

	/*
	 * Récupérer une liste de congé par leur datede demande
	 */
	public List<DemandeConge> findByDateDemande(Date date_demande);

	/*
	 * Récupérer une liste de congé par leur date de début
	 */
	public List<DemandeConge> findByDateDebut(Date date_debut);

	/*
	 * Récupérer une liste de congé par leur date de fin
	 */
	public List<DemandeConge> findByDateFin(Date date_fin);

	/*
	 * Récupérer une liste de congé par leur motif
	 */
	public List<DemandeConge> findByMotif(String motif);

	/*
	 * Récupérer une liste de congé par leur statut
	 */
	public List<DemandeConge> findByStatut(String statut);

	/*
	 * Récupérer une liste de congé par leur nb de jours
	 */
	public List<DemandeConge> findByNbJours(Double nb_jours);

	/*
	 * créer une demande de congé
	 */
	public DemandeConge createDemandeConge(DemandeConge demande_conge);

	/*
	 * Modifier une demande de congé
	 */
	public DemandeConge updateDemandeConge(DemandeConge demande_conge);

	/*
	 * Supprimer une demande de congé
	 */
	public void deleteDemandeConge(DemandeConge demande_conge);
}

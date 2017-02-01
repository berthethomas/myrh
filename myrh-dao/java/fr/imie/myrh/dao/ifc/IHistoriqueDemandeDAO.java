package fr.imie.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.myrh.dao.model.HistoriqueDemande;

public interface IHistoriqueDemandeDAO {
	/*
	 * Récupérer tout les historiques de demandes
	 */
	public List<HistoriqueDemande> findAll();

	/*
	 * Récupérer un historique par son id
	 */
	public HistoriqueDemande findById(Long id);

	/*
	 * Récupérer une liste d'historique par leur date
	 */
	public List<HistoriqueDemande> findByDate(Date date);

	/*
	 * créer un historique de demande
	 */
	public HistoriqueDemande createHistoriqueDemande(HistoriqueDemande historique_demande);

	/*
	 * Modifier un historique de demande
	 */
	public HistoriqueDemande updateHistoriqueDemande(HistoriqueDemande historique_demande);

	/*
	 * Supprimer un historique de demande
	 */
	public void deleteHistoriqueDemande(HistoriqueDemande historique_demande);
}

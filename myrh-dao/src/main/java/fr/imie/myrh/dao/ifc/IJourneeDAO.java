package fr.imie.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.myrh.dao.model.Journee;

public interface IJourneeDAO {

	/*
	 * Récupérer toutes les journées
	 */
	public List<Journee> findAll();
	
	/*
	 * Récupérer une journée par son id
	 */
	public Journee findById(Long id);
	
	/*
	 * Récupérer une liste de journées par leur date
	 */
	public List<Journee> findByDate(Date date);
	
	/*
	 * Récupérer une liste de journées par leur durée
	 */
	public List<Journee> findByDuree(Double duree);
	
	/*
	 * créer une journée
	 */
	public Journee createJournée(Journee journee);
	
	/*
	 * Modifier une journée
	 */
	public Journee updateJournee(Journee journee);
	
	/*
	 * Supprimer une journee
	 */
	public void deleteJournee(Journee journee);
	
	
	
}

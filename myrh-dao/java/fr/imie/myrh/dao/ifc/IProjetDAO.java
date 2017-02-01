package fr.imie.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.myrh.dao.model.Projet;

public interface IProjetDAO {

	/*
	 * Récupérer tout les projets
	 */
	public List<Projet> findAll();
	
	/*
	 * Récupérer un projet par son id
	 */
	public Projet findById(Long id);
	
	/*
	 * Récupérer une liste de projets par leur code
	 */
	public Projet findByCode(String code);
	
	/*
	 * Récupérer une liste de projets par leur date de debut
	 */
	public List<Projet> findByDateDebut(Date date_debut);
	
	/*
	 * Récupérer une liste de projets par leur date de fin
	 */
	public List<Projet> findByDateFin(Date date_fin);
	
	/*
	 * créer un projet
	 */
	public Projet createProjet(Projet projet);
	
	/*
	 * Modifier un projet
	 */
	public Projet updateProjet(Projet projet);
	
	/*
	 * Supprimer un projet
	 */
	public void deleteProjet(Projet projet);
	
	
}

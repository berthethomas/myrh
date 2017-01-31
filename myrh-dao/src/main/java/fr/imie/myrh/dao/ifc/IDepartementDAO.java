package fr.imie.myrh.dao.ifc;

import java.util.List;

import fr.imie.myrh.dao.model.Departement;

public interface IDepartementDAO {
	
	/*
	 * Récupérer tout les départements
	 */
	public List<Departement> findAll();
	
	/*
	 * Récupérer un département par son id
	 */
	public Departement findById(Long id);
	
	/*
	 * Récupérer une liste de départements par leur nom
	 */
	public List<Departement> findByName(String name);
	
	/*
	 * Récupérer une liste de départements par leur code
	 */
	public List<Departement> findByCode(String code);
	
	/*
	 * créer un département
	 */
	public Departement createDepartment(Departement departement);
	
	/*
	 * Modifier un département
	 */
	public Departement updateDepartment(Departement departement);
	
	/*
	 * Supprimer un département
	 */
	public void deleteDepartment(Departement departement);
	
	
	
	

}

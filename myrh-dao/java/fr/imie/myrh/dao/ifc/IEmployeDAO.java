package fr.imie.myrh.dao.ifc;

import java.util.Date;
import java.util.List;

import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.dao.model.Employe;

public interface IEmployeDAO {

	/*
	 * Récupérer tout les employés
	 */
	public List<Employe> findAll();
	
	/*
	 * Récupérer un employé par son id
	 */
	public Employe findById(Long id);
	
	/*
	 * Récupérer une liste d'employés par leur nom
	 */
	public List<Employe> findByName(String name);
	
	/*
	 * Récupérer une liste d'employés par leur prénom
	 */
	public List<Employe> findBySurname(String surname);
	
	/*
	 * Récupérer une liste d'employés par leur date de naissance
	 */
	public List<Employe> findByBirthdate(Date birthdate);
	
	/*
	 * Récupérer un employés par son nss
	 */
	public Employe findByNss(String nss);
	
	/*
	 * Récupérer une liste d'employés avec un salaire inférieur à une valeur
	 */
	public List<Employe> findByLessSalary(Double salary);
	
	/*
	 * Récupérer une liste d'employés avec un salaire supérieur à une valeur
	 */
	public List<Employe> findByUpperSalary(Double salary);
	
	/*
	 * Récupérer une liste d'employés par leur date d'arrivée
	 */
	public List<Employe> findByArrivalDate(Date arrival_date);
	
	/*
	 * Récupérer une liste d'employés par leur date de départ
	 */
	public List<Employe> findByDepartureDate(Date departure_date);
	
	/*
	 * Récupérer une liste d'employés par leur département
	 */
	public List<Employe> findByDepartment(Departement departement);
	
	
	/*
	 * créer un employer
	 */
	public Employe createEmploye(Employe employe);
	
	
	/*
	 * Modifier un employé
	 */
	public Employe updateEmploye(Employe employe);
	
	/*
	 * Supprimer un employé
	 */
	public void deleteEmploye(Employe employe);
	
	
	
	
	
}

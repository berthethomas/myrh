package fr.imie.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Entité de l'employé
 */

@Entity
@Table(name = "T_EMPLOYE")

@NamedQueries({ @NamedQuery(name = "Employe.findAll", query = "SELECT e FROM Employe e"),
		@NamedQuery(name = "Employe.findById", query = "SELECT e FROM Employe e WHERE e.id= :idVar") })

public class Employe implements Serializable {

	private static final long serialVersionUID = 3025059727134698334L;

	/*
	 * Id de l'employé
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/*
	 * Nom de l'employé
	 */
	@Column(name = "FNAME")
	private String name;

	/*
	 * Prénom de l'employé
	 */
	@Column(name = "LNAME")
	private String surname;

	/*
	 * Date de naissance de l'employé
	 */
	@Column(name = "BIRTHDATE")
	@Temporal(TemporalType.DATE)
	private Date birthdate;

	/*
	 * Numéro de sécurité social de l'employé
	 */
	@Column(name = "NSS")
	private String nss;

	/*
	 * Salaire de l'employé
	 */
	@Column(name = "SALARY")
	private Double salary;

	/*
	 * Date d'arrivé de l'employé
	 */
	@Column(name = "ARRIVAL_DATE")
	@Temporal(TemporalType.DATE)
	private Date arrival_date;

	/*
	 * Date de départ de l'employé
	 */
	@Column(name = "DEPARTURE_DATE")
	@Temporal(TemporalType.DATE)
	private Date departure_date;

	/*
	 * Département de l'employé
	 */
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="employes") private Departement departement;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	public Date getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	/*
	 * public Departement getDepartement() { return departement; }
	 * 
	 * public void setDepartement(Departement departement) { this.departement =
	 * departement; }
	 */

}

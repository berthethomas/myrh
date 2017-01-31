package fr.imie.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJET")

@NamedQueries({ @NamedQuery(name = "Projet.findAll", query = "SELECT p FROM Projet p"),
		@NamedQuery(name = "Projet.findById", query = "SELECT p FROM Projet p WHERE p.id= :idVar"),
		@NamedQuery(name = "Projet.findByCode", query = "SELECT p FROM Projet p WHERE p.code= :code"),
		@NamedQuery(name = "Projet.findByDateDebut", query = "SELECT p FROM Projet p WHERE p.date_debut= :date_debut"),
		@NamedQuery(name = "Projet.findByDateFin", query = "SELECT p FROM Projet p WHERE p.date_fin= :date_fin"), })

public class Projet implements Serializable {

	private static final long serialVersionUID = 3474126826620845747L;

	/*
	 * Id du projet
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/*
	 * Code du projet
	 */
	@Column(name = "CODE")
	private String code;

	/*
	 * Description du projet
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	/*
	 * Date début du projet
	 */
	@Column(name = "DATE_DEBUT")
	private Date date_debut;

	/*
	 * Code du projet
	 */
	@Column(name = "DATE_FIN")
	private Date date_fin;

	/*
	 * liste des journées passées sur le projet
	 */
	@OneToMany(mappedBy = "projet")
	private List<Journee> journees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public List<Journee> getJournees() {
		return journees;
	}

	public void setJournees(List<Journee> journees) {
		this.journees = journees;
	}

}

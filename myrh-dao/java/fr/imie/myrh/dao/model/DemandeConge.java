package fr.imie.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_DEMANDE_CONGE")

@NamedQueries({ @NamedQuery(name = "DemandeConge.findAll", query = "SELECT d FROM DemandeConge d"),
		@NamedQuery(name = "DemandeConge.findById", query = "SELECT d FROM DemandeConge d WHERE d.id= :idVar"),
		@NamedQuery(name = "DemandeConge.findByDateDemande", query = "SELECT d FROM DemandeConge d WHERE d.date_demande= :val"),
		@NamedQuery(name = "DemandeConge.findByDateDebut", query = "SELECT d FROM DemandeConge d WHERE d.date_debut= :val"),
		@NamedQuery(name = "DemandeConge.findByDateFin", query = "SELECT d FROM DemandeConge d WHERE d.date_fin= :val"),
		@NamedQuery(name = "DemandeConge.findByMotif", query = "SELECT d FROM DemandeConge d WHERE d.motif= :val"),
		@NamedQuery(name = "DemandeConge.findByStatut", query = "SELECT d FROM DemandeConge d WHERE d.statut= :val"),
		@NamedQuery(name = "DemandeConge.findByNbJours", query = "SELECT d FROM DemandeConge d WHERE d.nb_jours= :val") })

public class DemandeConge implements Serializable {

	private static final long serialVersionUID = 6396151735674986674L;

	/*
	 * Id de la demande
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/*
	 * Date de création de la demande
	 */
	@Column(name = "DATE_DEMANDE")
	@Temporal(TemporalType.DATE)
	private Date date_demande;

	/*
	 * Date de début de la demande
	 */
	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_debut;

	/*
	 * Date de fin de la demande
	 */
	@Column(name = "DATE_FIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_fin;

	/*
	 * Motif de la demande
	 */
	@Column(name = "MOTIF")
	private String motif;

	/*
	 * Statut de la demande
	 */
	@Column(name = "STATUT")
	private String statut;

	/*
	 * Nb de jours de la demande
	 */
	@Column(name = "NB_JOURS")
	private Double nb_jours;

	/*
	 * Employe qui a fait la demande de congé
	 */
	@ManyToOne
	@JoinColumn(name = "EMPLOYE")
	private Employe employe;

	/*
	 * Liste des historique de la demande de congé
	 */
	@OneToMany(mappedBy = "demande_conge")
	private List<HistoriqueDemande> historiques;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_demande() {
		return date_demande;
	}

	public void setDate_demande(Date date_demande) {
		this.date_demande = date_demande;
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

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Double getNb_jours() {
		return nb_jours;
	}

	public void setNb_jours(Double nb_jours) {
		this.nb_jours = nb_jours;
	}

	public List<HistoriqueDemande> getHistoriques() {
		return historiques;
	}

	public void setHistoriques(List<HistoriqueDemande> historiques) {
		this.historiques = historiques;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}

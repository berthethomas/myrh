package fr.imie.myrh.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_HISTORIQUE_DEMANDE")

@NamedQueries({ @NamedQuery(name = "HistoriqueDemande.findAll", query = "SELECT d FROM HistoriqueDemande d"),
		@NamedQuery(name = "HistoriqueDemande.findById", query = "SELECT d FROM HistoriqueDemande d WHERE d.id= :idVar"),
		@NamedQuery(name = "HistoriqueDemande.findByDate", query = "SELECT d FROM HistoriqueDemande d WHERE d.date= :val") })

public class HistoriqueDemande implements Serializable {

	private static final long serialVersionUID = -1142844039532745191L;

	/*
	 * Id de la demande
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/*
	 * Date de creation du message
	 */
	@Column(name = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;

	/*
	 * Commentaire du message
	 */
	@Column(name = "COMMENTAIRE")
	private String commentaire;

	/*
	 * Demande de congé lié à l'historique
	 */

	@ManyToOne
	@JoinColumn(name = "DEMANDE_CONGE")
	private DemandeConge demande_conge;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public DemandeConge getDemande_conge() {
		return demande_conge;
	}

	public void setDemande_conge(DemandeConge demande_conge) {
		this.demande_conge = demande_conge;
	}

}

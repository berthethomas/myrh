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

@Entity
@Table(name = "JOURNEE")

@NamedQueries({ @NamedQuery(name = "Journee.findAll", query = "SELECT j FROM Journee j"),
	@NamedQuery(name = "Journee.findById", query = "SELECT j FROM Journee j WHERE j.id= :idVar"),
	@NamedQuery(name = "Journee.findByDate", query = "SELECT j FROM Journee j WHERE j.date= :date"),
	@NamedQuery(name = "Journee.findByDuree", query = "SELECT j FROM Journee j WHERE j.duree= :duree"),
	})

public class Journee implements Serializable{
	
	
	private static final long serialVersionUID = -7721772270759672501L;

	/*
	 * Id de la journée
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/*
	 * Date
	 */
	@Column(name = "DATE")
	private Date date;
	
	/*
	 * Durée sur le projet
	 */
	@Column(name = "DUREE")
	private Double duree;
	
	/*
	 * Commentaire sur ce temps
	 */
	@Column(name = "COMMENTAIRE")
	private String commentaire;

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

	public Double getDuree() {
		return duree;
	}

	public void setDuree(Double duree) {
		this.duree = duree;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	

}

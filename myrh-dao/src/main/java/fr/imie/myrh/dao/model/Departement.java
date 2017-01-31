package fr.imie.myrh.dao.model;

import java.io.Serializable;
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

/*
 * Entité du département
 */

@Entity
@Table(name = "T_DEPARTMENT")

@NamedQueries({ @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
	@NamedQuery(name = "Departement.findById", query = "SELECT d FROM Departement d WHERE d.id= :idVar")})
public class Departement implements Serializable {

	private static final long serialVersionUID = 3910098696718882951L;

	/*
	 * Id du département
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/*
	 * Nom du département
	 */
	@Column(name = "NAME")
	private String name;

	/*
	 * COde du département
	 */
	@Column(name = "CODE")
	private String code;

	/*
	 * Description du département
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	/*
	 * Liste des employés liés au département
	 */
	@OneToMany(mappedBy = "departement")
	private List<Employe> employes;

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

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
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

}

package fr.imie.myrh.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * Entité du département
 */

@Entity
@Table(name = "departement")
public class Departement implements Serializable {

	private static final long serialVersionUID = 3910098696718882951L;

	/*
	 * Id du département
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/*
	 * Nom du département
	 */
	@Column(name = "NAME")
	private String name;

	/*
	 * Liste des employés liés au département
	 */
	
	/*@OneToMany(mappedBy = "departement")
	private List<Employe> employes;
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

	/*public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}*/

}

package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.imie.myrh.dao.ifc.IDepartementDAO;
import fr.imie.myrh.dao.impl.DepartementDAOImpl;
import fr.imie.myrh.dao.model.Departement;

@ManagedBean(name = "employe")
@SessionScoped
public class EmployeForm implements Serializable {

	private static final long serialVersionUID = -4010575618358934284L;

	private final IDepartementDAO _departementDaoService = new DepartementDAOImpl();

	private String name;
	private String surname;
	private Date birthdate;
	private Date arrival_date;
	private Date departure_date;
	private String nss;
	private Double salary;
	private Departement departement;
	private List<Departement> departements;

	public EmployeForm() {
		departements = _departementDaoService.findAll();
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
}

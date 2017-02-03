package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.imie.myrh.dao.ifc.IEmployeDAO;
import fr.imie.myrh.dao.impl.EmployeDAOImpl;
import fr.imie.myrh.dao.model.Employe;

@ManagedBean(name = "employeViewController")
public class EmployeViewController implements Serializable {

	private static final long serialVersionUID = -4592321803232225516L;

	Logger log = Logger.getLogger("EmployeViewController");

	private List<Employe> employeItems;
	private Employe employe;

	@ManagedProperty(value = "#{departementViewController}")
	private DepartementViewController departementViewController;

	private final IEmployeDAO _employeDaoService = new EmployeDAOImpl();

	@PostConstruct
	public void init() {

		log.log(Level.INFO, "hello");
		employeItems = (List<Employe>) _employeDaoService.findAll();
		employe = new Employe();
	}

	// creation d'un employe
	public Employe addEmploye() {
		System.out.println(this.employe.getDepartement());
		// _employeDaoService.createEmploye(this.employe);
		return this.employe;
	}

	// GETTERS & SETTERS
	public List<Employe> getEmployeItems() {
		return employeItems;
	}

	public void setEmployeItems(List<Employe> employeItems) {
		this.employeItems = employeItems;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public DepartementViewController getDepartementViewController() {
		return departementViewController;
	}

	public void setDepartementViewController(DepartementViewController departementViewController) {
		this.departementViewController = departementViewController;
	}

	public void selectEmploye(Employe employe) {
		this.employe = employe;
	}
}

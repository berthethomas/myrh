package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import fr.imie.myrh.dao.ifc.IEmployeDAO;
import fr.imie.myrh.dao.impl.EmployeDAOImpl;
import fr.imie.myrh.dao.model.Employe;

@ManagedBean(name = "employeViewController")
public class EmployeViewController implements Serializable {

	private static final long serialVersionUID = -4592321803232225516L;
	
	Logger log = Logger.getLogger("EmmployeViewController");

	private List<Employe> employeItems;

	private final IEmployeDAO _employeDaoService = new EmployeDAOImpl();
	
	private Employe employe;

	@PostConstruct
	public void init() {
		log.log(Level.INFO, "hello");
		employeItems = (List<Employe>) _employeDaoService.findAll();
	}

	public List<Employe> getEmployeItems() {
		return employeItems;
	}
	
	
	
	public Employe addEmploye(Employe employe) {
		_employeDaoService.createEmploye(employe);
		
		return employe;
	}

	public void setEmployeItems(List<Employe> employeItems) {
		this.employeItems = employeItems;
	}
}

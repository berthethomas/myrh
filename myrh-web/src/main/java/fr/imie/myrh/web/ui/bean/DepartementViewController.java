package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.imie.myrh.dao.ifc.IDepartementDAO;
import fr.imie.myrh.dao.impl.DepartementDAOImpl;
import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.web.ui.bean.DepartementForm;


@ManagedBean(name = "departementViewController")

public class DepartementViewController implements Serializable {

	private static final long serialVersionUID = 5338454008888537318L;

	Logger log = Logger.getLogger("DepartementViewController");

	private List<Departement> departementItems;

	private final IDepartementDAO _departementDaoService = new DepartementDAOImpl();

	@ManagedProperty(value = "#{departement}")
	private DepartementForm departementform;
	
	public DepartementForm getDepartementform() {
		return departementform;
	}

	public void setDepartementform(DepartementForm departementform) {
		this.departementform = departementform;
	}

	@PostConstruct
	public void init() {
		//log.log(Level.INFO, "hello");
		departementItems = (List<Departement>) _departementDaoService.findAll();
		
	}

	public List<Departement> getDepartementItems() {
		return departementItems;
	}

	public void setDepartementItems(List<Departement> departementItems) {
		this.departementItems = departementItems;
	}
	
	public String addDepartement(){
		
		Departement model = new Departement();
		model.setName(departementform.getName());
		model.setCode(departementform.getCode());
		model.setDescription(departementform.getDescription());
		
		 _departementDaoService.createDepartment(model);
		 log.log(Level.INFO, "hello");
		 return "success";		
		
	}
	
	 
}

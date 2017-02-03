package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.imie.myrh.dao.ifc.IEmployeDAO;
import fr.imie.myrh.dao.impl.EmployeDAOImpl;
import fr.imie.myrh.dao.model.Employe;

@ManagedBean(name = "employeViewController")
@ApplicationScoped()
public class EmployeViewController implements Serializable {

	private static final long serialVersionUID = -4592321803232225516L;

	Logger log = Logger.getLogger("EmmployeViewController");

	private List<Employe> employeItems;

	private final IEmployeDAO _employeDaoService = new EmployeDAOImpl();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@ManagedProperty(value = "#{employe}")
	private EmployeForm employe;

	public EmployeForm getEmploye() {
		return employe;
	}

	public void setEmploye(EmployeForm employe) {
		this.employe = employe;
	}

	@PostConstruct
	public void init() {
		log.log(Level.INFO, "hello");
		employeItems = (List<Employe>) _employeDaoService.findAll();
	}

	public List<Employe> getEmployeItems() {
		return employeItems;
	}

	public String addEmploye() {
		log.log(Level.INFO, "hello");
		Employe model = new Employe();
		model.setName(employe.getName());
		model.setSurname(employe.getSurname());
		/*try {
			model.setBirthdate(sdf.parse(employe.getBirthdate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			model.setArrival_date(sdf.parse(employe.getArrival_date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			model.setDeparture_date(sdf.parse(employe.getDeparture_date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		model.setSalary(employe.getSalary());
		model.setNss(employe.getNss());
		//model.setDepartement(employe.getDepartement());

		_employeDaoService.createEmploye(model);

		return "success";
	}

	public void setEmployeItems(List<Employe> employeItems) {
		this.employeItems = employeItems;
	}
}

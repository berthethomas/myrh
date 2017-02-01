package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.imie.myrh.dao.ifc.IEmployeDAO;
import fr.imie.myrh.dao.impl.EmployeDAOImpl;
import fr.imie.myrh.dao.model.Employe;

@ManagedBean(name="employeViewController")
public class EmployeViewController implements Serializable{

	private static final long serialVersionUID = -4592321803232225516L;
	
	private List<Employe> employeItems;
	
	private final IEmployeDAO _employeDaoService = new EmployeDAOImpl();

}

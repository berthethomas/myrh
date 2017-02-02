package fr.imie.myrh.web.ui.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean( name = "departement")
public class DepartementForm {
	
	private String name;
	private String code;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

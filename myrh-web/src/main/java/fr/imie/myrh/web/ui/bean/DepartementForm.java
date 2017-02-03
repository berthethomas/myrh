package fr.imie.myrh.web.ui.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped

@ManagedBean( name = "departement")
public class DepartementForm implements Serializable{
	
	
	private static final long serialVersionUID = 60145738014004874L;
	
	private Long id;
	private String name;
	private String code;
	private String description;
	
	
	
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

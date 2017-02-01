package fr.imie.myrh.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.imie.myrh.dao.model.Departement;

public class DepartementDAOImplTest {
	
	private DepartementDAOImpl departementDAOImpl = new DepartementDAOImpl();

	@Test
	public void testDepartementDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Departement> list = departementDAOImpl.findAll();
		Assert.assertEquals("CO", list.get(0).getCode());
	}

	@Test
	public void testFindById() {
		Departement var = departementDAOImpl.findById(Long.parseLong("2"));
		Assert.assertEquals("CO", var.getCode());		
	}

	@Test
	public void testFindByName() {
		List<Departement> list = departementDAOImpl.findByName("Comptabilité");
		Assert.assertEquals("Comptabilité", list.get(0).getName());
	}

	@Test
	public void testFindByCode() {
		List<Departement> list = departementDAOImpl.findByCode("CO");
		Assert.assertEquals("CO", list.get(0).getCode());
	}

	@Test
	public void testCreateDepartment() {
		Departement departement = new Departement();
		 departement.setCode("CO");
		 departement.setName("Comptabilité");
	     departementDAOImpl.createDepartment(departement);
	     
	     List<Departement> list = departementDAOImpl.findAll();
	     Assert.assertEquals(departement.getCode(), list.get(0).getCode());
	}

	@Test
	public void testUpdateDepartment() {
		Departement var = departementDAOImpl.findById(Long.parseLong("1"));
		var.setDescription("cacahuètes");
		departementDAOImpl.updateDepartment(var);
		
		List<Departement> list = departementDAOImpl.findAll();
	    Assert.assertEquals(var.getDescription(), list.get(0).getDescription());
	}

	@Test
	public void testDeleteDepartment() {
		Departement var = departementDAOImpl.findById(Long.parseLong("1"));
		departementDAOImpl.deleteDepartment(var);
	}

}

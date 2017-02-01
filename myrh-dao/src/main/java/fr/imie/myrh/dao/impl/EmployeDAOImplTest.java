package fr.imie.myrh.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.imie.myrh.dao.model.Departement;
import fr.imie.myrh.dao.model.Employe;

public class EmployeDAOImplTest {
	
	private EmployeDAOImpl employeDAOImpl = new EmployeDAOImpl();
	private DepartementDAOImpl departementDAOImpl = new DepartementDAOImpl();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testEmployeDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Employe> list = employeDAOImpl.findAll();
		Assert.assertEquals("Thomas", list.get(0).getName());
	}

	@Test
	public void testFindById() {
		Employe var = employeDAOImpl.findById(Long.parseLong("1"));
		Assert.assertEquals("Souchu", var.getName());
	}

	@Test
	public void testFindByName() {
		List<Employe> list = employeDAOImpl.findByName("Laura");
		Assert.assertEquals("Souchu", list.get(0).getName());
	}

	@Test
	public void testFindBySurname() {
		List<Employe> list = employeDAOImpl.findBySurname("Souchu");
		Assert.assertEquals("Souchu", list.get(0).getName());
	}

	@Test
	public void testFindByBirthdate() {
		
		try {
			List<Employe> list = employeDAOImpl.findByBirthdate(sdf.parse("01/02/2017"));
			Assert.assertEquals("Souchu", list.get(0).getName());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testFindByNss() {
		Employe var = employeDAOImpl.findByNss("12343");
		Assert.assertEquals("Souchu", var.getName());
	}

	@Test
	public void testFindByLessSalary() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByUpperSalary() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByArrivalDate() {
		try {
			List<Employe> list = employeDAOImpl.findByArrivalDate(sdf.parse("31/01/2017"));
			Assert.assertEquals("Souchu", list.get(0).getName());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByDepartureDate() {
		try {
			List<Employe> list = employeDAOImpl.findByDepartureDate(sdf.parse("31/01/2018"));
			Assert.assertEquals("Souchu", list.get(0).getName());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

	@Test
	public void testFindByDepartment() {
		List<Departement> var = departementDAOImpl.findByCode("CO");
		List<Employe> list = employeDAOImpl.findByDepartment(var.get(0));
		Assert.assertEquals("Souchu", list.get(0).getName());
	}

	@Test
	public void testCreateEmploye() {
		
		Departement var = departementDAOImpl.findById(Long.parseLong("2"));
		Employe employe = new Employe();
		 employe.setName("Souchu");
		 employe.setSurname("Laura");
		 employe.setDepartement(var);
		 		
	     employeDAOImpl.createEmploye(employe);
	     
	     List<Departement> list = departementDAOImpl.findAll();
	     Assert.assertEquals(employe.getName(), list.get(0).getName());
	}

	@Test
	public void testUpdateEmploye() {
		Employe var = employeDAOImpl.findById(Long.parseLong("1"));
		var.setSalary(Double.parseDouble("10000"));
		employeDAOImpl.updateEmploye(var);
		
		List<Employe> list = employeDAOImpl.findAll();
	    Assert.assertEquals(var.getName(), list.get(0).getName());
	}

	@Test
	public void testDeleteEmploye() {
		Employe var = employeDAOImpl.findById(Long.parseLong("2"));
		employeDAOImpl.deleteEmploye(var);
	}

}

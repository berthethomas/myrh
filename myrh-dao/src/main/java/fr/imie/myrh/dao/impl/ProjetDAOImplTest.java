package fr.imie.myrh.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.imie.myrh.dao.model.Projet;

public class ProjetDAOImplTest {
	
	private ProjetDAOImpl projetDAOImpl = new ProjetDAOImpl();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testProjetDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Projet> list = projetDAOImpl.findAll();
		Assert.assertEquals("test", list.get(0).getDescription());
	}

	@Test
	public void testFindById() {
		Projet var = projetDAOImpl.findById(Long.parseLong("1"));
		Assert.assertEquals("test", var.getDescription());
	}

	@Test
	public void testFindByCode() {
		Projet var = projetDAOImpl.findByCode("test");
		Assert.assertEquals("test", var.getCode());
	}

	@Test
	public void testFindByDateDebut() {
		try {
			List<Projet> var = projetDAOImpl.findByDateDebut(sdf.parse("31/01/2017"));
			Assert.assertEquals("test", var.get(0).getCode());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByDateFin() {
		try {
			List<Projet> var = projetDAOImpl.findByDateFin(sdf.parse("01/02/2017"));
			Assert.assertEquals("test", var.get(0).getCode());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateProjet() {
		Projet projet = new Projet();
		 
		try {
			projet.setDate_debut(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			 projet.setDate_fin(sdf.parse("01/02/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 projet.setCode("test");
		 projet.setDescription("test");
		 
		 projetDAOImpl.createProjet(projet);
	     
	     List<Projet> list = projetDAOImpl.findAll();
	     Assert.assertEquals(projet.getCode(), list.get(0).getCode());
	}

	@Test
	public void testUpdateProjet() {
		Projet var = projetDAOImpl.findById(Long.parseLong("1"));
		var.setCode("cacahuètes");
		projetDAOImpl.updateProjet(var);
		
		List<Projet> list = projetDAOImpl.findAll();
	    Assert.assertEquals(var.getCode(), list.get(0).getCode());
	}

	@Test
	public void testDeleteProjet() {
		Projet var = projetDAOImpl.findById(Long.parseLong("1"));
		projetDAOImpl.deleteProjet(var);
	}

}

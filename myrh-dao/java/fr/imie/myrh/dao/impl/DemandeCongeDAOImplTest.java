package fr.imie.myrh.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.imie.myrh.dao.model.DemandeConge;

public class DemandeCongeDAOImplTest {

	private DemandeCongeDAOImpl demandeCongeDAOImpl = new DemandeCongeDAOImpl();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	SimpleDateFormat sdft = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	@Test
	public void testDemandeCongeDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<DemandeConge> list = demandeCongeDAOImpl.findAll();
		Assert.assertEquals("test", list.get(0).getMotif());
	}

	@Test
	public void testFindById() {
		DemandeConge var = demandeCongeDAOImpl.findById(Long.parseLong("1"));
		Assert.assertEquals("test", var.getMotif());
	}

	@Test
	public void testFindByDateDemande() {
		try {
			List<DemandeConge> var = demandeCongeDAOImpl.findByDateDemande(sdf.parse("31/01/2017"));
			Assert.assertEquals("test", var.get(0).getMotif());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByDateDebut() {
		try {
			List<DemandeConge> var = demandeCongeDAOImpl.findByDateDebut(sdf.parse("31/01/2017"));
			Assert.assertEquals("test", var.get(0).getMotif());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByDateFin() {
		try {
			List<DemandeConge> var = demandeCongeDAOImpl.findByDateFin(sdf.parse("01/02/2017"));
			Assert.assertEquals("test", var.get(0).getMotif());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByMotif() {
		List<DemandeConge> var = demandeCongeDAOImpl.findByMotif("test");
		Assert.assertEquals("test", var.get(0).getMotif());
	}

	@Test
	public void testFindByStatut() {
		List<DemandeConge> var = demandeCongeDAOImpl.findByStatut("test");
		Assert.assertEquals("test", var.get(0).getMotif());
	}

	@Test
	public void testFindByNbJours() {
		List<DemandeConge> var = demandeCongeDAOImpl.findByNbJours(Double.parseDouble("1"));
		Assert.assertEquals("test", var.get(0).getMotif());
	}

	@Test
	public void testCreateDemandeConge() {
		DemandeConge demande = new DemandeConge();
		 try {
			 demande.setDate_demande(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			 demande.setDate_debut(sdf.parse("31/01/2017 09:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 try {
			 demande.setDate_fin(sdf.parse("01/02/2017 09:00:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 demande.setStatut("test");
		 demande.setMotif("test");
		 demande.setNb_jours(Double.parseDouble("1"));
		 
		 demandeCongeDAOImpl.createDemandeConge(demande);
	     
	     List<DemandeConge> list = demandeCongeDAOImpl.findAll();
	     Assert.assertEquals(demande.getDate_demande(), list.get(0).getDate_demande());
	}

	@Test
	public void testUpdateDemandeConge() {
		DemandeConge var = demandeCongeDAOImpl.findById(Long.parseLong("1"));
		var.setMotif("cacahuètes");
		demandeCongeDAOImpl.updateDemandeConge(var);
		
		List<DemandeConge> list = demandeCongeDAOImpl.findAll();
	    Assert.assertEquals(var.getMotif(), list.get(0).getMotif());
	}

	@Test
	public void testDeleteDemandeConge() {
		DemandeConge var = demandeCongeDAOImpl.findById(Long.parseLong("1"));
		demandeCongeDAOImpl.deleteDemandeConge(var);
	}

}

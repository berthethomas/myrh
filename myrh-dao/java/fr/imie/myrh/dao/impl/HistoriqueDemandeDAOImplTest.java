package fr.imie.myrh.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.imie.myrh.dao.model.HistoriqueDemande;

public class HistoriqueDemandeDAOImplTest {
	
    private HistoriqueDemandeDAOImpl historiqueDemandeDAOImpl = new HistoriqueDemandeDAOImpl();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testHistoriqueDemandeDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<HistoriqueDemande> list = historiqueDemandeDAOImpl.findAll();
		Assert.assertEquals("test", list.get(0).getCommentaire());
	}

	@Test
	public void testFindById() {
		HistoriqueDemande var = historiqueDemandeDAOImpl.findById(Long.parseLong("1"));
		Assert.assertEquals("test", var.getCommentaire());
	}

	@Test
	public void testFindByDate() {
		
		try {
			List<HistoriqueDemande> var = historiqueDemandeDAOImpl.findByDate(sdf.parse("31/01/2017"));
			Assert.assertEquals("test", var.get(0).getCommentaire());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testCreateHistoriqueDemande() {
		 HistoriqueDemande historique_demande = new HistoriqueDemande();
		 try {
			historique_demande.setDate(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 historique_demande.setCommentaire("test");
		 System.out.println(historiqueDemandeDAOImpl);
	     historiqueDemandeDAOImpl.createHistoriqueDemande(historique_demande);
	     
	     List<HistoriqueDemande> list = historiqueDemandeDAOImpl.findAll();
	     Assert.assertEquals(historique_demande.getDate(), list.get(0).getDate());
	}

	@Test
	public void testUpdateHistoriqueDemande() {
		HistoriqueDemande var = historiqueDemandeDAOImpl.findById(Long.parseLong("1"));
		var.setCommentaire("cacahuètes");
		historiqueDemandeDAOImpl.updateHistoriqueDemande(var);
		
		List<HistoriqueDemande> list = historiqueDemandeDAOImpl.findAll();
	    Assert.assertEquals(var.getCommentaire(), list.get(0).getCommentaire());
		
	}

	@Test
	public void testDeleteHistoriqueDemande() {
		HistoriqueDemande var = historiqueDemandeDAOImpl.findById(Long.parseLong("1"));
		historiqueDemandeDAOImpl.deleteHistoriqueDemande(var);
		//Assert.assertEquals(var.getCommentaire(), v.getCommentaire());
	}

}

package fr.imie.myrh.dao.impl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.imie.myrh.dao.model.Journee;

public class JourneeDAOImplTest {
	
	private JourneeDAOImpl journeeDAOImpl = new JourneeDAOImpl();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void testJourneeDAOImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<Journee> list = journeeDAOImpl.findAll();
		Assert.assertEquals("test", list.get(0).getCommentaire());
	}

	@Test
	public void testFindById() {
		Journee var = journeeDAOImpl.findById(Long.parseLong("1"));
		Assert.assertEquals("test", var.getCommentaire());
	}

	@Test
	public void testFindByDate() {
		try {
			List<Journee> var = journeeDAOImpl.findByDate(sdf.parse("31/01/2017"));
			Assert.assertEquals("test", var.get(0).getCommentaire());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testFindByDuree() {
		List<Journee> var = journeeDAOImpl.findByDuree(Double.parseDouble("1"));
		Assert.assertEquals("test", var.get(0).getCommentaire());
	}

	@Test
	public void testCreateJournee() {
		Journee journee = new Journee();
		 
		try {
			journee.setDate(sdf.parse("31/01/2017"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		 
		journee.setDuree(Double.parseDouble("1"));
		journee.setCommentaire("test");
		 
		journeeDAOImpl.createJournee(journee);
	     
	     List<Journee> list = journeeDAOImpl.findAll();
	     Assert.assertEquals(journee.getCommentaire(), list.get(0).getCommentaire());
	}

	@Test
	public void testUpdateJournee() {
		Journee var = journeeDAOImpl.findById(Long.parseLong("1"));
		var.setCommentaire("cacahuètes");
		journeeDAOImpl.updateJournee(var);
		
		List<Journee> list = journeeDAOImpl.findAll();
	    Assert.assertEquals(var.getCommentaire(), list.get(0).getCommentaire());
	}

	@Test
	public void testDeleteJournee() {
		Journee var = journeeDAOImpl.findById(Long.parseLong("1"));
		journeeDAOImpl.deleteJournee(var);
	}

}

package com.poly.service.impl;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.poly.Dao.HistoryDao;
import com.poly.Dao.impl.HistoryDaoImpl;
import com.poly.entity.History;

public class HistoryServiceImplTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private HistoryDao dao;

	public HistoryServiceImplTest() {
		dao = new HistoryDaoImpl();
	}

	@Before
	public void initTest() {
		emf = Persistence.createEntityManagerFactory("java4ps19445");
		em = emf.createEntityManager();
	}

	@After
	public void tearDownTest() {
		em.close();
		emf.close();
	}
	@Test
	public void findByUser() {
		String Username = "phucpt";
		List<History> h = dao.findByUser(Username);
		assertTrue(h != null);
	}

	@Test
	public void findByUerAndIsLiked() {
		String Username = "phucpt";
		List<History> h = dao.findByUerAndIsLiked(Username);
		assertTrue(h != null);
		
	}
	
	@Test
	public void findByUserIdAndVideoId() {
		Integer idUser = 2;
		Integer idVideo = 2;
		History h = dao.findByUserIdAndVideoId(idUser, idVideo);
		assertTrue(h != null);
	}
//	@Test
//	public History create() {
//		History history = new History();
//		history.setUser();
//		history.setVideo();
//		history.setViewedDate(new Timestamp(System.currentTimeMillis()));
//		history.setIsLiked(Boolean.FALSE);
//
//	}

}

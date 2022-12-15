package com.poly.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.poly.Dao.VideoDao;
import com.poly.Dao.impl.VideoDaoImpl;
import com.poly.entity.Video;

public class VideoServiceImplTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private VideoDao dao;

	public VideoServiceImplTest() {
		dao = new VideoDaoImpl();
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
	public void testfindById() {
		Video n = new Video();
		Integer id = 1;
		n.setId(id);
		Video u = dao.findById(id);
		assertTrue(u != null);
	}
	@Test
	public void testfindById2() {
		Video n = new Video();
		Integer id = 1;
		n.setId(id);
		Video u = dao.findById(id);
		assertNotNull(u);
	}

	@Test
	public void testfindByHref() {
		String href = "w8r5zDA4awM";
		Video v = dao.findByHref(href);
		assertTrue(v != null);
	}
	@Test
	public void testfindByHref2() {
		String href = "w8r5zDA4awM";
		Video v = dao.findByHref(href);
		assertNotNull(v);
	}

	@Test
	public void testFindAll() {
		List<Video> list = dao.findAll();
		assertTrue(list != null);
	}

	@Test
	public void testCreate1() {
		Video newVideo = new Video();
		String title = "choem10diemdithay";
		String href = "NdUR0AGBafQ";
		String poster = "https://img.youtube.com/vi/NdUR0AGBafQ/maxresdefault.jpg";
		Integer views = 0;
		Integer shares = 0;
		String des = "khongcogi";
		newVideo.setTitle(title);
		newVideo.setHref(href);;
		newVideo.setPoster(poster);;
		newVideo.setViews(views);
		newVideo.setShares(shares);
		newVideo.setDescripton(des);
		newVideo.setIsActive(Boolean.TRUE);
		Video result = dao.create(newVideo);
		assertTrue(result != null);
	}
	@Test
	public void testCreate2() {
		Video newVideo = new Video();
		String title = null;
		String href = null;
		String poster = null;
		Integer views = 0;
		Integer shares = 0;
		String des = null;
		newVideo.setTitle(title);
		newVideo.setHref(href);;
		newVideo.setPoster(poster);;
		newVideo.setViews(views);
		newVideo.setShares(shares);
		newVideo.setDescripton(des);
		newVideo.setIsActive(Boolean.TRUE);
		Video result = dao.create(newVideo);
		assertFalse(result != null);
	}
	@Test
	public void testUpdate() { 
		Video u = dao.findByHref("w8r5zDA4awM");
		u.setDescripton("hihihi");
		u.setTitle("mfsadfm");
		dao.update(u);
		assertEquals(u.getTitle(), "mfsadfm");
	}

	@Test
	public void testDelete() {
		Video OldVideo = dao.findByHref("CHw1b_1LVBA");
		OldVideo.setIsActive(Boolean.FALSE);
		dao.update(OldVideo);
		assertTrue(OldVideo.getIsActive() == Boolean.FALSE);
	}
}

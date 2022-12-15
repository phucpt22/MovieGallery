package com.poly.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.poly.Dao.UserDao;
import com.poly.Dao.impl.UserDaoImpl;
import com.poly.entity.User;

public class UserServiceImplTest {

	private EntityManagerFactory emf;
	private EntityManager em;
	private UserDao dao;

	public UserServiceImplTest() {
		dao = new UserDaoImpl();
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
	public void createTest1() {
		// UserDao dao = new UserDao();
		User newUser = new User();
		String username = "phucpham2311dsds";
		String password = "phuc123xsxs";
		String email = "tttpham23111@gmail.com";
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setIsAdmin(Boolean.FALSE);
		newUser.setIsActive(Boolean.TRUE);
		User result = dao.create(newUser);
		assertTrue(result != null);

	}

	@Test
	public void createTest2() {
		User newUser = new User();
		String username = null;
		String password = null;
		String email = null;
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setEmail(email);
		newUser.setIsAdmin(Boolean.FALSE);
		newUser.setIsActive(Boolean.TRUE);
		// dao.create(newUser);
		User result = dao.create(newUser);
		assertFalse(result != null);
	}

	@Test
	public void testFindById() {
		User n = new User();
		Integer id = 1;
		n.setId(id);
		User u = dao.findById(id);
		assertTrue(u != null);
	}
	@Test
	public void testFindById2() {
		User n = new User();
		Integer id = 1;
		n.setId(id);
		User u = dao.findById(id);
		assertNotNull(u);
	}

	@Test
	public void testFinByEmail1() {
		String email = "phamtp2311@gmail.com";
		User u = dao.finByEmail(email);
		assertTrue(u != null);
	}
	
	@Test
	public void testFinByEmail3() {
		String email = "phamtp2311@gmail.com";
		User u = dao.finByEmail(email);
		assertNotNull(u);
	}

	@Test
	public void testFinByEmail2() {
		String email = null;
		User u = dao.finByEmail(email);
		assertFalse(u != null);
	}

	@Test
	public void testFindByUsername1() {
		User n = dao.findByUsername("phucpt");
		assertTrue(n != null);
	}

	@Test
	public void testFindByUsername2() {
		// String name = "phucpt";
		User n = dao.findByUsername("phucptkskdo");
		assertFalse(n != null);
	}

	@Test
	public void testFindAll() {
		List<User> list = dao.findAll();
		assertTrue(list != null);
	}

	@Test
	public void testUpdate() {
		User u = dao.findByUsername("phucpham2311");
		u.setPassword("234");
		u.setEmail("hihihi@gmail.com");
		dao.update(u);
		assertEquals(u.getPassword(), "234");
	}

	@Test
	public void testDelete() {
		User Olduser = dao.findByUsername("phucpham2311");
		Olduser.setIsActive(Boolean.FALSE);
		dao.update(Olduser);
		assertTrue(Olduser.getIsActive() == Boolean.FALSE);
	}

	@Test
	public void testLogin1() {
		User n = dao.findByUsername("phucpt");
		assertEquals(n.getPassword(),"123");
	}
	@Test
	public void testLogin2() {
		User n = dao.findByUsername("phucpt");
		assertNotEquals(n.getPassword(),"123456");
	}
}

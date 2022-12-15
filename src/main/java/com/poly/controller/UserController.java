package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.service.EmailService;
import com.poly.service.UserService;
import com.poly.service.impl.EmailServiceImpl;
import com.poly.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/forgotpass" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private EmailService emailService = new EmailServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(request, response);
			break;
		case "/register":
			doGetRegister(request, response);
			break;
		case "/logout":
			doGetLogout(session, request, response);
			break;
		case "/forgotpass":
			doGetForgot(request, response);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, request, response);
			break;
		case "/register":
			doPostRegister(session, request, response);
			break;
		case "/forgotpass":
			doPostForgot(request, response);
			break;
		}
	}

	protected void doGetLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
	}

	protected void doGetRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/user/register.jsp").forward(request, response);
	}

	protected void doGetLogout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		session.removeAttribute(SessionAttr.CURRENT_USER);
		response.sendRedirect("index");
	}

	protected void doGetForgot(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/user/forgotpass.jsp").forward(request, response);
	}

	protected void doPostLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.login(username, password);
		if (user != null) {
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			response.sendRedirect("index");
		} else {
			request.setAttribute("error", "Sai mật khẩu hoặc username");
			response.sendRedirect("login");
		}
	}

	protected void doPostRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String cfmpassword = request.getParameter("cfmPass");
		User user = userService.create(username, password, email);
		if (user != null) {
			// emailService.sendMail(getServletContext(), user, "Welcome to
			// SHOW_VIDEO_PTP");
			System.out.println("Tạo thành công");
			emailService.sendMail(getServletContext(), user, "welcome");
			session.setAttribute(SessionAttr.CURRENT_USER, user);
			response.sendRedirect("index");
		} else {
			System.out.println("Tạo thất bại");
			response.sendRedirect("register");
		}

	}

	protected void doPostForgot(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String email = request.getParameter("email");
		User userWithNewPass = userService.resetPassword(email);
		if (userWithNewPass != null) {
			emailService.sendMail(getServletContext(), userWithNewPass, "forgot");
			response.setStatus(204);
		} else {
			response.setStatus(400);
		}
	}
}

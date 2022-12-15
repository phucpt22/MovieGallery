package com.poly.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.RemoteEndpoint.Async;

import com.poly.constant.SessionAttr;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;
//import com.ea.async.Async;

@WebServlet(urlPatterns = "/video")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoService videoService = new VideoServiceImpl();
    private HistoryService historyService = new HistoryServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionParam = request.getParameter("action");
		String href = request.getParameter("id");
		HttpSession session = request.getSession();
		switch(actionParam) {
			case "watching":
				doGetWatch(session,href,request,response);
				break;
			case "like":
				doGetLike(session,href,request,response);
				break;
		}
	}
	protected void doGetWatch(HttpSession session, String href, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Video video = videoService.findByHref(href);
		request.setAttribute("video", video);
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if(currentUser != null) {
			History history = historyService.checkHistory(currentUser, video);
			request.setAttribute("flagLikeBtn", history.getIsLiked());
			//request.setAttribute("flagLikeBtn", Boolean.TRUE);
	}
		
		request.getRequestDispatcher("/views/user/video-detail.jsp").forward(request, response);
	}
	protected void doGetLike(HttpSession session, String href, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		boolean result = historyService.updateLikeOrUnlike(currentUser, href);
		if(result == true) {
			response.setStatus(204); //báo thành công nhưng không trả về data
		}else {
			response.setStatus(400);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

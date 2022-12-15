package com.poly.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.poly.Dao.HistoryDao;
import com.poly.Dao.impl.HistoryDaoImpl;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;


public class HistoryServiceImpl implements HistoryService{
	private HistoryDao dao;
	private VideoService videoService = new VideoServiceImpl();
	
	public HistoryServiceImpl() {
		dao = new HistoryDaoImpl();
	}

	@Override
	public List<History> findByUser(String username) {
		// TODO Auto-generated method stub
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUerAndIsLiked(String username) {
		// TODO Auto-generated method stub
		return dao.findByUerAndIsLiked(username);
	}
	
	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		// TODO Auto-generated method stub
		return dao.findByUserIdAndVideoId(userId, videoId);
	}
	@Override
	public History create(User user, Video video) {
		History history = new History();
		history.setUser(user);
		history.setVideo(video);
		history.setViewedDate(new Timestamp(System.currentTimeMillis()));
		history.setIsLiked(Boolean.FALSE);
		return dao.create(history);
	}

	@Override
	public boolean updateLikeOrUnlike(User user, String videoHref) {
		Video video = videoService.findByHref(videoHref);
		History existHistory = findByUserIdAndVideoId(user.getId(),video.getId());
		if(existHistory.getIsLiked()==Boolean.FALSE) {
			existHistory.setIsLiked(Boolean.TRUE);
			existHistory.setLikedDate(new Timestamp(System.currentTimeMillis()));
		}else {
			existHistory.setIsLiked(Boolean.FALSE);
			existHistory.setLikedDate(null);
		}
		History updatedHistory = dao.update(existHistory);
		return updatedHistory != null ? true : false;
	}
	
	//@Async
	public History checkHistory(User user, Video video) {
		History history =findByUserIdAndVideoId(user.getId(), video.getId());
		//history=
		if( history == null) {
			return create(user,video);
			//return history;
		}else {
			return history;
		}
	}

}

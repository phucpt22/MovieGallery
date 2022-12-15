 package com.poly.Dao.impl;

import java.util.List;

import com.poly.Dao.AbstractDao;
import com.poly.Dao.HistoryDao;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;

public class HistoryDaoImpl extends AbstractDao<History> implements HistoryDao{

	@Override
	public List<History> findByUser(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.video.isActive = 1"
				+" ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public List<History> findByUerAndIsLiked(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.isLiked = 1"
				+ " AND o.video.isActive = 1"+ " ORDER BY o.viewedDate DESC";
		return super.findMany(History.class, sql, username);
	}

	//@Override
	
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM History o WHERE o.user.id = ?0 AND o.video.id = ?1"
				+ " AND o.video.isActive = 1";
		return super.findOne(History.class, sql, userId, videoId);
	}



//	@Override
//	public History create(History entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public History update(History entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

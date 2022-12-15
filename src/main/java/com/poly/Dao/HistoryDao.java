package com.poly.Dao;

import java.util.List;

import com.poly.entity.History;


public interface HistoryDao {
	List<History> findByUser(String username);
	List<History> findByUerAndIsLiked(String username);
	History findByUserIdAndVideoId(Integer userId, Integer videoId);
	History create(History entity);
	History update(History entity);
}

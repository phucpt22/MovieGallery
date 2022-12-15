package com.poly.service.impl;

import java.util.List;

import com.poly.Dao.StatsDao;
import com.poly.Dao.impl.StatsDaoImpl;
import com.poly.dto.VideoLikedInfo;
import com.poly.service.StatsService;

public class StatsServiceImpl implements StatsService{
	private StatsDao statsDao;
	public StatsServiceImpl() {
		statsDao = new StatsDaoImpl();
	}
	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		// TODO Auto-generated method stub
		return statsDao.findVideoLikedInfo();
	}
	
}

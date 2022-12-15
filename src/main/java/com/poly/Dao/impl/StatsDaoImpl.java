package com.poly.Dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.poly.Dao.AbstractDao;
import com.poly.Dao.StatsDao;
import com.poly.dto.VideoLikedInfo;
import com.poly.entity.User;

public class StatsDaoImpl extends AbstractDao<Object[]> implements StatsDao {

	@Override

	public List<VideoLikedInfo> findVideoLikedInfo() {
		// TODO Auto-generated method stub
		String sql = "select v.id,v.title, v.href, sum(cast(h.isLiked as int)) as totalLike"
				+ " from video v left join History h on v.id = h.videoId" 
				+ " where v.isActive = 1"
				+ " group by v.id, v.title, v.href" 
				+ "  order by v.id, v.title, v.href desc";
		List<Object[]> objects = super.findManyByNativeQuery(sql);
		List<VideoLikedInfo> result = new ArrayList<>();
		objects.forEach(object -> {
			VideoLikedInfo likedInfo = setDataVideoLikedInfo(object);
			result.add(likedInfo);
		});
		return result;
	}


	private VideoLikedInfo setDataVideoLikedInfo(Object[] object) {
		VideoLikedInfo likeInfo = new VideoLikedInfo();
		likeInfo.setVideoId((Integer) object[0]);
		likeInfo.setTitle((String) object[1]);
		likeInfo.setHref((String) object[2]);
		likeInfo.setTotalLike(object[3] == null ? 0 : (Integer) object[3]);
		return likeInfo;
	}

}

package com.poly.dto;


public class VideoLikedInfo {
	private Integer videoId;
	private Object title;
	private String href;
	private Integer totalLike;
	
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title +"";
	}
	public void setTitle(Object title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public Integer getTotalLike() {
		return totalLike;
	}
	public void setTotalLike(Integer totalLike) {
		this.totalLike = totalLike;
	}
	public VideoLikedInfo(Integer videoId,String tilte,String href,Integer totalLike) {
		//super();
		this.videoId = videoId;
		this.title = tilte;
		this.href = href;
		this.totalLike = totalLike;
		
	}
	public VideoLikedInfo() {
		
	}
}

package com.test.bean;

import java.util.Date;

public class Clikcks {
	private Integer clickId;
    private Integer userId;
    private String userName;
    private Integer songId;
    private String songName;
    private Date clickDate;
	public Integer getClickId() {
		return clickId;
	}
	public void setClickId(Integer clickId) {
		this.clickId = clickId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSongId() {
		return songId;
	}
	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public Date getClickDate() {
		return clickDate;
	}
	public void setClickDate(Date clickDate) {
		this.clickDate = clickDate;
	}
	@Override
	public String toString() {
		return "bean [clickId=" + clickId + ", userId=" + userId + ", userName=" + userName + ", songId=" + songId
				+ ", songName=" + songName + ", clickDate=" + clickDate + "]";
	}
    
    
}

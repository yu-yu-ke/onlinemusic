package com.test.bean;

import java.util.Date;

public class DownLoad {

	private Integer downLoadId;
    private Integer userId;
    private String userName;
    private Integer songId;
    private String songName;
    private Date downLoadDate;
	public Integer getDownLoadId() {
		return downLoadId;
	}
	public void setDownLoadId(Integer downLoadId) {
		this.downLoadId = downLoadId;
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
	public Date getDownLoadDate() {
		return downLoadDate;
	}
	public void setDownLoadDate(Date downLoadDate) {
		this.downLoadDate = downLoadDate;
	}
	@Override
	public String toString() {
		return "DownLoad [downLoadId=" + downLoadId + ", userId=" + userId + ", userName=" + userName + ", songId="
				+ songId + ", songName=" + songName + ", downLoadDate=" + downLoadDate + "]";
	}
    
    
}

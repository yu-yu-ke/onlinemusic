package com.test.bean;

import java.util.Date;

public class Song {

	private Integer songId;
    private String songName;
    private String songSinger;
    private Integer typeId;
    private String typeName;
    private String songSize;
    private String songUrl;
    private String songFormat;
    private Integer songClicks;
    private Integer songDownload;
    private Date songUptime;
    private Integer vipId;
    private String vip;
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
	public String getSongSinger() {
		return songSinger;
	}
	public void setSongSinger(String songSinger) {
		this.songSinger = songSinger;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getSongSize() {
		return songSize;
	}
	public void setSongSize(String songSize) {
		this.songSize = songSize;
	}
	public String getSongUrl() {
		return songUrl;
	}
	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}
	public String getSongFormat() {
		return songFormat;
	}
	public void setSongFormat(String songFormat) {
		this.songFormat = songFormat;
	}
	public Integer getSongClicks() {
		return songClicks;
	}
	public void setSongClicks(Integer songClicks) {
		this.songClicks = songClicks;
	}
	public Integer getSongDownload() {
		return songDownload;
	}
	public void setSongDownload(Integer songDownload) {
		this.songDownload = songDownload;
	}
	public Date getSongUptime() {
		return songUptime;
	}
	public void setSongUptime(Date songUptime) {
		this.songUptime = songUptime;
	}
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", songSinger=" + songSinger + ", typeId=" + typeId
				+ ", typeName=" + typeName + ", songSize=" + songSize + ", songUrl=" + songUrl + ", songFormat="
				+ songFormat + ", songClicks=" + songClicks + ", songDownload=" + songDownload + ", songUptime="
				+ songUptime + ", vipId=" + vipId + ", vip=" + vip + "]";
	}
    
    
}

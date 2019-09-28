package com.test.bean;

public class Vip {

	private Integer vipId;
    private String vip;
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
		return "Vip [vipId=" + vipId + ", vip=" + vip + "]";
	}
    
    
}

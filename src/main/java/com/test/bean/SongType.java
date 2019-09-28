package com.test.bean;

public class SongType {

	private Integer typeId;
    private String typeName;
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
	@Override
	public String toString() {
		return "SongType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
    
    
}

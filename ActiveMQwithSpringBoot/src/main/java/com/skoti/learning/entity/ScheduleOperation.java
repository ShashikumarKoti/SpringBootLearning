package com.skoti.learning.entity;

import java.io.Serializable;

public class ScheduleOperation implements Serializable {

	private static final long serialVersionUID = 1L;
	
 	private int scheduledId;
	private String operType;
	private String lastUpdatedName;
	
	public int getScheduledId() {
		return scheduledId;
	}
	public void setScheduledId(int scheduledId) {
		this.scheduledId = scheduledId;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public String getLastUpdatedName() {
		return lastUpdatedName;
	}
	public void setLastUpdatedName(String lastUpdatedName) {
		this.lastUpdatedName = lastUpdatedName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

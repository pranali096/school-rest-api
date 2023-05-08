package com.school.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="schoolinfo_tb")
public class SchoolInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long scId;

	@Column(name = "name")
	private String scName;

	@Column(name = "founder")
	private String scFounder;

	@Column(name = "founded_date")
	private String scFoundedDate;
	
	@Column(name = "address")
	private String scAddress;
	
	@Column(name = "city")
	private String scCity;
	
	@Column(name = "state")
	private String scState;
	
	@Column(name = "Phno")
	private String PhNo;

	public SchoolInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getScId() {
		return scId;
	}

	public void setScId(Long scId) {
		this.scId = scId;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public String getScFounder() {
		return scFounder;
	}

	public void setScFounder(String scFounder) {
		this.scFounder = scFounder;
	}

	public String getScFoundedDate() {
		return scFoundedDate;
	}

	public void setScFoundedDate(String scFoundedDate) {
		this.scFoundedDate = scFoundedDate;
	}

	public String getScAddress() {
		return scAddress;
	}

	public void setScAddress(String scAddress) {
		this.scAddress = scAddress;
	}

	public String getScCity() {
		return scCity;
	}

	public void setScCity(String scCity) {
		this.scCity = scCity;
	}

	public String getScState() {
		return scState;
	}

	public void setScState(String scState) {
		this.scState = scState;
	}

	public String getPhNo() {
		return PhNo;
	}

	public void setPhNo(String phNo) {
		PhNo = phNo;
	}

	@Override
	public String toString() {
		return "SchoolInfo [scId=" + scId + ", scName=" + scName + ", scFounder=" + scFounder + ", scFoundedDate="
				+ scFoundedDate + ", scAddress=" + scAddress + ", scCity=" + scCity + ", scState=" + scState + ", PhNo="
				+ PhNo + "]";
	}	
	
	
	
}

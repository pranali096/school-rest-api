package com.school.divisions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.school.classes.Classes;

@Entity
@Table(name="divisions_tb")
public class Divisions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long did;
	
	@Column(name = "divisions")
	private String Division;
	


	public Divisions(Long did, String division) {
		super();
		this.did = did;
		Division = division;
	}

	public Divisions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return did;
	}

	public void setId(Long id) {
		this.did = id;
	}

	public String getDivision() {
		return Division;
	}

	public void setDivision(String division) {
		Division = division;
	}

	@Override
	public String toString() {
		return "Divisions [id=" + did + ", Division=" + Division + "]";
	}
	
	
}

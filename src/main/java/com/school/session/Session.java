package com.school.session;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Session_tb")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@Column(name="year")
	private String year;
	
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startdate;
	
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date enddate;
	
//	@OneToMany(mappedBy = "session")
//	Set<Students> students;
 




}

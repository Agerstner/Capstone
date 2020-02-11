package com.claim_academy.capstone.model;

import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.*;

@Entity
@Table(name = "maintenanceReports")
public class MaintenanceReports {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	@Column(name = "priority")
	private String priority;
	@Column(name = "type")
	private String type;
	@Column(name = "user")
	private String user;
	@Column(name = "location")
	private String location;
	@Column(name = "details")
	private String details;
	@Column(name = "datetime")
	private LocalDateTime dateTime = LocalDateTime.now();
	@Transient
	MultipartFile file;
	@Column(name = "image")
	private String image;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String toString() {
		
		
		return  "Reports [id="+id+", priority="+ priority +", location="+location + ", type="+type+", dateTime="+dateTime+", descript="+ details +", file="+ file +", image="+image+"]";

	}
	
}

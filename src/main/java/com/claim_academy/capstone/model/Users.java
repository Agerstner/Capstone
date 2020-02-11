package com.claim_academy.capstone.model;

import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="role")
	private String role;
	@Transient
	MultipartFile file;
	@Column(name="image")
	private String image;
	@Column(name="code")
	private String code;
	@Column(name="address")
	private String address;
	@Column(name="password")
	private String password;
	@Transient
	private String repeatepass;
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
		
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRepeatepass() {
		return repeatepass;
	}

	public void setRepeatepass(String repeatepass) {
		this.repeatepass = repeatepass;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	
	}
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
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
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", lname=" + lastname + ", fname=" + firstname + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", repeatepass=" + repeatepass + ", role=" + role + ", file=" + file
				+ ", image=" + image + "]";
	}
	
	
}

package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    
	String username;
	String mail;
	String password;
	String gender;
	String role;
	String Address;
	
	boolean isPremium;
	
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Music(int id, String username, String mail, String password, String gender, String role, String address,
			boolean isPremium) {
		super();
		this.id = id;
		this.username = username;
		this.mail = mail;
		this.password = password;
		this.gender = gender;
		this.role = role;
		Address = address;
		this.isPremium = isPremium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", username=" + username + ", mail=" + mail + ", password=" + password + ", gender="
				+ gender + ", role=" + role + ", Address=" + Address + ", isPremium=" + isPremium + "]";
	}

	
	
	
	
}

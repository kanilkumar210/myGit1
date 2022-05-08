package com.pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@ManyToOne
	@JoinColumn(name = "corporate_id")
	private Corporate corporate;
	@Id
	private long login_id;
	private String roles;
	private String username;
	private String department;
	private String address;
	private long mobileNumber;
	private String password;
	private String status;
	private boolean isActive;

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User() {
		super();
	}

	public Corporate getCorporate() {
		return corporate;
	}

	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
	}

	public User(Corporate corporate, long login_id, String roles, String username, String department, String address,
			long mobileNumber, String password, String status, boolean isActive) {
		super();
		this.corporate = corporate;
		this.login_id = login_id;
		this.roles = roles;
		this.username = username;
		this.department = department;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.status = status;
		this.isActive = isActive;
	}

	public long getLogin_id() {
		return login_id;
	}

	public void setLogin_id(long login_id) {
		this.login_id = login_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.login_id
				+ " " + this.username + " " + this.password + "" + this.address + " " + this.status + " "
				+ this.department;

	}
}

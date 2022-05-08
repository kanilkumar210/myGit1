package com.pack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "corporate_setup")
public class Corporate {
	private String CorporateName, Address, PhoneNumber;
	private boolean isActive;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long Corporate_id;

	public Corporate() {
		super();
	}
	

	public Corporate(long corporate_id) {
		super();
		Corporate_id = corporate_id;
	}


	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Corporate(String corporateName, String address, String phoneNumber, boolean isActive, long corporate_id) {
		super();
		CorporateName = corporateName;
		Address = address;
		PhoneNumber = phoneNumber;
		this.isActive = isActive;
		Corporate_id = corporate_id;
	}

	public String getCorporateName() {
		return CorporateName;
	}

	public void setCorporateName(String corporateName) {
		this.CorporateName = corporateName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.PhoneNumber = phoneNumber;
	}

	public long getCorporate_id() {
		return Corporate_id;
	}

	public void setCorporate_id(long corporate_id) {
		Corporate_id = corporate_id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.CorporateName + " " + this.Address + " " + this.PhoneNumber;
	}
}

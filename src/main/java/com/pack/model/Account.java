package com.pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_setup")
public class Account {
	@Id
	private long accountNumber;
	@ManyToOne
	@JoinColumn(name = "corporate_id")
	private Corporate corporate;
	private String accountName;
	private String branch;
	private String currency;
	private double availableBalance;
	private boolean isActive;

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Corporate getCorporate() {
		return corporate;
	}

	public void setCorporate(Corporate corporate) {
		this.corporate = corporate;
	}

	public Account(long accountNumber, Corporate corporate, String accountName, String branch, String currency,
			double availableBalance, boolean isActive) {
		super();
		this.accountNumber = accountNumber;
		this.corporate = corporate;
		this.accountName = accountName;
		this.branch = branch;
		this.currency = currency;
		this.availableBalance = availableBalance;
		this.isActive = isActive;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.corporate.getCorporate_id() + " " + this.accountName + " " + this.accountNumber + " "
				+ this.availableBalance;
	}

	public Account() {
		super();
	}

}

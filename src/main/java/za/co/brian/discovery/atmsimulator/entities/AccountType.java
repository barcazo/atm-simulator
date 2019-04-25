package za.co.brian.discovery.atmsimulator.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class AccountType {
	@Id
	@GeneratedValue
	private String accountTypeCode;
	private String description;
	private String transactional;
	
	public String getAccountTypeCode() {
		return accountTypeCode;
	}
	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransactional() {
		return transactional;
	}
	public void setTransactional(String transactional) {
		this.transactional = transactional;
	}
	@Override
	public String toString() {
		return "AccountType [accountTypeCode=" + accountTypeCode + ", description=" + description + ", transactional="
				+ transactional + "]";
	}

}

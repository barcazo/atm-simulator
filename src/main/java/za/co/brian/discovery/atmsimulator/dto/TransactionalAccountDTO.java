package za.co.brian.discovery.atmsimulator.dto;

import java.math.BigDecimal;

public class TransactionalAccountDTO {
	private String clientAccountNumber;
	private String accountType;
	private BigDecimal accountBalance;
	//Below 3 fields used for reporting
	private Integer clientId;
	private String surName;
	private String description;
	
	//Used for withdrawl
	private String transactional;
	
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
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
		return "TransactionalAccountDTO [clientAccountNumber=" + clientAccountNumber + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + ", clientId=" + clientId + ", surName=" + surName
				+ ", description=" + description + ", transactional=" + transactional + "]";
	}
}

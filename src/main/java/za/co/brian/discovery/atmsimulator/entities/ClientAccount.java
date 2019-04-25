package za.co.brian.discovery.atmsimulator.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClientAccount {
	
	@Id
	@GeneratedValue
	private String clientAccountNumber;
	private Integer clientId;
	private String accountTypeCode;
	private String currencyCode;
	private BigDecimal displayBalance;
	
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getAccountTypeCode() {
		return accountTypeCode;
	}
	public void setAccountTypeCode(String accountTypeCode) {
		this.accountTypeCode = accountTypeCode;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public BigDecimal getDisplayBalance() {
		return displayBalance;
	}
	public void setDisplayBalance(BigDecimal displayBalance) {
		this.displayBalance = displayBalance;
	}
}

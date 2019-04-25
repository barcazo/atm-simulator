package za.co.brian.discovery.atmsimulator.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CreditCardLimit {
	@Id
	@GeneratedValue
	private String clientAccountNumber;
	private BigDecimal accountLimit;
	
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
	public BigDecimal getAccountLimit() {
		return accountLimit;
	}
	public void setAccountLimit(BigDecimal accountLimit) {
		this.accountLimit = accountLimit;
	}
	@Override
	public String toString() {
		return "CreditCardLimit [clientAccountNumber=" + clientAccountNumber + ", accountLimit=" + accountLimit + "]";
	}
}

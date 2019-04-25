package za.co.brian.discovery.atmsimulator.dto;

import java.math.BigDecimal;

public class CurrencyAccountDTO {
	private String accountNumber;
	private String currency;
	private BigDecimal currencyBalance;
	private BigDecimal conversionRate;
	private BigDecimal zarAmount;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getCurrencyBalance() {
		return currencyBalance;
	}
	public void setCurrencyBalance(BigDecimal currencyBalance) {
		this.currencyBalance = currencyBalance;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public BigDecimal getZarAmount() {
		return zarAmount;
	}
	public void setZarAmount(BigDecimal zarAmount) {
		this.zarAmount = zarAmount;
	}
	
	@Override
	public String toString() {
		return "CurrencyAccount [accountNumber=" + accountNumber + ", currency=" + currency + ", currencyBalance="
				+ currencyBalance + ", conversionRate=" + conversionRate + ", zarAmount=" + zarAmount + "]";
	}
}

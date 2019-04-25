package za.co.brian.discovery.atmsimulator.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyConversionRate {
	@Id
	@GeneratedValue
	private String currencyCode;
	private String conversionIndicator;
	private BigDecimal rate;
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getConversionIndicator() {
		return conversionIndicator;
	}
	public void setConversionIndicator(String conversionIndicator) {
		this.conversionIndicator = conversionIndicator;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "CurrencyConversionRate [currencyCode=" + currencyCode + ", conversionIndicator=" + conversionIndicator
				+ ", rate=" + rate + "]";
	}
}

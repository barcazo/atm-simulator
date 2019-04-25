package za.co.brian.discovery.atmsimulator.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Denomination {
	@Id
	@GeneratedValue
	private Integer denominationId;
	private Integer value;
	private String denominationTypeCode;
	
	public Integer getDenominationId() {
		return denominationId;
	}
	public void setDenominationId(Integer denominationId) {
		this.denominationId = denominationId;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getDenominationTypeCode() {
		return denominationTypeCode;
	}
	public void setDenominationTypeCode(String denominationTypeCode) {
		this.denominationTypeCode = denominationTypeCode;
	}
	@Override
	public String toString() {
		return "Denomination [denominationId=" + denominationId + ", value=" + value + ", denominationTypeCode="
				+ denominationTypeCode + "]";
	}
}

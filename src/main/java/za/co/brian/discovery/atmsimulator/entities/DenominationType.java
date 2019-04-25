package za.co.brian.discovery.atmsimulator.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DenominationType {
	@Id
	@GeneratedValue
	private String denominationTypeCode;
	private String description;
	
	public String getDenominationTypeCode() {
		return denominationTypeCode;
	}
	public void setDenominationTypeCode(String denominationTypeCode) {
		this.denominationTypeCode = denominationTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "DenominationType [denominationTypeCode=" + denominationTypeCode + ", description=" + description + "]";
	}
}

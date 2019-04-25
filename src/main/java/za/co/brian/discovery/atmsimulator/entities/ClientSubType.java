package za.co.brian.discovery.atmsimulator.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClientSubType {
	@Id
	@GeneratedValue
	private String ClinetSubTypeCode;
	private String ClinetTypeCode;
	private String description;
	public String getClinetSubTypeCode() {
		return ClinetSubTypeCode;
	}
	public void setClinetSubTypeCode(String clinetSubTypeCode) {
		ClinetSubTypeCode = clinetSubTypeCode;
	}
	public String getClinetTypeCode() {
		return ClinetTypeCode;
	}
	public void setClinetTypeCode(String clinetTypeCode) {
		ClinetTypeCode = clinetTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ClientSubType [ClinetSubTypeCode=" + ClinetSubTypeCode + ", ClinetTypeCode=" + ClinetTypeCode
				+ ", description=" + description + "]";
	}
}

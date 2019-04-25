package za.co.brian.discovery.atmsimulator.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ClientType {
	@Id
	@GeneratedValue
	private String clientTypeCode;
	private String description;
	
	public String getClientTypeCode() {
		return clientTypeCode;
	}
	public void setClientTypeCode(String clientTypeCode) {
		this.clientTypeCode = clientTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ClientType [clientTypeCode=" + clientTypeCode + ", description=" + description + "]";
	}
}

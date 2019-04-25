package za.co.brian.discovery.atmsimulator.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Integer clientId;
	private String title;
	private String name;
	private String surName;
	private LocalDate dob;
	private String ClientSubTypeCode;
	
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getClientSubTypeCode() {
		return ClientSubTypeCode;
	}
	public void setClientSubTypeCode(String clientSubTypeCode) {
		ClientSubTypeCode = clientSubTypeCode;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", title=" + title + ", name=" + name + ", surName=" + surName
				+ ", dob=" + dob + ", ClientSubTypeCode=" + ClientSubTypeCode + "]";
	}
}

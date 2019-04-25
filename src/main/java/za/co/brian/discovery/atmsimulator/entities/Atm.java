package za.co.brian.discovery.atmsimulator.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Atm {
	@Id
	@GeneratedValue
	private Integer atmId;
	private String name;
	private String location;
	
	public Integer getAtmId() {
		return atmId;
	}
	public void setAtmId(Integer atmId) {
		this.atmId = atmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Atm [atmId=" + atmId + ", name=" + name + ", location=" + location + "]";
	}
}

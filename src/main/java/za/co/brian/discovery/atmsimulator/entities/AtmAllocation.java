package za.co.brian.discovery.atmsimulator.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AtmAllocation {
	
	@Id
	@GeneratedValue
	private Integer atmAllocationId;
	private Integer atmId;
	private Integer denominationId;
	private Integer count;
	
	public Integer getAtmAllocationId() {
		return atmAllocationId;
	}
	public void setAtmAllocationId(Integer atmAllocationId) {
		this.atmAllocationId = atmAllocationId;
	}
	public Integer getAtmId() {
		return atmId;
	}
	public void setAtmId(Integer atmId) {
		this.atmId = atmId;
	}
	public Integer getDenominationId() {
		return denominationId;
	}
	public void setDenominationId(Integer denominationId) {
		this.denominationId = denominationId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "AtmAllocation [atmAllocationId=" + atmAllocationId + ", atmId=" + atmId + ", denominationId="
				+ denominationId + ", count=" + count + "]";
	}
}

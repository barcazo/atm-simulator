package za.co.brian.discovery.atmsimulator.dto;

public class DenominationDTO {
	private Integer value;
	private Integer count;
	private Integer totalAmount;
	
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "DenominationDTO [value=" + value + ", count=" + count + ", totalAmount=" + totalAmount + "]";
	}
	
}

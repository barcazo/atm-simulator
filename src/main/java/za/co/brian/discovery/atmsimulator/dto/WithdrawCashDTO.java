package za.co.brian.discovery.atmsimulator.dto;

import java.math.BigDecimal;

public class WithdrawCashDTO {
	private String accountType;
	private String accountNum;
	private BigDecimal reqAmount;
	private Integer atmId;
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public BigDecimal getReqAmount() {
		return reqAmount;
	}
	public void setReqAmount(BigDecimal reqAmount) {
		this.reqAmount = reqAmount;
	}
	public Integer getAtmId() {
		return atmId;
	}
	public void setAtmId(Integer atmId) {
		this.atmId = atmId;
	}
	@Override
	public String toString() {
		return "WithdrawCashDTO [accountType=" + accountType + ", accountNum=" + accountNum + ", reqAmount=" + reqAmount
				+ ", atmId=" + atmId + "]";
	}
}

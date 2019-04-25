package za.co.brian.discovery.atmsimulator.dto;

import java.math.BigDecimal;

public class ClientFinancialAggDTO {
	private String clientName;
	private Integer clientId;
	private BigDecimal aggLoanBalance;
	private BigDecimal aggTranscBalance;
	private BigDecimal netPosition;
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public BigDecimal getAggLoanBalance() {
		return aggLoanBalance;
	}
	public void setAggLoanBalance(BigDecimal aggLoanBalance) {
		this.aggLoanBalance = aggLoanBalance;
	}
	public BigDecimal getAggTranscBalance() {
		return aggTranscBalance;
	}
	public void setAggTranscBalance(BigDecimal aggTranscBalance) {
		this.aggTranscBalance = aggTranscBalance;
	}
	public BigDecimal getNetPosition() {
		return netPosition;
	}
	public void setNetPosition(BigDecimal netPosition) {
		this.netPosition = netPosition;
	}
	@Override
	public String toString() {
		return "ClientFinancialAggDTO [clientName=" + clientName + ", clientId=" + clientId + ", aggLoanBalance="
				+ aggLoanBalance + ", aggTranscBalance=" + aggTranscBalance + ", netPosition=" + netPosition + "]";
	}
}

package za.co.brian.discovery.atmsimulator.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import za.co.brian.discovery.atmsimulator.dto.ClientFinancialAggDTO;
import za.co.brian.discovery.atmsimulator.dto.CurrencyAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.TransactionalAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.WithdrawCashDTO;

public interface ClientAccountService {
	public List<TransactionalAccountDTO> getAllTransactionalAccs();
	public List<CurrencyAccountDTO> getAllCurrencyAccs();
	public List<TransactionalAccountDTO> getTransAccPerClient();
	public List<ClientFinancialAggDTO> getAggFinancialClientInfo();
	public TransactionalAccountDTO getTransactionalAccDetails(String accountNum,String accountType);
	public ModelAndView withdrawalProcessing(WithdrawCashDTO withdrawCashDTO);
	public int updateTransAccBalance(String accountNum, Integer userReqAmount);
}

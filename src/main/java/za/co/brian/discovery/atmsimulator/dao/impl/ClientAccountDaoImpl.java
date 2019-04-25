package za.co.brian.discovery.atmsimulator.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import za.co.brian.discovery.atmsimulator.dao.ClientAccountDao;
import za.co.brian.discovery.atmsimulator.dto.ClientFinancialAggDTO;
import za.co.brian.discovery.atmsimulator.dto.CurrencyAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.TransactionalAccountDTO;

@Repository
public class ClientAccountDaoImpl implements ClientAccountDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<TransactionalAccountDTO> getAllTransactionalAccs() {
		Query query = entityManager.createNativeQuery(GET_ALL_TRANSACTIONAL_ACCOUNTS);
		List<Object[]> transactionalDTODbList = query.getResultList();
		List<TransactionalAccountDTO> transactionalDTOList = new ArrayList<>();
		for (Object[] obj : transactionalDTODbList) {
		   /* System.out.println("TransactionDetails "
		            + obj[0]
		            + " "
		            + obj[1]
		            + " "
		            + obj[2]);*/
		    TransactionalAccountDTO transactionalAccountDTO = new TransactionalAccountDTO();
		    transactionalAccountDTO.setClientAccountNumber((String) obj[0]);
		    transactionalAccountDTO.setAccountType((String) obj[1]);
		    transactionalAccountDTO.setAccountBalance((BigDecimal) obj[2]);
		    transactionalDTOList.add(transactionalAccountDTO);
		}
		System.out.println("transactionalDTOList size: "+transactionalDTOList.size());
		return transactionalDTOList;
	}

	@Override
	public List<CurrencyAccountDTO> getAllCurrencyAccs() {
		Query query = entityManager.createNativeQuery(GET_ALL_CURRENCY_ACCOUNTS);
		List<Object[]> currencyDTODbList = query.getResultList();
		List<CurrencyAccountDTO> currencyDTOList = new ArrayList<>();
		for (Object[] obj : currencyDTODbList) {
		   /* System.out.println("TransactionDetails "
		            + obj[0]
		            + " "
		            + obj[1]
		            + " "
		            + obj[2]);*/
		    
		    CurrencyAccountDTO currencyAccountDTO = new CurrencyAccountDTO();
		    currencyAccountDTO.setAccountNumber((String) obj[0]);
		    currencyAccountDTO.setCurrency((String) obj[1]);
		    currencyAccountDTO.setCurrencyBalance((BigDecimal) obj[2]);
		    currencyAccountDTO.setConversionRate((BigDecimal) obj[3]);
		    currencyAccountDTO.setZarAmount((BigDecimal) obj[4]);
		    currencyDTOList.add(currencyAccountDTO);
		}
		System.out.println("currencyDTOList size: "+currencyDTOList.size());
		return currencyDTOList;
	}

	@Override
	public List<TransactionalAccountDTO> getTransAccsPerClient() {
		Query query = entityManager.createNativeQuery(GET_ALL_TRANSACTIONAL_ACC_PER_CLIENT);
		List<Object[]> transactionalDTODbList = query.getResultList();
		List<TransactionalAccountDTO> transactionalDTOList = new ArrayList<>();
		for (Object[] obj : transactionalDTODbList) {
		    TransactionalAccountDTO transactionalAccountDTO = new TransactionalAccountDTO();
		    transactionalAccountDTO.setClientId((Integer) obj[0]);
		    transactionalAccountDTO.setSurName((String) obj[1]);
		    transactionalAccountDTO.setClientAccountNumber((String) obj[2]);
		    transactionalAccountDTO.setDescription((String) obj[3]);
		    transactionalAccountDTO.setAccountBalance((BigDecimal) obj[4]);
		    transactionalDTOList.add(transactionalAccountDTO);
		}
		System.out.println("transactionalDTOList size: "+transactionalDTOList.size());
		System.out.println("transactionalDTOList from getTransAccsPerClient: "+transactionalDTOList.toString());
		return transactionalDTOList;
	}

	@Override
	public List<ClientFinancialAggDTO> getAggFinancialClientInfo() {
		Query query = entityManager.createNativeQuery(GET_AGG_FINANCIAL_POS_PER_CLIENT);
		List<Object[]> clientFinancialAggDTODbList = query.getResultList();
		List<ClientFinancialAggDTO> clientFinancialAggDTOList = new ArrayList<>();
		for (Object[] obj : clientFinancialAggDTODbList) {
		   
		    ClientFinancialAggDTO clientFinancialAggDTO = new ClientFinancialAggDTO();
		    clientFinancialAggDTO.setClientName((String) obj[0]);
		    clientFinancialAggDTO.setClientId((Integer) obj[1]);
		    clientFinancialAggDTO.setAggLoanBalance((BigDecimal) obj[2]);
		    clientFinancialAggDTO.setAggTranscBalance((BigDecimal) obj[3]);
		    clientFinancialAggDTO.setNetPosition((BigDecimal) obj[4]);
		    clientFinancialAggDTOList.add(clientFinancialAggDTO);
		}
		System.out.println("clientFinancialAggDTOList size: "+clientFinancialAggDTOList.size());
		System.out.println("clientFinancialAggDTOList from getAggFinancialClientInfo: "+clientFinancialAggDTOList.toString());
		return clientFinancialAggDTOList;
	}


	@Override
	public TransactionalAccountDTO getTransactionalAccDetails(String accountNum, String accountType) {
		Query query = entityManager.createNativeQuery(GET_TRANSACTIONAL_AC_DETAILS);
		query.setParameter("accNumber", accountNum);
		query.setParameter("accountType", accountType);
		List<Object[]> transactionalDTODbList = query.getResultList();
		System.out.println("transactionalDTODbList size :"+transactionalDTODbList.size());
		
		TransactionalAccountDTO transactionalAccountDTO = new TransactionalAccountDTO();
		for (Object[] obj : transactionalDTODbList) {
		    transactionalAccountDTO.setClientAccountNumber((String) obj[0]);
		    transactionalAccountDTO.setAccountType((String) obj[1]);
		    transactionalAccountDTO.setAccountBalance((BigDecimal) obj[2]);
		    transactionalAccountDTO.setTransactional((String) obj[3]); 
			}
		return transactionalAccountDTO;
	}

	@Override
	@Transactional
	@Modifying
	public int updateTransAccBalance(String accountNum, Integer userReqAmount) {
		Query query = entityManager.createNativeQuery(UPDATE_TRANSACTIONAL_ACCOUNT);
		query.setParameter("userReqAmt", userReqAmount);
		query.setParameter("accNumber", accountNum);
		int updateTransResult = query.executeUpdate();
		System.out.println("updateTransResult :"+updateTransResult);
		return updateTransResult;
	}
	
}

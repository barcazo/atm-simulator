package za.co.brian.discovery.atmsimulator.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import za.co.brian.discovery.atmsimulator.dao.ClientAccountDao;
import za.co.brian.discovery.atmsimulator.dto.ClientFinancialAggDTO;
import za.co.brian.discovery.atmsimulator.dto.CurrencyAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.DenominationDTO;
import za.co.brian.discovery.atmsimulator.dto.TransactionalAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.WithdrawCashDTO;
import za.co.brian.discovery.atmsimulator.service.ATMDenominationService;
import za.co.brian.discovery.atmsimulator.service.ClientAccountService;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

	@Autowired
    ClientAccountDao clientAccountDao;
	
	@Autowired
	ATMDenominationService atmDenominationService; 
	
	@Override
	public List<TransactionalAccountDTO> getAllTransactionalAccs() {
		return clientAccountDao.getAllTransactionalAccs();
	}

	@Override
	public List<CurrencyAccountDTO> getAllCurrencyAccs() {
		return clientAccountDao.getAllCurrencyAccs();
	}

	@Override
	public List<TransactionalAccountDTO> getTransAccPerClient() {
		return clientAccountDao.getTransAccsPerClient();
	}

	@Override
	public List<ClientFinancialAggDTO> getAggFinancialClientInfo() {
		return clientAccountDao.getAggFinancialClientInfo();
	}

	
	@Override
	public TransactionalAccountDTO getTransactionalAccDetails(String accountNum, String accountType) {
		return clientAccountDao.getTransactionalAccDetails(accountNum,accountType);
	}
	
	public ModelAndView withdrawalProcessing(WithdrawCashDTO withdrawCashDTO) {
		ModelAndView modelAndView = new ModelAndView();
		String userAccNumber = withdrawCashDTO.getAccountNum();
		BigDecimal userReqAmount = withdrawCashDTO.getReqAmount();
		Integer atmId = withdrawCashDTO.getAtmId();
		String userAccounType = withdrawCashDTO.getAccountType();
		StringBuilder errorMessage = new StringBuilder();
		List<Integer[]> denominationList = new ArrayList<>();
		int[] denoValueArrayNew = null;
		int[] denoValueCountArr = null;
		int denoValueTotal = 0;
		BigDecimal totalAvailBalance = null;
		Map<Integer, Integer> denominationMap = new LinkedHashMap<>();
		
		if (StringUtils.isNotBlank(userAccNumber) && userReqAmount.compareTo(BigDecimal.ZERO) > 0 && atmId > 0 && StringUtils.isNotBlank(userAccounType)) {
			
			TransactionalAccountDTO transactionalAccDetails = getTransactionalAccDetails(userAccNumber,userAccounType);
			System.out.println("transactionalDTO: "+transactionalAccDetails.toString());
			List<DenominationDTO> denominationDTOs = atmDenominationService.getDenominationDetails(atmId);
			System.out.println("denominationDTOs size:"+denominationDTOs.size());
						
			denoValueArrayNew = denominationDTOs.stream().map(obj -> obj.getValue()).mapToInt(i -> i).toArray();
			System.out.println("############denoArrayNew: "+Arrays.toString(denoValueArrayNew));
			denoValueCountArr = denominationDTOs.stream().map(obj -> obj.getCount()).mapToInt(i -> i).toArray();
			System.out.println("############denoValueCountArr: "+Arrays.toString(denoValueCountArr));
			denoValueTotal = denominationDTOs.stream().map(obj -> obj.getTotalAmount()).mapToInt(i -> i).sum();
			System.out.println("############denoValueTotal: "+denoValueTotal);
			
			totalAvailBalance = transactionalAccDetails.getAccountBalance();
			if(denominationDTOs.size() > 0) {
				if("1".equals(transactionalAccDetails.getTransactional())) {
					if("CHQ".equals(transactionalAccDetails.getAccountType())) {
						if (transactionalAccDetails.getAccountBalance().intValue() > -10000
								&& (10000-(-1*transactionalAccDetails.getAccountBalance().intValue())) >= userReqAmount.intValue()) {
							if(denoValueTotal >= userReqAmount.intValue()) {
								//Allow to withdraw
								denominationList = solutions(denoValueArrayNew, denoValueCountArr, new int[denoValueArrayNew.length], userReqAmount.intValue(), 0);
								System.out.println("denominationList from CHQ account:-"+Arrays.toString(denominationList.get(0)));
								//****Update withdrawl amount to db****
								
								
							}else {
								errorMessage.append("Amount not available in ATM, would you like to draw "+denoValueTotal+" !!!");
							}
						}else {
							//Amount greater than -10,000 is not allowed to withdraw
							errorMessage.append("Insufficient funds in account!!");
						}
					}else {
						//Other than cheque account but transactional accounts
						if(transactionalAccDetails.getAccountBalance().intValue() > userReqAmount.intValue()) {
							if(denoValueTotal >= userReqAmount.intValue()) {
								//Allow to withdraw
								denominationList = solutions(denoValueArrayNew, denoValueCountArr, new int[denoValueArrayNew.length], userReqAmount.intValue(), 0);
								System.out.println("denominationList from "+userAccounType+":-"+Arrays.toString(denominationList.get(0)));
								//****Update withdrawl amount to db****
								
								
							}else {
								errorMessage.append("Amount not available in ATM, would you like to draw "+denoValueTotal+" !!!");
							}
						}else {
							errorMessage.append("Insufficient funds in account!!");
						}
					} 
				}else {
					errorMessage.append("Withdrawl is allowed for transactional accounts only!!!");
				}
						
			}else {
				//add error to page as invalid account number
				errorMessage.append("ATM not registered or unfunded!!!");
			}
		}else {
			
			errorMessage.append("Entered Account Number or Account Type or ATM ID or Amount incorrect!!!");
		}
		if(errorMessage.length()>0) {
			modelAndView.addObject("errorMessage", errorMessage.toString());
			modelAndView.setViewName("withdrawScreen");
		}else {
			
			for(int i=0;i<denoValueArrayNew.length;i++) {
				denominationMap.put(denoValueArrayNew[i],denominationList.get(0)[i]);
			}
			int denominationAffectedRows = atmDenominationService.updateDenominationDetails(atmId, denominationMap);
			System.out.println("!!!!!!affectedRows from updateDenomination: "+denominationAffectedRows);
			int transAffectedRows = updateTransAccBalance(userAccNumber,userReqAmount.intValue());
			System.out.println("!!!!!!affectedRows from transAffectedRows: "+transAffectedRows);
			System.out.println("denominationMap: "+denominationMap);
			modelAndView.addObject("denominationMap", denominationMap);
			modelAndView.addObject("userReqAmount", userReqAmount.intValue());
			modelAndView.addObject("availBalance",(totalAvailBalance.intValue()-userReqAmount.intValue()));
			modelAndView.setViewName("withdrawScreenSuccess");
		}
		return modelAndView;
	}
	
	
	private List<Integer[]> solutions(int[] values, int[] ammounts, int[] variation, int price, int position){
        List<Integer[]> list = new ArrayList<>();
        int value = compute(values, variation);
        if (value < price){
            for (int i = position; i < values.length; i++) {
                if (ammounts[i] > variation[i]){
                    int[] newvariation = variation.clone();
                    newvariation[i]++;
                    List<Integer[]> newList = solutions(values, ammounts, newvariation, price, i);
                    if (newList != null){
                        list.addAll(newList);
                    }
                }
            }
        } else if (value == price) {
            list.add(myCopy(variation));
        }
        return list;
    }    

    private static int compute(int[] values, int[] variation){
        int ret = 0;
        for (int i = 0; i < variation.length; i++) {
            ret += values[i] * variation[i];
        }
        return ret;
    }    

    private static Integer[] myCopy(int[] ar){
        Integer[] ret = new Integer[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ret[i] = ar[i];
        }
        return ret;
    }

	@Override
	public int updateTransAccBalance(String accountNum, Integer userReqAmount) {
		return clientAccountDao.updateTransAccBalance(accountNum, userReqAmount);
	}
	
}

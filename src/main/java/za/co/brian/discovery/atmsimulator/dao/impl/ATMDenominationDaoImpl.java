package za.co.brian.discovery.atmsimulator.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import za.co.brian.discovery.atmsimulator.dao.ATMDenominationDao;
import za.co.brian.discovery.atmsimulator.dto.DenominationDTO;
@Repository
public class ATMDenominationDaoImpl implements ATMDenominationDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public List<DenominationDTO> getDenominationDetails(Integer atmId) {
		Query query = entityManager.createNativeQuery(GET_DENOMINATION_DETAILS);
		query.setParameter("atmId", atmId);
		List<Object[]> denominationDTODbList = query.getResultList();
		List<DenominationDTO> denominationDTOList = new ArrayList<>();
		for (Object[] obj : denominationDTODbList) {
		   DenominationDTO denominationDTO = new DenominationDTO();
		   denominationDTO.setValue((Integer) obj[0]);
		   denominationDTO.setCount((Integer) obj[1]);
		   denominationDTO.setTotalAmount((Integer) obj[2]);
		   denominationDTOList.add(denominationDTO);
		}
		System.out.println("denominationDTOList size: "+denominationDTOList.size());
		System.out.println("denominationDTOList from getDenomination: "+denominationDTOList.toString());
		return denominationDTOList;
	}
	
	@Transactional
	@Modifying
	public int updateDenominationDetails(Integer atmId, Map<Integer, Integer> denomMap) {
		
		StringBuilder update_atm_denomination_count = new StringBuilder();
		update_atm_denomination_count.append("UPDATE ATM_ALLOCATION ");		
		update_atm_denomination_count.append("SET COUNT = CASE ");
		for(int i = 0;i<denomMap.size();i++) {
			update_atm_denomination_count.append("WHEN (DENOMINATION_ID = (SELECT DENOMINATION_ID FROM DENOMINATION WHERE VALUE =:DenomKey"+i+")) THEN COUNT - (:DenomValue"+i+") ");	
		}
		update_atm_denomination_count.append("END ");
		update_atm_denomination_count.append("WHERE ATM_ID =:atmId");
		Query query = entityManager.createNativeQuery(update_atm_denomination_count.toString());
		int i = 0;
		for (Map.Entry<Integer,Integer> entry : denomMap.entrySet())  {
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
    		query.setParameter("DenomKey"+i, entry.getKey());
			query.setParameter("DenomValue"+i, entry.getValue());
			i++;
    	} 
		query.setParameter("atmId", atmId);
		int updateDenominationResult = query.executeUpdate();
		System.out.println("updateDenominationResult :"+updateDenominationResult);
	
		return updateDenominationResult;
	}
}

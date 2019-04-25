package za.co.brian.discovery.atmsimulator.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.brian.discovery.atmsimulator.dao.ATMDenominationDao;
import za.co.brian.discovery.atmsimulator.dto.DenominationDTO;
import za.co.brian.discovery.atmsimulator.service.ATMDenominationService;

@Service
public class ATMDenominationServiceImpl implements ATMDenominationService {
	
	@Autowired
    ATMDenominationDao atmDenominationDao;
	
	@Override
	public int updateDenominationDetails(Integer atmId, Map<Integer, Integer> denomMap) {
		return atmDenominationDao.updateDenominationDetails(atmId, denomMap);
	}

	@Override
	public List<DenominationDTO> getDenominationDetails(Integer atmId) {
		return atmDenominationDao.getDenominationDetails(atmId);
	}
}

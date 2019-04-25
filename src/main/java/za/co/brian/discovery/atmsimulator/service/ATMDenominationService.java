package za.co.brian.discovery.atmsimulator.service;

import java.util.List;
import java.util.Map;

import za.co.brian.discovery.atmsimulator.dto.DenominationDTO;

public interface ATMDenominationService {
	public List<DenominationDTO> getDenominationDetails(Integer atmId);
	public int updateDenominationDetails(Integer atmId, Map<Integer, Integer> denomMap);
}

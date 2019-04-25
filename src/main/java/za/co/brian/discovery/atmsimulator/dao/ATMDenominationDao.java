package za.co.brian.discovery.atmsimulator.dao;

import java.util.List;
import java.util.Map;

import za.co.brian.discovery.atmsimulator.dto.DenominationDTO;

public interface ATMDenominationDao {
	public List<DenominationDTO> getDenominationDetails(Integer atmId);
	public int updateDenominationDetails(Integer atmId, Map<Integer, Integer> denomMap);
	
	public static final String GET_DENOMINATION_DETAILS = "SELECT  D.VALUE, AL.COUNT, (D.VALUE * AL.COUNT ) AS TOTAL " + 
			"from ATM_ALLOCATION  AL INNER JOIN DENOMINATION D " + 
			"ON AL.DENOMINATION_ID = D.DENOMINATION_ID " + 
			"WHERE AL.ATM_ID =:atmId AND D.DENOMINATION_TYPE_CODE = 'N' "+
			"ORDER BY D.VALUE DESC ";
	
	public static final String UPDATE_ATM_DENOMINATION_COUNT = "UPDATE ATM_ALLOCATION "
			+ "SET COUNT = CASE "
			+ "WHEN (DENOMINATION_ID = (SELECT DENOMINATION_ID FROM DENOMINATION WHERE VALUE =:1stDenomKey)) THEN COUNT - :1stDenomValue "
			+ "WHEN (DENOMINATION_ID = (SELECT DENOMINATION_ID FROM DENOMINATION WHERE VALUE =:2ndDenomKey)) THEN COUNT - :2ndDenomValue "
			+ "WHEN (DENOMINATION_ID = (SELECT DENOMINATION_ID FROM DENOMINATION WHERE VALUE =:3rdDenomKey)) THEN COUNT - :3rdDenomValue "
			+ "WHEN (DENOMINATION_ID = (SELECT DENOMINATION_ID FROM DENOMINATION WHERE VALUE =:4thDenomKey)) THEN COUNT - :4thDenomValue "
			+ "WHEN (DENOMINATION_ID = (SELECT DENOMINATION_ID FROM DENOMINATION WHERE VALUE =:5thDenomKey)) THEN COUNT - :5thDenomValue "
		//	+ "ELSE 0"
			+ "END"
			+ "WHERE ATM_ID =:atmId";
}

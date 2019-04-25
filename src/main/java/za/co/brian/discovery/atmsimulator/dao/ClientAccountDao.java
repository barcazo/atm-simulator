package za.co.brian.discovery.atmsimulator.dao;

import java.util.List;

import za.co.brian.discovery.atmsimulator.dto.ClientFinancialAggDTO;
import za.co.brian.discovery.atmsimulator.dto.CurrencyAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.TransactionalAccountDTO;

public interface ClientAccountDao {
	public List<TransactionalAccountDTO> getAllTransactionalAccs();
	public TransactionalAccountDTO getTransactionalAccDetails(String accountNum, String accountType);
	public List<CurrencyAccountDTO> getAllCurrencyAccs();
	public List<TransactionalAccountDTO> getTransAccsPerClient();
	public List<ClientFinancialAggDTO> getAggFinancialClientInfo();
	public int updateTransAccBalance(String accountNum, Integer userReqAmount);
	
	public static final String GET_ALL_TRANSACTIONAL_ACCOUNTS = "SELECT ca.CLIENT_ACCOUNT_NUMBER AS Account_Number, "
			+ "at.DESCRIPTION AS Account_Type, ROUND(ca.DISPLAY_BALANCE,2) "
			+ "FROM CLIENT_ACCOUNT ca,  ACCOUNT_TYPE at "
			+ "WHERE ca.ACCOUNT_TYPE_CODE = at.ACCOUNT_TYPE_CODE AND at.TRANSACTIONAL = 1"
			+ "order by ca.DISPLAY_BALANCE desc"; 
	
	public static final String GET_TRANSACTIONAL_AC_DETAILS = "SELECT ca.CLIENT_ACCOUNT_NUMBER AS Account_Number, at.ACCOUNT_TYPE_CODE AS Account_Type, "
			+ "ROUND(ca.DISPLAY_BALANCE,2) AS ACCOUNT_BALANCE, at.TRANSACTIONAL "
			+ "FROM CLIENT_ACCOUNT ca INNER JOIN  ACCOUNT_TYPE at ON ca.ACCOUNT_TYPE_CODE = at.ACCOUNT_TYPE_CODE "
			+ "WHERE ca.CLIENT_ACCOUNT_NUMBER =:accNumber and ca.ACCOUNT_TYPE_CODE =:accountType";
	
	public static final String GET_ALL_CURRENCY_ACCOUNTS = "SELECT ca.CLIENT_ACCOUNT_NUMBER AS Account_Number, ca.CURRENCY_CODE AS CURRENCY, ROUND(ca.DISPLAY_BALANCE,2), "
			+ "ccr.RATE AS Conversion_Rate, "
			+ "CASE WHEN ca.CURRENCY_CODE <> 'ZAR'  AND ccr.CONVERSION_INDICATOR = '*' "
			+ "THEN ROUND((ca.DISPLAY_BALANCE * ccr.RATE),2) "
			+ "WHEN ca.CURRENCY_CODE <> 'ZAR'  AND ccr.CONVERSION_INDICATOR = '/' "
			+ "THEN ROUND((ca.DISPLAY_BALANCE / ccr.RATE),2) " + "ELSE ROUND(ca.DISPLAY_BALANCE,2) "
			+ "END AS ZAR_Amount " + "FROM CLIENT_ACCOUNT ca, CURRENCY_CONVERSION_RATE ccr "
			+ "WHERE ca.CURRENCY_CODE = ccr.CURRENCY_CODE " + "order by ZAR_Amount desc";
	
	public static final String GET_ALL_TRANSACTIONAL_ACC_PER_CLIENT = "SELECT CA.CLIENT_ID, C.SUR_NAME , CA.CLIENT_ACCOUNT_NUMBER, AT.DESCRIPTION, "
			+ " MAX(CA.DISPLAY_BALANCE) AS DISPLAY_BALANCE " + "	FROM CLIENT_ACCOUNT CA "
			+ "	INNER JOIN CLIENT C ON CA.CLIENT_ID = C.CLIENT_ID "
			+ "	INNER JOIN ACCOUNT_TYPE AT ON CA.ACCOUNT_TYPE_CODE = AT.ACCOUNT_TYPE_CODE "
			+ "	WHERE CA.DISPLAY_BALANCE = (SELECT MAX(CAC.DISPLAY_BALANCE) FROM  CLIENT_ACCOUNT CAC "
			+ " WHERE CA.CLIENT_ID = CAC.CLIENT_ID GROUP BY CAC.CLIENT_ID) AND AT.TRANSACTIONAL = 1 "
			+ "	GROUP BY CA.CLIENT_ID";
	
	public static final String GET_AGG_FINANCIAL_POS_PER_CLIENT = "select concat(TITLE,' ',NAME,' ',SUR_NAME) client_name,loan.client_id , AGG_LOAN,AGG_TRANSACT, "
			+"CASE WHEN SIGN(AGG_LOAN) = -1 THEN  AGG_TRANSACT -(-1* AGG_LOAN) " + 
			"ELSE AGG_TRANSACT - AGG_LOAN END as NET_POSITION from " + 
			"(SELECT client_id, SUM(DISPLAY_BALANCE) AS AGG_LOAN FROM  CLIENT_ACCOUNT " + 
			"WHERE ACCOUNT_TYPE_CODE IN ('PLOAN','HLOAN') " + 
			"GROUP BY client_id)  transaction left join " + 
			"(select client_id, SUM(DISPLAY_BALANCE) AS AGG_TRANSACT " + 
			"FROM CLIENT_ACCOUNT CA LEFT JOIN  ACCOUNT_TYPE at " + 
			"ON ca.ACCOUNT_TYPE_CODE = at.ACCOUNT_TYPE_CODE " + 
			"WHERE TRANSACTIONAL = 1 " + 
			"GROUP BY client_id) loan on transaction.client_id = loan.client_id " + 
			"inner join client c on c.client_id = loan.client_id";
	
	public static final String UPDATE_TRANSACTIONAL_ACCOUNT = "UPDATE CLIENT_ACCOUNT "
			+ "SET DISPLAY_BALANCE = DISPLAY_BALANCE - (:userReqAmt) "
			+ "WHERE CLIENT_ACCOUNT_NUMBER =:accNumber ";
	
}

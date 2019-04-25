package za.co.brian.discovery.atmsimulator.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import za.co.brian.discovery.atmsimulator.dto.ClientFinancialAggDTO;
import za.co.brian.discovery.atmsimulator.dto.CurrencyAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.TransactionalAccountDTO;
import za.co.brian.discovery.atmsimulator.dto.WithdrawCashDTO;
import za.co.brian.discovery.atmsimulator.service.ClientAccountService;

@Controller
public class ATMSimulatorController {

	@Autowired
	ClientAccountService clientAccountService; 
	
	@RequestMapping(value = "/home", method = RequestMethod.GET, headers = "Accept=application/json")
	public String tohomePage(HttpServletRequest request, Model model) 
	{
		System.out.println("homepage");
		return "homepage";
	}
	
	@RequestMapping(value = "/gettransacationalaccs", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getTransactionalAccs(HttpServletRequest request, Model model) 
	{
		System.out.println("getTransactionalAccs");
		ModelAndView modelAndView = new ModelAndView();
		
		List<TransactionalAccountDTO> transactionalAccList = clientAccountService.getAllTransactionalAccs();
		System.out.println("list size:"+transactionalAccList.size());
		modelAndView.addObject("transactionalAccList", transactionalAccList);
		modelAndView.setViewName("transactionalAccounts");
		return modelAndView;
	}
	@RequestMapping(value = "/getcurrencyaccs", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getCurrencyAccs(HttpServletRequest request, Model model) 
	{
		System.out.println("getCurrencyAccs");
		ModelAndView modelAndView = new ModelAndView();
		
		List<CurrencyAccountDTO> currencyAccList = clientAccountService.getAllCurrencyAccs();
		System.out.println("list size:"+currencyAccList.size());
		modelAndView.addObject("currencyAccList", currencyAccList);
		modelAndView.setViewName("currencyAccounts");
		return modelAndView;
	}
	
	@RequestMapping(value = "/downloadtrsancreport")
    public void downloadTransAccCSV(HttpServletResponse response) throws IOException {
		String csvFileName = "TransAccCSV.csv";
        response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "Client Id", "Client Surname", "Client Account Number", "Account Description",
                "Display Balance" };
        
        final String[] fieldMapping = new String[] {"clientId", "surName", "clientAccountNumber", "description",
                "accountBalance"};
        csvWriter.writeHeader(header);
        List<TransactionalAccountDTO> transAccList = clientAccountService.getTransAccPerClient();
		System.out.println("transAccList size:"+transAccList.size());
        for (TransactionalAccountDTO transactionalAccount : transAccList) {
            csvWriter.write(transactionalAccount,fieldMapping);
        }
        csvWriter.close();
	}
	
	@RequestMapping(value = "/downloadclientaggreport")
    public void downloadFinancialAggCSV(HttpServletResponse response) throws IOException {
		String csvFileName = "ClientAggCSV.csv";
        response.setContentType("text/csv");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "Client", "Loan Balance", "Transactional Balance", "Net Position"};
        
        final String[] fieldMapping = new String[] {"clientName", "aggLoanBalance", "aggTranscBalance", "netPosition"};
        
        csvWriter.writeHeader(header);
        
        List<ClientFinancialAggDTO> financialAggList = clientAccountService.getAggFinancialClientInfo();
		System.out.println("financialAggList size:"+financialAggList.size());
        for (ClientFinancialAggDTO financialAggClient : financialAggList) {
            csvWriter.write(financialAggClient,fieldMapping);
        }
        csvWriter.close();
	}
	@RequestMapping(value = "/getwithdrawcash", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getwithdrawcash(HttpServletRequest request, Model model) 
	{
		System.out.println("withdrawScreen");
		return "withdrawScreen";
	}
	@RequestMapping(value = "/withdrawcash", method = RequestMethod.POST)
	public ModelAndView withdrawMoney(HttpServletRequest request, @ModelAttribute("withdrawCashDTO") WithdrawCashDTO withdrawCashDTO)
	{
		System.out.println("withdrawScreen");
		System.out.println("withdrawCashDTO from UI: "+withdrawCashDTO.toString());	
		
		return clientAccountService.withdrawalProcessing(withdrawCashDTO);
	}
	
}

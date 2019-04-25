<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency Accounts</title>
<style type="text/css">
	#transTable {
		  /* width: 100%; */ 
		  border-spacing: 0px !important;
		  text-align: center;
		}
	#headings{
		background-color: darkgray;
		/* text-align: -webkit-center; */
	 }
	 #backButton{ 	
	 }
</style>
</head>
<body>
	<table border="solid" bordercolor="black" id="transTable">
		<thead>
		<tr>
			<!-- <td></td> -->
			<td colspan="5">Currency Account Balances</td>
			<!-- <td></td> -->
		</tr>
		<tr id ="headings">
			<td>Account Number</td>
			<td>Currency</td>
			<td>Currency Balance</td>
			<td>Conversion Rate</td>
			<td>ZAR Amount</td>
		</tr>
		</thead>
		<tbody>
			<c:if test="${not empty currencyAccList}">
				<c:forEach var="listValue" items="${currencyAccList}">
					<tr>
						<td>${listValue.getAccountNumber()}</td>
						<td>${listValue.getCurrency()}</td>
						<td>${listValue.getCurrencyBalance()}</td>
						<td>${listValue.getConversionRate()}</td>
						<td>${listValue.getZarAmount()}</td>
					</tr>
				</c:forEach>
			</c:if>
			<%-- <c:otherwise>
				<h1>There are no Currency Account balances</h1>
			</c:otherwise> --%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5"><input type="button" value="Back" onclick="location.href='/home';" style="float: right; margin-right: 14px; width: 78px;"></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>
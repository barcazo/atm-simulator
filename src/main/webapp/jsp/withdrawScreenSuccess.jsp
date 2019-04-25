<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Screen Results</title>
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
			<td colspan="5">ATM Withdrawal</td>
			<!-- <td></td> -->
		</tr>
		<tr id ="headings">
			<td>Note Value</td>
			<td>Note Count</td>
			
		</tr>
		</thead>
		<tbody>
			<c:if test="${not empty denominationMap}">
				<c:forEach var="denominationValue" items="${denominationMap}">
					<tr>
						<td>${denominationValue.key}</td>
						<td>${denominationValue.value}</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td>Withdrawl Amount</td>
				<td>${userReqAmount}</td>
			</tr>
			<tr>
				<td>Available Balance</td>
				<td>${availBalance}</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2"><input type="button" value="Back" onclick="location.href='/home';" style="float: right; width: 78px;"></td>
			</tr>
			
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw Screen</title>
</head>
<body>
	<div align="center">
		<font color="red">${errorMessage}</font>
		<form method="post" action="withdrawcash">
			<table style ="border: solid 2px">
				<thead>
					<tr>
						<td colspan="2" style ="font-size: 25px">Draw From Account</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>ATM Id:</td>
						<td>
							<div >
								<input type="text" class="form-control" id="atmId" name="atmId"> 
							</div>
					</td>
					</tr>
					<tr>
						<td>Type:</td>
						<td>
							<div class="form-group col-md-3">
								<select id="accountType" name="accountType" class="select form-control">
										<option value="">Select</option>
										<option value="CHQ">Cheque Account</option>
										<option value="SVGS">Savings Account</option>
										<option value="PLOAN">Personal Loan Account</option>
										<option value="HLOAN">Home Loan Account</option>
										<option value="CCRD">Credit Card</option>
										<option value="CFCA">Customer Foreign Currency Account</option>
								</select>
							</div>
					</td>
					</tr>
					<tr>
						<td>Account Number:</td>
						<td>
							<div >
							<input type="text" class="form-control" id="accountNum" name="accountNum"> 
							</div>
						</td>
					</tr>
					<tr>
						<td>Required Amount:</td>
						<td>
							<div >
								<input type="text" class="form-control" id="reqAmount" name="reqAmount"> 
							</div>
					</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="3"> <input type="submit" value="Submit" style="float: right; margin-right: 14px; width: 86px;"/></td>
					</tr>
					 <tr>
						<td colspan="3"><input type="button" value="Back" onclick="location.href='/home';" style="float: right; margin-right: 14px; width: 86px;"></td>
					</tr> 
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>
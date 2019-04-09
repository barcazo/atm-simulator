# Bank Balance and Dispensing System

Introduction
The goal of the Bank Balance and Dispensing System is to calculate and display the financial position to a client on an ATM screen.  In addition a client must also be able to make a request for a cash withdrawal.


# Running The Application
- Clone the project to your local instance
- Build the project using the command below:
	1. mvn clean install
- Run the application using the command below:
	1. mvn spring-boot:run 
- Application should be accessible on port 8080 provided the port is not already in use:
- Application makes use of the inbuilt H2 database
- To login to the H2 Database use the credentials below:

1.	http://localhost:8080/h2-console
2.	username: sa
3.	password: 
4.	JDBC url: jdbc:h2:mem:testdb
	


Module Links :
1.	Home : http://localhost:8080/home
2.	Get All Transactional Account Balances : http://localhost:8080/gettransacationalaccs 
3.	 Get Currency Account Balances : http://localhost:8080/getcurrencyaccs
4.	Withdraw Cash : http://localhost:8080/withdrawcash
5.	Download Transactional Accounts Report 
6.	Download Aggerate Financial Accounts Report

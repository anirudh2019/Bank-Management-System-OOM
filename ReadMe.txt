
This is an Undergraduate JAVA Project demostrating Object Oriented Paradigm.

	Project Contributors :

	1. ANIRUDH SIMHACHALAM  (IIT2019068)
	2. ANKUSH SONKER        (IIT2019072)
	3. AJAY NIKHIL          (IIT2019075)
	
		---- B.Tech IT,IIITA (Batch 2019-2023)


Project Description:
It allows user to create an account either of type saving or current account. It also allows to apply for a loan. Admins of the bank can login to their account and perform various activities like view customer info etc.

JAVA CLASSES : 

	Main Execution JAVA File in Project: Authentication.java 
	All Txt Files have been provided in the Project Folder

    AUTHENTICATION CLASSES:

	* Authentication.java is the main driver class which starts the banking project.
	* CustomerLogin.java is a class which allows all the customers to access their accounts.
	* EmployeeLogin.java is a class which allows employees and admin to access database.
	* ATMAuthentication.java is a class which allows customers to access ATM Services. 

    SERVER AND DATA STORING CLASSES:

	* Account.java is a class which has some basic attributes like account number and pin function.
	* Data.java is a class storing basic ata such as name, gender etc of a customer.
	* Database.java class serves server-side requests like allowing to login in,log out,check valid account etc.
	
    GENERAL PURPOSE CLASSES:

	* CreateAccount.java is a class which allows user to create account.
	* CustomerDashboard.java is a class displaying customerdashboard after logging in.
	* ATM.java is a class displaying ATM info after the customer logs in.
	* EmployeeDashboard.java is a class displaying employee dashboard after logging in.
	* Help.java is a general purpose helping class.

    LOAN ACCOUNT RELATED CLASSES:

	* LoanAccount.java is a sub-class from Account.java which signifies all loan related methods and attributes.
	* LoanApplication.java is a class which allows user to apply for loan.
	* LoanDashboard.java displays the dashboard(details) of the customer regarding loan details.

    SAVING ACCOUNT RELATED CLASSES:

	* SavingAccount.java is a sub-class from Account.java which signifies all the functionalities for a saving account.

    TEXT FILES USED AS DATABASES:

	* SavingAccountDataBase.txt is used to store data of all the customers having saving account in the bank.
	* LoanAccountDataBase.txt is used to store data of all the customers who have taken loan from the bank.
	* ATMDataBase.txt is used to store the ATM related data of the customer.
	* EmployeedataBase.txt is used to store the data of all the employees and the entire administration of the bank.
	
	BANKING IMAGES FOLDER:
	
	* This folder holds all the images used in this project.
	
	
	
	
	
	
	
	

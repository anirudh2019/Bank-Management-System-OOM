package banking;

public class Data
{
	protected String name,DoB,address,state,city,phone,pin,gender,accountType;
	LoanAccount acc = new LoanAccount();
	
	protected void getData(String Name,String DOB,String Address,String State,String City,String Phone,String Pin,String AccountType,String Gender)
	{
		this.name=Name;
		this.DoB=DOB;
		this.address=Address;
		this.state=State;
		this.city=City;
		this.phone=Phone;
		this.pin=Pin;
		this.accountType=AccountType;
		this.gender=Gender;
	}
	
	protected void getLoanData(String Name,String DOB,String Address,String State,String Gender,String PhotoID,String ID,String Loan,String Duration)
	{
		this.name=Name;
		this.DoB=DOB;
		this.address=Address;
		this.state=State;
		this.gender=Gender;
		this.acc.photoID=PhotoID;
		this.acc.idNumber=ID;
		this.acc.principalAmount=Double.parseDouble(Loan);
		this.acc.loanDuration=Integer.parseInt(Duration);
	}
}
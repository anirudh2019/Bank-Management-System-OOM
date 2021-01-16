package banking;

public class SavingAccount extends Account
{
	private double interestRate=0.02;
	
	protected void creditInterest()
	{
		balance+=interestRate*balance;
	}
	
	protected double getBalance()
	{
		return balance;
	}
}
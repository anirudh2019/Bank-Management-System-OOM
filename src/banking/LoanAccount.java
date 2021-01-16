package banking;

public class LoanAccount
{
	protected String photoID,idNumber;
	protected double principalAmount,currentLoanAmount;
	static double interestRate=0.2;
	protected int loanDuration;
	
	protected String getLoanAmount(String amount)
	{
		return amount;
	}
	
	protected int getLoanDuration(String accNo)
	{
		return loanDuration;
	}
	
	protected void debitLoanAmount(String accNo)
	{
		double installmentAmount=principalAmount/loanDuration;
		double debitAmount= installmentAmount + installmentAmount*interestRate;
		currentLoanAmount-=debitAmount;
	}
	
	protected static double getInstallmentAmount(double amount,String months)
	{
		int x=Integer.parseInt(months);
		double loanamount=amount/x;
		return (loanamount*(interestRate+1));
	}
}
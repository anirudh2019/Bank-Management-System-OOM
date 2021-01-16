package banking;

import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class Account
{
	protected static double balance;
	protected String accountNumber,password,ATMCardNo,ATMPin;
	protected static double minBalance=500,maxWithdrawlLimit=50000;
	private static long val=123456788,val1=4567834,val2=456780988;
	
	protected static double deposit(double money,double balance)
	{
		if(money<0)
			JOptionPane.showMessageDialog(null,"Please Enter a Positive Amount");
		else
		{
			balance=balance+money;
			JOptionPane.showMessageDialog(null,"Rs "+money+" has been deposited successfully");
		}
		return balance;
	}
	
	protected static double withdraw(double money,double balance)
	{
		if(money<0)
			JOptionPane.showMessageDialog(null,"Please Enter a Positive Amount");
		else if(balance-money>=minBalance && money<=maxWithdrawlLimit)
		{
			balance=balance-money;
			JOptionPane.showMessageDialog(null,"Transaction is completed !!");
			return balance;
		}
		else if(balance-money<minBalance)
			JOptionPane.showMessageDialog(null,"You do not have sufficient balance !!");
		else
			JOptionPane.showMessageDialog(null,"Daily Withdrawl Limit is Rs. 50,000 !!");

		return balance;
	}
	
	protected static long getAccNumber(String filename)
	{
		long ac=0,x=0;
		if(filename.equals("SavingAccountDataBase.txt"))
			x=val;
		else if(filename.equals("ATMDataBase.txt"))
			x=val1;
		else if(filename.equals("LoanAccountDataBase.txt"))
			x=val2;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			int cnt=0;
			while(br.readLine()!=null)
					cnt++;
			ac=cnt+x;
			br.close();
			return ac;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return ac;
	}
	
	protected static String generatePIN()
	{
		Random r = new Random();
		return String.valueOf(r.nextInt(1000)+8999);
	}
}
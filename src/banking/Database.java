package banking;

import java.awt.GridLayout;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Database
{
	private static Database newDB;
	protected static ArrayList<String> savingAccountList = new ArrayList<String>();
	protected static ArrayList<String> LoanAccountList = new ArrayList<String>();
	protected static ArrayList<String> employeeAccountList = new ArrayList<String>();
	protected static ArrayList<String> ATMAccountList = new ArrayList<String>();

	public static Database getnewDB()
	{
		if(newDB == null)
			newDB = new Database();
		return newDB;
	}
	
	protected static void addAccount(Data ob)
	{
		Account ac = new Account();
		ac.accountNumber=Long.toString(Account.getAccNumber("SavingAccountDataBase.txt"));
		ac.password=Account.generatePIN();
		ac.ATMCardNo=Long.toString(Account.getAccNumber("ATMDataBase.txt"));
		ac.ATMPin = Account.generatePIN();
		savingAccountList.add(ac.accountNumber);
		savingAccountList.add(ac.password);
		savingAccountList.add(Double.toString(Account.minBalance));
		savingAccountList.add(ob.name);
		savingAccountList.add(ob.DoB);
		savingAccountList.add(ob.address);
		savingAccountList.add(ob.state);
		savingAccountList.add(ob.city);
		savingAccountList.add(ob.phone);
		savingAccountList.add(ob.pin);
		savingAccountList.add(ob.gender);
		
		ATMAccountList.add(ac.ATMCardNo);
		ATMAccountList.add(ac.ATMPin);
		ATMAccountList.add(ac.accountNumber);
		
		JOptionPane.showMessageDialog(null,"Account No:"+ac.accountNumber+"\nPassword:"+ac.password+"\nATM Card No:"+ac.ATMCardNo+"\nATM Pin:"+ac.ATMPin+"\n\nSuccessfully Created Account !!","SYSTEM GENERATED INFORMATION",JOptionPane.INFORMATION_MESSAGE );
	}
	
	protected static void addLoanData(Data ob)
	{
		Account ac = new Account();
		ac.accountNumber=Long.toString(Account.getAccNumber("LoanAccountDataBase.txt"));
		ac.password=Account.generatePIN();
		LoanAccountList.add(ac.accountNumber);
		LoanAccountList.add(ac.password);
		LoanAccountList.add(String.valueOf(ob.acc.principalAmount));
		LoanAccountList.add(String.valueOf(ob.acc.loanDuration));
		LoanAccountList.add(ob.name);
		LoanAccountList.add(ob.DoB);
		LoanAccountList.add(ob.address);
		LoanAccountList.add(ob.state);
		LoanAccountList.add(ob.gender);
		LoanAccountList.add(ob.acc.photoID);
		LoanAccountList.add(ob.acc.idNumber);
		
		JOptionPane.showMessageDialog(null,"Account No:"+ac.accountNumber+"\nPassword:"+ac.password,"\n\nSuccessfully Created Account !!",JOptionPane.INFORMATION_MESSAGE );
	}
	
	protected static void modifyAccount(ArrayList<String>list,String acType)
	{
		if(acType.equals("Saving Account"))
		{
			for(int i=0;i<savingAccountList.size();i+=11)
			{
				if(savingAccountList.get(i).equals(list.get(0)))
				{
					for(int j=0;j<list.size();j++)
						savingAccountList.set(i+j,list.get(j));
				}
			}
		}
		else if(acType.equals("Employee Account"))
		{
			for(int i=0;i<employeeAccountList.size();i+=11)
			{
				if(employeeAccountList.get(i).equals(list.get(0)))
				{
					for(int j=0;j<list.size();j++)
						employeeAccountList.set(i+j,list.get(j));
				}
			}
		}
	}
	
	protected static void modifyATMPin(ArrayList<String>list)
	{
		for(int i=0;i<ATMAccountList.size();i+=3)
		{
			if(ATMAccountList.get(i).equals(list.get(0)))
			{
				for(int j=0;j<list.size();j++)
					ATMAccountList.set(i+j,list.get(j));
			}
		}
	}
	
	protected static void loadDataBase()
	{
		try
		{
			BufferedReader br,br1,br2,br3;
			br = new BufferedReader(new FileReader(new File("SavingAccountDataBase.txt")));
			String temp;
			while((temp=br.readLine())!=null)
				savingAccountList.add(temp);
			br.close();
			
			br1 = new BufferedReader(new FileReader(new File("EmployeeDataBase.txt")));
			String temp1;
			while((temp1=br1.readLine())!=null)
				employeeAccountList.add(temp1);
			br1.close();
			
			br2 = new BufferedReader(new FileReader(new File("ATMDataBase.txt")));
			String temp2;
			while((temp2=br2.readLine())!=null)
				ATMAccountList.add(temp2);
			br2.close();
			
			br3 = new BufferedReader(new FileReader(new File("LoanAccountDataBase.txt")));
			String temp3;
			while((temp3=br3.readLine())!=null)
				LoanAccountList.add(temp3);
			br3.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	protected static ArrayList<String> loadATM(String acNoo)
	{
		ArrayList<String> str = new ArrayList<String>();
		for(int i=0;i<ATMAccountList.size();i+=3)
			if(ATMAccountList.get(i).equals(acNoo))
			{
				str.add(ATMAccountList.get(i));
				str.add(ATMAccountList.get(i+1));
				str.add(ATMAccountList.get(i+2));
				break;
			}
		return str;
	}
	
	protected static String isValidATMDetail(String atmNo,String pin)
	{
		int i=0;
		boolean flag=false;
		for(i=0;i+1<ATMAccountList.size();i+=3)
		{
			if(ATMAccountList.get(i).equals(atmNo) && ATMAccountList.get(i+1).equals(pin))
			{
				flag=true;
				break;
			}
		}
		if(flag)
			return ATMAccountList.get(i+2);
		else
			return "-1";
	}
	
	protected static void saveDataBase()
	{
		try
		{
			int i=0;
			BufferedWriter bw,bw1,bw2,bw3;
			bw = new BufferedWriter(new FileWriter(new File("SavingAccountDataBase.txt")));
			while(i<savingAccountList.size())
			{
				if(savingAccountList.get(i).equals("-1"))
					i++;
				else
				{
					bw.write(String.valueOf(savingAccountList.get(i))+"\n");
					i++;
				}
			}
			savingAccountList.clear();
			
			bw.close();
			
			i=0;
			bw1 = new BufferedWriter(new FileWriter(new File("ATMDataBase.txt")));
			while(i<ATMAccountList.size())
			{
				if(ATMAccountList.get(i).equals("-1"))
					i++;
				else
				{
					bw1.write(String.valueOf(ATMAccountList.get(i))+"\n");
					i++;
				}
			}
			ATMAccountList.clear();
			
			bw1.close();
			
			i=0;
			bw2 = new BufferedWriter(new FileWriter(new File("LoanAccountDataBase.txt")));
			while(i<LoanAccountList.size())
			{
				if(LoanAccountList.get(i).equals("-1"))
					i++;
				else
				{
					bw2.write(String.valueOf(LoanAccountList.get(i))+"\n");
					i++;
				}
			}
			LoanAccountList.clear();
			
			bw2.close();
			
			i=0;
			bw3 = new BufferedWriter(new FileWriter(new File("EmployeeDataBase.txt")));
			while(i<employeeAccountList.size())
			{
				if(employeeAccountList.get(i).equals("-1"))
					i++;
				else
				{
					bw3.write(String.valueOf(employeeAccountList.get(i))+"\n");
					i++;
				}
			}
			employeeAccountList.clear();
			
			bw3.close();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	protected static void printData()
	{
	  	JPanel panel  = new JPanel(new GridLayout(1,2));
	  	JLabel label1 = new JLabel("Enter Account Type : ");
	  	JTextField field1 = new JTextField();
	  	panel.add(label1);
	  	panel.add(field1);
	  	JOptionPane.showMessageDialog(null, panel);
	  	if(field1.getText().equalsIgnoreCase("SavingAccount"))
	  	{
		  	DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Account No.", "Balance", "Phone No.", "Gender","Address","City","State","PinCode"}, 0);
	  		for(int i=0;i<savingAccountList.size();i+=11)
	  			model.addRow(new Object[]{savingAccountList.get(i+3),savingAccountList.get(i),savingAccountList.get(i+2),savingAccountList.get(i+8),savingAccountList.get(i+10),savingAccountList.get(i+5),savingAccountList.get(i+6),savingAccountList.get(i+7),savingAccountList.get(i+9)});
	  		
	  		JTable table = new JTable(model);
	  		JFrame frame = new JFrame();
	  		frame.add(new JScrollPane(table));
	  		frame.setSize(1400,300);
	  		frame.setLocation(100,150);
	  		frame.setVisible(true);
	  	}
	  	
	  	else if(field1.getText().equalsIgnoreCase("LoanAccount"))
	  	{
		  	DefaultTableModel model = new DefaultTableModel(new String[]{"Name", "Account No.", "Loan Amount", "Loan Duration", "State","Address","Gender","Photo ID Number"}, 0);
	  		for(int i=0;i<LoanAccountList.size();i+=11)
	  			model.addRow(new Object[]{LoanAccountList.get(i+4),LoanAccountList.get(i),LoanAccountList.get(i+2),LoanAccountList.get(i+3),LoanAccountList.get(i+8),LoanAccountList.get(i+6),LoanAccountList.get(i+7),LoanAccountList.get(i+10)});
	  		
	  		JTable table = new JTable(model);
	  		JFrame frame = new JFrame();
	  		frame.add(new JScrollPane(table));
	  		frame.setSize(1400,600);
	  		frame.setLocation(100,150);
	  		frame.setVisible(true);
	  	}
	  	else
			JOptionPane.showMessageDialog(null,"Invaild Account Type !!");		
	  	
	}
	
	protected static String validTransfer(String acNo1,String acNo2,String amount)
	{
		int i,j;
		for(i=0;i<savingAccountList.size();i+=11)
			if(savingAccountList.get(i).equals(acNo1))
				break;
		for(j=0;j<savingAccountList.size();j+=11)
			if(savingAccountList.get(j).equals(acNo2))
				break;
		if(j>=savingAccountList.size())
			JOptionPane.showMessageDialog(null,"Account Number Entered is Invalid !!");	
		else
		{
			Double b=Account.withdraw(Double.parseDouble(amount),Double.parseDouble(savingAccountList.get(i+2)));
			Double a=Account.deposit(Double.parseDouble(amount),Double.parseDouble(savingAccountList.get(j+2)));
			savingAccountList.set(j+2,String.valueOf(a));
			savingAccountList.set(i+2,String.valueOf(b));
		}
		return savingAccountList.get(i+2);
	}
	
	protected static ArrayList<String> loadATMData(String acNo)
	{
		ArrayList<String>temp = new ArrayList<String>();
		for(int i=0;i<savingAccountList.size();i+=11)
			if(acNo.equals(savingAccountList.get(i)))
			{
				for(int j=i;j<11;j++)
					temp.add(savingAccountList.get(i));
				break;
			}
		return temp;
	}
	
	protected static void closeAccount(String aNo)
	{
		boolean flag=false;
		for(int i=2;i<ATMAccountList.size();i+=3)
		{
			if(ATMAccountList.get(i).equals(aNo))
			{
				flag=true;
				for(int j=i;j<3;j++)
					ATMAccountList.set(j,"-1");
				break;
			}
		}
		for(int i=0;i<savingAccountList.size();i+=11)
		{
			if(savingAccountList.get(i).equals(aNo))
			{
				flag=true;
				for(int j=i;j<11+i;j++)
					savingAccountList.set(j,"-1");
				JOptionPane.showMessageDialog(null,"Account Closed Successfully....Withdraw Your Money !!");
				break;
			}
		}
		if(flag==false)
			JOptionPane.showMessageDialog(null,"Invaild Account Number !!");
	}
	
	protected static boolean isVaildDetail(String accNo,String passcod,String filename)
	{
		String temp1,temp2,temp3=null;
		boolean flag=false;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			int x=1;
			while((temp1=br.readLine())!=null)
			{
				if(x>=12)
					x%=11;
				if(x==1)
					temp3=temp1;
				else if(x==2)
				{
					temp2=temp1;
					if(accNo.equals(temp3) && passcod.equals(temp2))
						flag=true;
				}
				x++;
			}
			br.close();
			return flag;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	protected static void readATMData()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("ATMDataBase.txt")));
			System.out.println("ATM Card No : "+br.readLine());
			System.out.println("Pin : "+br.readLine());
			br.readLine();
			System.out.println("ATM Card No : "+br.readLine());
			System.out.println("Pin : "+br.readLine());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	protected static void readData(String filename)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			System.out.println("Account No : " +br.readLine());
			System.out.println("Password : " +br.readLine());
			int cnt=2;
			while(cnt!=11)
			{
				br.readLine();
				cnt++;
			}
			System.out.println("Account No : " +br.readLine());
			System.out.println("Password : " +br.readLine());
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new Database();
	}
}


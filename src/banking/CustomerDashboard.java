package banking;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class CustomerDashboard implements ActionListener
{
	protected Database db = Database.getnewDB();
	protected JFrame CustFrame;
	private JTextField field1,field2,field3,field4,field5,field6,field7,field8,field9;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13;
	private JButton depositbtn,withdrawbtn,transferbtn,paybillbtn,balEnq,passChangebtn,closebtn,logbtn;
	private ArrayList<String>list = new ArrayList<String>();
	
	CustomerDashboard(String id)
	{
		CustFrame = new JFrame();
		CustFrame.getContentPane().setLayout(null);
		
		addLabelAndFields();
	
		getDetails(id);
		
		addButton();
		
		CustFrame.getContentPane().setBackground(new Color(245, 245, 245));
		CustFrame.setSize(1073,755);
        CustFrame.setLocation(200,50 );
        CustFrame.setVisible(true);
		
	}
	
	private void addLabelAndFields()
	{
		label1 = new JLabel("CONSUMER LOGS");
		label1.setForeground(new Color(0, 0, 255));
		label1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		label1.setBounds(40, 32, 291, 58);
		CustFrame.getContentPane().add(label1);
		
		label2 = new JLabel("WELCOME ");
		label2.setForeground(new Color(0, 0, 255));
		label2.setFont(new Font("Times New Roman", Font.BOLD, 32));
		label2.setBounds(804, 32, 183, 58);
		CustFrame.getContentPane().add(label2);
		
		label3 = new JLabel("PERSONAL CREDENTIALS");
		label3.setForeground(new Color(0, 0, 255));
		label3.setFont(new Font("Times New Roman", Font.BOLD, 32));
		label3.setBounds(307, 163, 424, 58);
		CustFrame.getContentPane().add(label3);
		
		label4 = new JLabel("NAME");
		label4.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label4.setBounds(45, 249, 72, 31);
		CustFrame.getContentPane().add(label4);
		
		label5 = new JLabel("DoB");
		label5.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label5.setBounds(45, 293, 72, 31);
		CustFrame.getContentPane().add(label5);
		
		label6 = new JLabel("GENDER");
		label6.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label6.setBounds(45, 334, 103, 31);
		CustFrame.getContentPane().add(label6);
		
		label7 = new JLabel("ADDRESS");
		label7.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label7.setBounds(45, 375, 103, 31);
		CustFrame.getContentPane().add(label7);
		
		label8 = new JLabel("CITY");
		label8.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label8.setBounds(555, 334, 56, 31);
		CustFrame.getContentPane().add(label8);
		
		label9 = new JLabel("STATE");
		label9.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label9.setBounds(555, 293, 72, 31);
		CustFrame.getContentPane().add(label9);
		
		label10 = new JLabel("YOUR ACCOUNT NUMBER");
		label10.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label10.setBounds(171, 102, 275, 31);
		CustFrame.getContentPane().add(label10);
		
		label11 = new JLabel("PHONE NO");
		label11.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label11.setBounds(555, 252, 122, 31);
		CustFrame.getContentPane().add(label11);
		
		label12 = new JLabel("MY FUNCTIONS : ");
		label12.setForeground(new Color(255, 0, 0));
		label12.setFont(new Font("Times New Roman", Font.BOLD, 28));
		label12.setHorizontalAlignment(SwingConstants.CENTER);
		label12.setBounds(41, 445, 248, 89);
		CustFrame.getContentPane().add(label12);
		
		label13 = new JLabel("PIN CODE");
		label13.setFont(new Font("Times New Roman", Font.BOLD, 21));
		label13.setBounds(555, 375, 122, 31);
		CustFrame.getContentPane().add(label13);
		
	}
	
	private void addButton()
	{
		
		depositbtn = new JButton("DEPOSIT");
		depositbtn.setBounds(51, 544, 147, 33);
		depositbtn.setForeground(new Color(255, 255, 255));
		depositbtn.setBackground(new Color(0, 128, 0));
		depositbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		CustFrame.getContentPane().add(depositbtn);
		
		withdrawbtn = new JButton("WITHDRAW");
		withdrawbtn.setForeground(new Color(255, 255, 255));
		withdrawbtn.setBackground(new Color(0, 128, 0));
		withdrawbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		withdrawbtn.setBounds(517, 542, 214, 37);
		CustFrame.getContentPane().add(withdrawbtn);
		
		balEnq = new JButton("KNOW BALANCE");
		balEnq.setForeground(new Color(255, 255, 255));
		balEnq.setBackground(new Color(0, 128, 0));
		balEnq.setFont(new Font("Times New Roman", Font.BOLD, 21));
		balEnq.setBounds(517, 608, 214, 37);
		CustFrame.getContentPane().add(balEnq);
		
		paybillbtn = new JButton("PAY BILL");
		paybillbtn.setForeground(new Color(255, 255, 255));
		paybillbtn.setBackground(new Color(0, 128, 0));
		paybillbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		paybillbtn.setBounds(51, 608, 147, 37);
		CustFrame.getContentPane().add(paybillbtn);
		
		transferbtn = new JButton("TRANSFER MONEY");
		transferbtn.setForeground(new Color(255, 255, 255));
		transferbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		transferbtn.setBackground(new Color(0, 128, 0));
		transferbtn.setBounds(231, 608, 248, 37);
		CustFrame.getContentPane().add(transferbtn);
		
		closebtn = new JButton("CLOSE ACCOUNT");
		closebtn.setForeground(Color.WHITE);
		closebtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		closebtn.setBackground(new Color(0, 128, 0));
		closebtn.setBounds(764, 542, 248, 37);
		CustFrame.getContentPane().add(closebtn);
		
		logbtn = new JButton("LOG OUT");
		logbtn.setForeground(new Color(255, 255, 255));
		logbtn.setBackground(new Color(0, 128, 0));
		logbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		logbtn.setBounds(764, 608, 245, 37);
		CustFrame.getContentPane().add(logbtn);
		
		passChangebtn = new JButton("PASSWORD CHANGE");
		passChangebtn.setForeground(Color.WHITE);
		passChangebtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		passChangebtn.setBackground(new Color(0, 128, 0));
		passChangebtn.setBounds(231, 541, 248, 37);
		CustFrame.getContentPane().add(passChangebtn);
		
		
		depositbtn.addActionListener(this);
        withdrawbtn.addActionListener(this);
        balEnq.addActionListener(this);
        paybillbtn.addActionListener(this);
        logbtn.addActionListener(this);
        transferbtn.addActionListener(this);
        passChangebtn.addActionListener(this);
        closebtn.addActionListener(this);
        
	}
	
	private void getDetails(String id)
	{
		String temp1;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("SavingAccountDataBase.txt")));
			int x=1;
			while((temp1=br.readLine())!=null)
			{
				if(x>=12)
					x%=11;
				if(temp1.equals(id))
				{
					list.add(temp1);
					temp1=br.readLine();
					while(x!=11)
					{	
						list.add(temp1);
						x++;
						temp1=br.readLine();
					}
					break;
				}
				else
				{
					while(x!=11)
					{
						x++;
						temp1=br.readLine();
					}
				}
				x++;
			}
			field1 = new JTextField(list.get(3));
			field1.setBackground(new Color(255, 255, 255));
			field1.setFont(new Font("Tahoma", Font.BOLD, 14));
			field1.setEditable(false);
			field1.setBounds(162, 252, 309, 31);
			field1.setColumns(10);
			CustFrame.getContentPane().add(field1);
				
			field2 = new JTextField(list.get(5));
			field2.setBackground(new Color(255, 255, 255));
			field2.setFont(new Font("Tahoma", Font.BOLD, 14));
			field2.setEditable(false);
			field2.setColumns(10);
			field2.setBounds(162, 375, 309, 31);
			CustFrame.getContentPane().add(field2);
				
			field3 = new JTextField(list.get(6));
			field3.setBackground(new Color(255, 255, 255));
			field3.setFont(new Font("Tahoma", Font.BOLD, 14));
			field3.setEditable(false);
			field3.setColumns(10);
			field3.setBounds(678, 337, 309, 31);
			CustFrame.getContentPane().add(field3);
				
			field4 = new JTextField(list.get(0));
			field4.setBackground(new Color(255, 255, 255));
			field4.setFont(new Font("Tahoma", Font.BOLD, 14));
			field4.setEditable(false);
			field4.setColumns(10);
			field4.setBounds(456, 100, 356, 37);
			CustFrame.getContentPane().add(field4);
				
			field5 = new JTextField(list.get(8));
			field5.setBackground(new Color(255, 255, 255));
			field5.setFont(new Font("Tahoma", Font.BOLD, 14));
			field5.setEditable(false);
			field5.setColumns(10);
			field5.setBounds(678, 252, 309, 31);
			CustFrame.getContentPane().add(field5);
				
			field6 = new JTextField(list.get(10));
			field6.setBackground(new Color(255, 255, 255));
			field6.setFont(new Font("Tahoma", Font.BOLD, 14));
			field6.setEditable(false);
			field6.setColumns(10);
			field6.setBounds(162, 334, 309, 31);
			CustFrame.getContentPane().add(field6);
				
			field7 = new JTextField(list.get(4));
			field7.setBackground(new Color(255, 255, 255));
			field7.setFont(new Font("Tahoma", Font.BOLD, 14));
			field7.setEditable(false);
			field7.setColumns(10);
			field7.setBounds(162, 293, 309, 31);
			CustFrame.getContentPane().add(field7);
				
			field8 = new JTextField(list.get(7));
			field8.setBackground(new Color(255, 255, 255));
			field8.setFont(new Font("Tahoma", Font.BOLD, 14));
			field8.setEditable(false);
			field8.setColumns(10);
			field8.setBounds(678, 293, 309, 31);
			CustFrame.getContentPane().add(field8);
				
			field9 = new JTextField(list.get(9));
			field9.setBackground(new Color(255, 255, 255));
			field9.setFont(new Font("Tahoma", Font.BOLD, 14));
			field9.setEditable(false);
			field9.setColumns(10);
			field9.setBounds(678, 378, 309, 31);
			CustFrame.getContentPane().add(field9);
				
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==depositbtn)
		{
			String str=JOptionPane.showInputDialog("Enter Deposit Money : ");
			Account.balance=Double.parseDouble(list.get(2));
			Account.balance=Account.deposit(Double.parseDouble(str),Account.balance);
			list.set(2,String.valueOf(Account.balance));
			Database.modifyAccount(list,"Saving Account");
		}
		
		else if(e.getSource()==withdrawbtn)
		{
			String str=JOptionPane.showInputDialog("Withdraw Amount : ");
			Account.balance=Double.parseDouble(list.get(2));
			Account.balance=Account.withdraw(Double.parseDouble(str),Account.balance);
			list.set(2,String.valueOf(Account.balance));
			Database.modifyAccount(list,"Saving Account");
		}
		
		else if(e.getSource()==balEnq)
			JOptionPane.showMessageDialog(null,"Your Account Balance : "+list.get(2),"BALANCE ENQUIRY",JOptionPane.INFORMATION_MESSAGE );
		
		else if(e.getSource()==transferbtn)
		{
			JPanel panel = new JPanel(new GridLayout(2,2));
			JLabel label1 = new JLabel("Enter Beneficary Account Number : ");
		    JTextField text1,text2;
		    text1 = new JTextField();
		    JLabel label2 = new JLabel("Enter Amount : ");
		    text2 = new JTextField();
		    panel.add(label1);
		    panel.add(text1);
		    panel.add(label2);
		    panel.add(text2);
		    JOptionPane.showMessageDialog(null, panel);
		    if(text1.getText().equals(list.get(0)))
				JOptionPane.showMessageDialog(null,"Cannot transfer to own account number !!","ERROR",JOptionPane.INFORMATION_MESSAGE );
		    else
		    	list.set(2,Database.validTransfer(list.get(0),text1.getText(),text2.getText()));
		}
		
		else if(e.getSource()==passChangebtn)
		{
			JPanel panel = new JPanel(new GridLayout(3,2));
			JLabel label1 = new JLabel("Enter Old Password : ");
		    JTextField text1,text2,text3;
		    text1 = new JTextField();
		    JLabel label2 = new JLabel("Enter New Password : ");
		    text2 = new JTextField();
		    JLabel label3 = new JLabel("Re-enter New Password : ");
		    text3 = new JTextField();
		    panel.add(label1);
		    panel.add(text1);
		    panel.add(label2);
		    panel.add(text2);
		    panel.add(label3);
		    panel.add(text3);
		    JOptionPane.showMessageDialog(null, panel);
		    if(text1.getText().equals(list.get(1)) && text2.getText().equals(text3.getText()))
		    {
		    	list.set(1,text2.getText());
		    	Database.modifyAccount(list,"Saving Account");
		    	JOptionPane.showMessageDialog(null,"Password Changed Successfully !!");
		    }
		    else
		    	JOptionPane.showMessageDialog(null,"Invalid Old Pin or New Passwords do not match !!");
		}
		
		else if(e.getSource()==paybillbtn)
		{
			JPanel panel = new JPanel(new GridLayout(2,2));
			JLabel label1 = new JLabel("Enter Bill ID : ");
		    JTextField text1,text2;
		    text1 = new JTextField();
		    JLabel label2 = new JLabel("Enter Bill Amount : ");
		    text2 = new JTextField();
		    panel.add(label1);
		    panel.add(text1);
		    panel.add(label2);
		    panel.add(text2);
		    JOptionPane.showMessageDialog(null, panel);
		    Account.balance=Double.parseDouble(list.get(2));
			Account.balance=Account.withdraw(Double.parseDouble(text2.getText()),Account.balance);
			list.set(2,String.valueOf(Account.balance));
			Database.modifyAccount(list,"Saving Account");
		}
		
		else if(e.getSource()==closebtn)
		{
			Database.closeAccount(list.get(0));
			list.clear();
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			CustFrame.setVisible(false);
		}
		
		else if(e.getSource()==logbtn)
		{
			list.clear();
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			CustFrame.setVisible(false);
		}
	}
}
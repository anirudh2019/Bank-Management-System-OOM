package banking;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;


public class ATM implements ActionListener
{
	protected JFrame jFrame1;
	private JLabel label1,label2,label3,label4,label5;
	private JTextField txtField1,txtField2,txtField3;
	private JButton pinChange,withdrawbtn,depositbtn,balEnq,logbtn;
	private ArrayList<String>list = new ArrayList<String>();
	private ArrayList<String>list1 = new ArrayList<String>();

	ATM(String id,String atm)
	{
		jFrame1 = new JFrame();
		jFrame1.getContentPane().setLayout(null);
		jFrame1.getContentPane().setBackground(new Color(255, 250, 250));
		
		addLabel();
		
		getDetails(id,atm);
		
		addButton();
		
		
		jFrame1.setSize(970,677);
        jFrame1.setLocation(500,90);
        jFrame1.setVisible(true);
        
	}
	
	private void addLabel()
	{
		label1 = new JLabel("WELCOME TO ATM SERVICES");
		label1.setForeground(Color.RED);
		label1.setBackground(Color.WHITE);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		label1.setBounds(33, 10, 511, 74);
		jFrame1.getContentPane().add(label1);
		
		label2 = new JLabel("ACCOUNT NO : ");
		label2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label2.setBounds(42, 226, 149, 46);
		jFrame1.getContentPane().add(label2);
		
		label3 = new JLabel("NAME : ");
		label3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label3.setBounds(42, 114, 137, 46);
		jFrame1.getContentPane().add(label3);
		
		label5 = new JLabel("ATM CARD NO :");
		label5.setFont(new Font("Tahoma", Font.BOLD, 18));
		label5.setBounds(42, 170, 149, 46);
		jFrame1.getContentPane().add(label5);
		
		label4 = new JLabel(new ImageIcon("BANKING IMAGES\\IMG3.jpg"));
		label4.setBounds(42, 311, 502, 297);
		jFrame1.getContentPane().add(label4);
	}
	
	private void addButton()
	{
		balEnq = new JButton("BALANCE ENQUIRY");
		balEnq.setBounds(646, 360, 260, 58);
		jFrame1.getContentPane().add(balEnq);
		balEnq.setForeground(new Color(255, 255, 255));
		balEnq.setBackground(new Color(0, 128, 0));
		balEnq.setFont(new Font("Times New Roman", Font.BOLD, 21));
		
		depositbtn = new JButton("DEPOSIT MONEY");
		depositbtn.setBounds(646, 114, 260, 58);
		jFrame1.getContentPane().add(depositbtn);
		depositbtn.setBackground(new Color(0, 128, 0));
		depositbtn.setForeground(new Color(255, 255, 255));
		depositbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		
		withdrawbtn = new JButton("WITHDRAW CASH");
		withdrawbtn.setBounds(646, 193, 260, 58);
		jFrame1.getContentPane().add(withdrawbtn);
		withdrawbtn.setForeground(new Color(255, 255, 255));
		withdrawbtn.setBackground(new Color(0, 128, 0));
		withdrawbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		
		pinChange = new JButton("PIN CHANGE");
		pinChange.setBounds(646, 277, 260, 58);
		jFrame1.getContentPane().add(pinChange);
		pinChange.setBackground(new Color(0, 128, 0));
		pinChange.setForeground(new Color(255, 255, 255));
		pinChange.setFont(new Font("Times New Roman", Font.BOLD, 21));
		
		logbtn = new JButton("LOGOUT");
		logbtn.setForeground(Color.WHITE);
		logbtn.setFont(new Font("Times New Roman", Font.BOLD, 21));
		logbtn.setBackground(new Color(0, 128, 0));
		logbtn.setBounds(646, 550, 260, 58);
		jFrame1.getContentPane().add(logbtn);
        
        logbtn.addActionListener(this);
        depositbtn.addActionListener(this);
        balEnq.addActionListener(this);
        withdrawbtn.addActionListener(this);
        pinChange.addActionListener(this);
	}
	
	private void getDetails(String id,String atm)
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
			list1=Database.loadATM(atm);
			
			txtField1 = new JTextField(list.get(3));
			txtField1.setBackground(Color.WHITE);
			txtField1.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtField1.setColumns(10);
			txtField1.setBounds(211, 116, 333, 46);
			txtField1.setEditable(false);
			jFrame1.getContentPane().add(txtField1);
			
			txtField2 = new JTextField(list1.get(0));
			txtField2.setBackground(Color.WHITE);
			txtField2.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtField2.setColumns(10);
			txtField2.setBounds(211, 172, 333, 46);
			txtField2.setEditable(false);
			jFrame1.getContentPane().add(txtField2);
			
			txtField3 = new JTextField(list.get(0));
			txtField3.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtField3.setEditable(false);
			txtField3.setColumns(10);
			txtField3.setBackground(Color.WHITE);
			txtField3.setBounds(211, 228, 333, 46);
			jFrame1.getContentPane().add(txtField3);
			
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
		else if(e.getSource()==pinChange)
		{
			JPanel panel = new JPanel(new GridLayout(3,2));
			JLabel label1 = new JLabel("Enter Old Pin: ");
			JLabel label2 = new JLabel("Enter New Pin: ");
			JLabel label3 = new JLabel("Re-enter New Pin: ");
			JTextField text1,text2,text3;
			text1 = new JTextField();
			text2 = new JTextField();
			text3 = new JTextField();
			panel.add(label1);
			panel.add(text1);
			panel.add(label2);
			panel.add(text2);
			panel.add(label3);
			panel.add(text3);
		    JOptionPane.showMessageDialog(null, panel);
		    if(text1.getText().equals(list1.get(1)) && text2.getText().equals(text3.getText()))
		    {
		    	list1.set(1,text2.getText());
		    	Database.modifyATMPin(list1);
		    	JOptionPane.showMessageDialog(null,"Pin Changed Successfully !!");
		    }
		    else
		    	JOptionPane.showMessageDialog(null,"Incorrect old Pin Entered or New Pins do not match !!");


		}
		else if(e.getSource()==logbtn)
		{
			list.clear();
			list1.clear();
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			jFrame1.setVisible(false);
		}
	}
}

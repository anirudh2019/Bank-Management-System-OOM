package banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerLogin implements ActionListener
{
	protected JFrame xframe;
	private JLabel label,label1,label2,label3,label4,label5,label6;
	private JTextField textField;
	private JPasswordField passcode;
	private JButton loginbtn,loanbtn,createbtn,backbtn;
	private JComboBox<String> comboBox = new JComboBox<String>();
	
	CustomerLogin()
	{
		xframe = new JFrame();
		xframe.getContentPane().setLayout(null);
		xframe.getContentPane().setBackground(new Color(245, 245, 245));
		
		addLabelAndFields();
        
        addButton();
        
        xframe.setSize(835,632);
        xframe.setLocation(500,90);
        xframe.setVisible(true);
        
        printAccounts();
        
	}
	
	private void addLabelAndFields()
	{
		label = new JLabel("Welcomer Customer !!");
        label.setBounds(33,25,338,60);
        label.setForeground(Color.RED);
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        xframe.getContentPane().add(label);
        
        label1 = new JLabel("Account Number : ");
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(33, 239, 191, 36);
        xframe.getContentPane().add(label1);
        
        label2 = new JLabel("Password : ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setBounds(33, 301, 124, 36);
        xframe.getContentPane().add(label2);
        
        label3 = new JLabel("Account Type : ");
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setBounds(33, 359, 165, 36);
        xframe.getContentPane().add(label3);
        
        label4 = new JLabel(new ImageIcon("BANKING IMAGES\\IMG2.jpg"));
        label4.setBounds(474, 10, 312, 193);
        xframe.getContentPane().add(label4);
        
        label5 = new JLabel("New label");
        label5.setIcon(new ImageIcon("BANKING IMAGES\\ICON1.png"));
        label5.setBounds(614, 243, 34, 36);
        xframe.getContentPane().add(label5);
        
        label6 = new JLabel("New label");
        label6.setIcon(new ImageIcon("BANKING IMAGES\\ICON2.png"));
        label6.setBounds(614, 305, 34, 36);
        xframe.getContentPane().add(label6);
        
        textField = new JTextField();
        textField.setBounds(234, 244, 371, 36);
        xframe.getContentPane().add(textField);
        textField.setColumns(10);
        
        passcode = new JPasswordField();
        passcode.setBounds(234, 306, 370, 36);
        xframe.getContentPane().add(passcode);
        comboBox.setBackground(Color.WHITE);
        
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT ACCOUNT TYPE", "SAVING ACCOUNT", "LOAN ACCOUNT"}));
        comboBox.setBounds(234, 364, 371, 34);
        xframe.getContentPane().add(comboBox);
	}
	
	private void addButton()
	{
		loginbtn = new JButton("LOGIN");
        loginbtn.setBackground(new Color(0, 128, 0));
        loginbtn.setForeground(new Color(255, 255, 255));
        loginbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        loginbtn.setBounds(187, 440, 177, 41);
        xframe.getContentPane().add(loginbtn);
        
        createbtn = new JButton("CREATE ACCOUNT");
        createbtn.setForeground(new Color(255, 255, 255));
        createbtn.setBackground(new Color(0, 128, 0));
        createbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        createbtn.setBounds(449, 440, 222, 41);
        xframe.getContentPane().add(createbtn);
        
        backbtn = new JButton("BACK");
        backbtn.setForeground(new Color(255, 255, 255));
        backbtn.setBackground(new Color(0, 128, 0));
        backbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        backbtn.setBounds(187,507,177, 41);
        xframe.getContentPane().add(backbtn);
        
        loanbtn = new JButton("APPLY FOR LOAN");
        loanbtn.setForeground(new Color(255, 255, 255));
        loanbtn.setBackground(new Color(0, 128, 0));
        loanbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        loanbtn.setBounds(449, 507, 222, 41);
        xframe.getContentPane().add(loanbtn);
        
        backbtn.addActionListener(this);
        loginbtn.addActionListener(this);
        loanbtn.addActionListener(this);
        createbtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginbtn)
		{
			if(comboBox.getSelectedItem().equals("SAVING ACCOUNT"))
			{
				if(Database.isVaildDetail(textField.getText(),passcode.getText(),"SavingAccountDataBase.txt")==true)
				{
					new CustomerDashboard(textField.getText()).CustFrame.setVisible(true);
					xframe.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Account Number or Password !!");
			}
			else if(comboBox.getSelectedItem().equals("LOAN ACCOUNT"))
			{
				if(Database.isVaildDetail(textField.getText(),passcode.getText(),"LoanAccountDataBase.txt")==true)
				{
					new LoanDashboard(textField.getText()).theloanFrame.setVisible(true);
					xframe.setVisible(false);
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Account Number or Password !!");
			}
			else
				JOptionPane.showMessageDialog(null, "Please Select the Account Type");
		}
		else if(e.getSource()==createbtn)
		{
			new CreateAccount().newFrame.setVisible(true);
			xframe.setVisible(false);
		}
		else if(e.getSource()==backbtn)
		{
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			xframe.setVisible(false);
		}
		else if(e.getSource()==loanbtn)
		{
			new LoanApplication().loanFrame.setVisible(true);
			xframe.setVisible(false);
		}
	}
	
	private void printAccounts()
	{
		System.out.println("Following are some sample account no. and password pairs for use :");
		System.out.println("Saving Account Entities : ");
		Database.readData("SavingAccountDataBase.txt");
		System.out.println("\nLoan Account Entities : ");
		Database.readData("LoanAccountDataBase.txt");
	}
}

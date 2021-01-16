package banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMAuthentication implements ActionListener
{
	protected JFrame ATMFrame;
	private JLabel label1,label2,label3,label4,label5;
	private JTextField textField;
	private JPasswordField passcode;
	private JButton loginbtn,backbtn,exitbtn;
	
	ATMAuthentication()
	{
		ATMFrame = new JFrame();
		ATMFrame.getContentPane().setLayout(null);
		
		addLabelAndFields();
        
        addButton();
        
		ATMFrame.getContentPane().setBackground(new Color(245, 245, 245));
        ATMFrame.setSize(757,703);
        ATMFrame.setLocation(500,90);
        ATMFrame.setVisible(true);
        
        printAccounts();
        
	}
	
	private void addLabelAndFields()
	{
		label1 = new JLabel("ATM CARD : ");
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(70, 415, 131, 36);
        ATMFrame.getContentPane().add(label1);
        
        label2 = new JLabel("PIN  NO : ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setBounds(70, 483, 105, 36);
        ATMFrame.getContentPane().add(label2);
        
        label3 = new JLabel(new ImageIcon("BANKING IMAGES\\IMG4.jpg"));
        label3.setBounds(117, 32, 526, 341);
        ATMFrame.getContentPane().add(label3);
        
        label4 = new JLabel("New label");
		label4.setIcon(new ImageIcon("BANKING IMAGES\\ICON1.png"));
		label4.setBounds(592, 415, 31, 36);
		ATMFrame.getContentPane().add(label4);
		
		label5 = new JLabel("New label");
		label5.setIcon(new ImageIcon("BANKING IMAGES\\ICON2.png"));
		label5.setBounds(592, 483, 31, 36);
		ATMFrame.getContentPane().add(label5);
        
        textField = new JTextField();
        textField.setBounds(211, 415, 371, 36);
        ATMFrame.getContentPane().add(textField);
        textField.setColumns(10);
        
        passcode = new JPasswordField();
        passcode.setBounds(212, 483, 370, 36);
        ATMFrame.getContentPane().add(passcode);
	}
	
	private void addButton()
	{
		backbtn = new JButton("BACK");
        backbtn.setBackground(new Color(0, 128, 0));
        backbtn.setForeground(new Color(255, 255, 255));
        backbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        backbtn.setBounds(73, 583, 177, 41);
        ATMFrame.getContentPane().add(backbtn);
        
        loginbtn = new JButton("LOGIN");
        loginbtn.setBackground(new Color(0, 128, 0));
        loginbtn.setForeground(new Color(255, 255, 255));
        loginbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        loginbtn.setBounds(301, 583, 177, 41);
        ATMFrame.getContentPane().add(loginbtn);
        
        exitbtn = new JButton("EXIT");
        exitbtn.setForeground(new Color(255, 255, 255));
        exitbtn.setBackground(new Color(0, 128, 0));
        exitbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        exitbtn.setBounds(520, 583, 177, 41);
        ATMFrame.getContentPane().add(exitbtn);

        loginbtn.addActionListener(this);
        backbtn.addActionListener(this);
        exitbtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginbtn)
		{
			String id=Database.isValidATMDetail(textField.getText(),passcode.getText());
			if(id.equals("-1"))
				JOptionPane.showMessageDialog(null, "Invalid ATM card No or PIN !!");
			else
			{
				new ATM(id,textField.getText()).jFrame1.setVisible(true);
				ATMFrame.setVisible(false);
			}
		}
		else if(e.getSource()==backbtn)
		{
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			ATMFrame.setVisible(false);
		}
		else if(e.getSource()==exitbtn)
			System.exit(0);
	}
	
	private void printAccounts()
	{
		System.out.println("Following are some sample ATM Card no. and Pin for use :");
		Database.readATMData();
	}
}

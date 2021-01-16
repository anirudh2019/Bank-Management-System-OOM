package banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeLogin implements ActionListener
{
	protected JFrame frame;
	private JLabel label,label1,label2,label3,label4,label5;
	private JTextField textField;
	private JPasswordField passcode;
	private JButton loginbtn,exitbtn,backbtn;
	
	EmployeeLogin()
	{
		frame = new JFrame();
		frame.getContentPane().setLayout(null);		
		addLabelAndField();
        
        addButton();
        
		frame.getContentPane().setBackground(new Color(245, 245, 245));
        frame.setSize(739,531);
        frame.setLocation(500,90);
        frame.setVisible(true);
        
        printAccounts();
        
	}
	
	private void addLabelAndField()
	{
		label = new JLabel("Welcomer Admin !!");
        label.setBounds(392,46,276,60);
        label.setForeground(Color.RED);
        label.setFont(new Font("Dialog", Font.BOLD, 30));
        frame.getContentPane().add(label);
        
        label1 = new JLabel("Employee ID : ");
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(33, 267, 153, 36);
        frame.getContentPane().add(label1);
        
        label2 = new JLabel("Password : ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setBounds(33, 326, 140, 36);
        frame.getContentPane().add(label2);
        
        label3 = new JLabel(new ImageIcon("BANKING IMAGES\\IMG1.jpg"));
        label3.setBounds(33, 31, 286, 182);
        frame.getContentPane().add(label3);
        
        label4 = new JLabel("New label");
		label4.setIcon(new ImageIcon("BANKING IMAGES\\\\ICON1.png"));
		label4.setBounds(578, 275, 31, 29);
		frame.getContentPane().add(label4);
		
		label5 = new JLabel("New label");
		label5.setIcon(new ImageIcon("BANKING IMAGES\\\\ICON2.png"));
		label5.setBounds(578, 334, 31, 29);
		frame.getContentPane().add(label5);
        
        textField = new JTextField();
        textField.setBounds(197, 272, 371, 36);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        passcode = new JPasswordField();
        passcode.setBounds(198, 331, 370, 36);
        frame.getContentPane().add(passcode);
	}
	
	private void addButton()
	{
		backbtn = new JButton("BACK");
        backbtn.setBackground(new Color(0, 128, 0));
        backbtn.setForeground(new Color(255, 255, 255));
        backbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        backbtn.setBounds(71, 408, 177, 41);
        frame.getContentPane().add(backbtn);
        
        loginbtn = new JButton("LOGIN");
        loginbtn.setBackground(new Color(0, 128, 0));
        loginbtn.setForeground(new Color(255, 255, 255));
        loginbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        loginbtn.setBounds(270, 408, 177, 41);
        frame.getContentPane().add(loginbtn);
        
        exitbtn = new JButton("EXIT");
        exitbtn.setForeground(new Color(255, 255, 255));
        exitbtn.setBackground(new Color(0, 128, 0));
        exitbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        exitbtn.setBounds(469, 408, 177, 41);
        frame.getContentPane().add(exitbtn);
        
        loginbtn.addActionListener(this);
        backbtn.addActionListener(this);
        exitbtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginbtn)
		{
			if(Database.isVaildDetail(textField.getText(),passcode.getText(),"EmployeeDataBase.txt")==true)
			{
				new EmployeeDashboard(textField.getText()).empFrame.setVisible(true);
				frame.setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid Employee ID or Password !!");
		}
		else if(e.getSource()==backbtn)
		{
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			frame.setVisible(false);
		}
		else if(e.getSource()==exitbtn)
			System.exit(0);
	}
	
	private void printAccounts()
	{
		System.out.println("Following are some sample Employee ID and Password pairs for use :");
		Database.readData("EmployeeDataBase.txt");
	}
}
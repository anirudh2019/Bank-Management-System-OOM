package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Authentication implements ActionListener
{
	protected JFrame theFrame;
	private JLabel label1,label2,label3;
    private JButton customerLogin,employeeLogin,helpbtn,ATMbtn;
    
	public Authentication()
	{
		theFrame = new JFrame();
		theFrame.getContentPane().setLayout(null);
	
		Database.loadDataBase();
		
		addLabel();
        
        addButton();
        
        theFrame.getContentPane().setBackground(new Color(245, 245, 245));
        theFrame.setSize(650,600);
        theFrame.setLocation(500,90);
        theFrame.setVisible(true);
        
	}

	private void addButton()
	{ 
		customerLogin = new JButton("CUSTOMER LOGIN");
        customerLogin.setFont(new Font("System", Font.BOLD, 18));
        customerLogin.setBackground(new Color(0, 128, 0));
        customerLogin.setForeground(Color.WHITE);
        customerLogin.setBounds(67,349,231,50);
        theFrame.getContentPane().add(customerLogin);
        
        employeeLogin = new JButton("EMPLOYEE LOGIN");
        employeeLogin.setForeground(Color.WHITE);
        employeeLogin.setFont(new Font("Dialog", Font.BOLD, 18));
        employeeLogin.setBackground(new Color(0, 128, 0));
        employeeLogin.setBounds(344, 349, 231, 50);
        theFrame.getContentPane().add(employeeLogin);
        
        helpbtn = new JButton("HELP");
        helpbtn.setForeground(Color.WHITE);
        helpbtn.setFont(new Font("Dialog", Font.BOLD, 18));
        helpbtn.setBackground(new Color(0, 128, 0));
        helpbtn.setBounds(344, 421, 231, 50);
        theFrame.getContentPane().add(helpbtn);
                
        ATMbtn = new JButton("USE ATM");
        ATMbtn.setForeground(Color.WHITE);
        ATMbtn.setFont(new Font("Dialog", Font.BOLD, 18));
        ATMbtn.setBackground(new Color(0, 128, 0));
        ATMbtn.setBounds(67, 421, 231, 50);
        theFrame.getContentPane().add(ATMbtn);
        
        customerLogin.addActionListener(this);
        employeeLogin.addActionListener(this);
        helpbtn.addActionListener(this);
        ATMbtn.addActionListener(this);
	}
	
	private void addLabel()
	{
		label1 = new JLabel("Authentication Page");
        label1.setBounds(237,26,338,60);
        label1.setForeground(Color.RED);
        label1.setFont(new Font("System", Font.BOLD, 35));
        theFrame.getContentPane().add(label1);
        
        label2 = new JLabel("Choose Your Option");
        label2.setBounds(181,244,300,60);
        label2.setForeground(Color.BLUE);
        label2.setFont(new Font("Dialog", Font.BOLD, 28));
        theFrame.getContentPane().add(label2);

        label3 = new JLabel("Welcome to the Bank Management System !!");
        label3.setForeground(Color.MAGENTA);
        label3.setBackground(new Color(255, 239, 213));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
        label3.setBounds(50, 140, 525, 76);
        theFrame.getContentPane().add(label3);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==customerLogin)
			new CustomerLogin().xframe.setVisible(true);

		else if(e.getSource()==employeeLogin)
			new EmployeeLogin().frame.setVisible(true);
		
		else if(e.getSource()==ATMbtn)
			new ATMAuthentication().ATMFrame.setVisible(true);
		
		else if(e.getSource()==helpbtn)
			new Help().helpFrame.setVisible(true);
		
		theFrame.setVisible(false);
	}
        
	public static void main(String[] args)
	{
		new Authentication().theFrame.setVisible(true);
	}
}
package banking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help implements ActionListener
{
	protected JFrame helpFrame;
	private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9;
	private JButton backbtn,exitbtn;
	
	Help()
	{
		helpFrame = new JFrame();
		helpFrame.getContentPane().setLayout(null);
		
        addLabel();
        
        addButton();
        
		helpFrame.getContentPane().setBackground(new Color(245, 245, 245));
        helpFrame.setSize(1040,604);
        helpFrame.setLocation(300,90);
        helpFrame.setVisible(true);
        
	}
	
	private void addLabel()
	{
		label = new JLabel("BANKING SUGGESSTIONS");
        label.setForeground(Color.RED);
        label.setFont(new Font("Tahoma", Font.BOLD, 40));
        label.setBounds(41, 103, 528, 58);
        helpFrame.getContentPane().add(label);
        
        label1 = new JLabel("HELP WINDOW !!");
        label1.setForeground(Color.RED);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(41, 210, 192, 21);
        helpFrame.getContentPane().add(label);
        
        label2 = new JLabel(new ImageIcon("BANKING IMAGES\\IMG5.jpg"));
        label2.setBounds(638, 10, 376, 388);
        helpFrame.getContentPane().add(label2);
        
        label3 = new JLabel("BANK IFSC CODE : 456573687");
        label3.setForeground(new Color(153, 50, 204));
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setBounds(41, 33, 323, 41);
        helpFrame.getContentPane().add(label3);
        
        label4 = new JLabel("1. Never share your Password or Card Number with others.");
        label4.setForeground(new Color(0, 0, 255));
        label4.setFont(new Font("Tahoma", Font.BOLD, 20));
        label4.setBounds(41, 193, 601, 41);
        helpFrame.getContentPane().add(label4);
        
        label5 = new JLabel("2. Bank never ask to update E-mail in your account.");
        label5.setForeground(new Color(0, 0, 255));
        label5.setFont(new Font("Tahoma", Font.BOLD, 20));
        label5.setBounds(41, 244, 601, 41);
        helpFrame.getContentPane().add(label5);
        
        label6 = new JLabel("3. Do not believe on fake calls.");
        label6.setForeground(new Color(0, 0, 255));
        label6.setFont(new Font("Tahoma", Font.BOLD, 20));
        label6.setBounds(41, 293, 601, 41);
        helpFrame.getContentPane().add(label6);
        
        label7 = new JLabel("4. For any help, visit the bank or call at 1800-7866-9876");
        label7.setForeground(new Color(0, 0, 255));
        label7.setFont(new Font("Tahoma", Font.BOLD, 20));
        label7.setBounds(41, 344, 586, 41);
        helpFrame.getContentPane().add(label7);
        
        label8 = new JLabel("Phone : 800-7866-9876     E-mail : onlineBank@gmail.com");
        label8.setForeground(new Color(255, 0, 0));
        label8.setFont(new Font("Tahoma", Font.BOLD, 20));
        label8.setBounds(41, 408, 601, 41);
        helpFrame.getContentPane().add(label8);
        
        label9 = new JLabel("Connect with us at : faceBook, Twitter, Instagram");
        label9.setForeground(new Color(255, 0, 0));
        label9.setFont(new Font("Tahoma", Font.BOLD, 20));
        label9.setBounds(41, 471, 601, 41);
        helpFrame.getContentPane().add(label9);
	}
	
	private void addButton()
	{
		backbtn = new JButton("BACK");
        backbtn.setBackground(new Color(0, 128, 0));
        backbtn.setForeground(new Color(255, 255, 255));
        backbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        backbtn.setBounds(744, 408, 177, 41);
        helpFrame.getContentPane().add(backbtn);
        
        exitbtn = new JButton("EXIT");
        exitbtn.setForeground(new Color(255, 255, 255));
        exitbtn.setBackground(new Color(0, 128, 0));
        exitbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        exitbtn.setBounds(744, 484, 177, 41);
        helpFrame.getContentPane().add(exitbtn);

        exitbtn.addActionListener(this);
        backbtn.addActionListener(this);
        
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==backbtn)
		{
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			helpFrame.setVisible(false);
		}
		if(e.getSource()==exitbtn)
			System.exit(0);
	}
}

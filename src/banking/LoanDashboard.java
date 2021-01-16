package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class LoanDashboard implements ActionListener
{
	protected Database db = Database.getnewDB();
	protected JFrame theloanFrame;
    private JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9;
    private JTextField txtField1,txtField2,txtField3,txtField4,txtField5,txtField6,txtField7,txtField8;
    private JButton logbtn;
	ArrayList<String>list = new ArrayList<String>();
    
	LoanDashboard(String id)
	{
		theloanFrame = new JFrame();
		theloanFrame.getContentPane().setLayout(null);
		
        addLabelAndFields();
        
        getDetails(id);
        
        addButton();

        theloanFrame.getContentPane().setBackground(new Color(245, 245, 245));
        theloanFrame.setSize(1030,636);
        theloanFrame.setLocation(300,90);
        theloanFrame.setVisible(true);
        
	}
	
	private void addLabelAndFields()
	{
		label = new JLabel("Welcome Applicant !!");
        label.setBounds(25,22,372,60);
        label.setForeground(Color.RED);
        label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 35));
        theloanFrame.getContentPane().add(label);
        
        label1 = new JLabel("NAME : ");
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setBounds(24, 145, 95, 27);
        theloanFrame.getContentPane().add(label1);
        
        label2 = new JLabel("ID NUMBER : ");
        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setBounds(25, 213, 136, 27);
        theloanFrame.getContentPane().add(label2);
        
        label3 = new JLabel("CURRENT LOAN STATUS");
        label3.setForeground(Color.RED);
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setBounds(221, 295, 301, 37);
        theloanFrame.getContentPane().add(label3);
        
        label4 = new JLabel("INSTALLMENT AMOUNT : ");
        label4.setFont(new Font("Tahoma", Font.BOLD, 20));
        label4.setBounds(25, 362, 254, 27);
        theloanFrame.getContentPane().add(label4);
        
        label5 = new JLabel("INSTALLMENTS REMAINING : ");
        label5.setFont(new Font("Tahoma", Font.BOLD, 20));
        label5.setBounds(25, 412, 312, 27);
        theloanFrame.getContentPane().add(label5);
        
        label6 = new JLabel("INTEREST RATE : ");
        label6.setFont(new Font("Tahoma", Font.BOLD, 20));
        label6.setBounds(29, 461, 190, 27);
        theloanFrame.getContentPane().add(label6);
        
        label7 = new JLabel("ACCOUNT NUMBER : ");
        label7.setFont(new Font("Tahoma", Font.BOLD, 20));
        label7.setBounds(422, 45, 236, 27);
        theloanFrame.getContentPane().add(label7);
        
        label8 = new JLabel("LOAN AMOUNT : ");
        label8.setFont(new Font("Tahoma", Font.BOLD, 20));
        label8.setBounds(475, 145, 172, 27);
        theloanFrame.getContentPane().add(label8);
        
        label9 = new JLabel("LOAN DURATION (in months) : ");
        label9.setFont(new Font("Tahoma", Font.BOLD, 20));
        label9.setBounds(473, 213, 312, 27);
        theloanFrame.getContentPane().add(label9);
        
	}
	
	private void addButton()
	{
		logbtn = new JButton("LOGOUT");
        logbtn.setFont(new Font("System", Font.BOLD, 18));
        logbtn.setBackground(new Color(0, 128, 0));
        logbtn.setForeground(Color.WHITE);
        logbtn.setBounds(676,491,231,50);
        theloanFrame.getContentPane().add(logbtn);
        logbtn.addActionListener(this);
	}
	
	private void getDetails(String id)
	{
		String temp1;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("LoanAccountDataBase.txt")));
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
			
			txtField1 = new JTextField(list.get(4));
			txtField1.setBackground(Color.WHITE);
			txtField1.setEditable(false);
			txtField1.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField1.setBounds(209, 147, 236, 32);
	        theloanFrame.getContentPane().add(txtField1);
	        txtField1.setColumns(10);
	        
	        txtField2 = new JTextField(list.get(10));
	        txtField2.setBackground(Color.WHITE);
	        txtField2.setEditable(false);
	        txtField2.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField2.setColumns(10);
	        txtField2.setBounds(209, 215, 236, 32);
	        theloanFrame.getContentPane().add(txtField2);
	        
	        txtField3 = new JTextField(list.get(0));
	        txtField3.setBackground(Color.WHITE);
	        txtField3.setEditable(false);
	        txtField3.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField3.setColumns(10);
	        txtField3.setBounds(668, 45, 277, 32);
	        theloanFrame.getContentPane().add(txtField3);
	        
	        txtField4 = new JTextField(list.get(2));
	        txtField4.setBackground(Color.WHITE);
	        txtField4.setEditable(false);
	        txtField4.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField4.setColumns(10);
	        txtField4.setBounds(791, 147, 211, 32);
	        theloanFrame.getContentPane().add(txtField4);
	        
	        txtField5 = new JTextField(list.get(3));
	        txtField5.setBackground(Color.WHITE);
	        txtField5.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField5.setEditable(false);
	        txtField5.setColumns(10);
	        txtField5.setBounds(791, 213, 211, 32);
	        theloanFrame.getContentPane().add(txtField5);
	        
	        txtField6 = new JTextField(Double.toString(LoanAccount.getInstallmentAmount(Double.parseDouble(txtField4.getText()),txtField5.getText())));
	        txtField6.setEditable(false);
	        txtField6.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField6.setColumns(10);
	        txtField6.setBackground(Color.WHITE);
	        txtField6.setBounds(356, 364, 267, 32);
	        theloanFrame.getContentPane().add(txtField6);
	        
	        txtField7 = new JTextField(txtField5.getText());
	        txtField7.setEditable(false);
	        txtField7.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField7.setColumns(10);
	        txtField7.setBackground(Color.WHITE);
	        txtField7.setBounds(356, 414, 267, 32);
	        theloanFrame.getContentPane().add(txtField7);
	        
	        txtField8 = new JTextField(Double.toString(LoanAccount.interestRate));
	        txtField8.setEditable(false);
	        txtField8.setFont(new Font("Tahoma", Font.BOLD, 14));
	        txtField8.setColumns(10);
	        txtField8.setBackground(Color.WHITE);
	        txtField8.setBounds(356, 469, 267, 32);
	        theloanFrame.getContentPane().add(txtField8);
	        
	        br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==logbtn)
		{
			list.clear();
			Database.saveDataBase();
			new Authentication().theFrame.setVisible(true);
			theloanFrame.setVisible(false);
		}
	}
}
